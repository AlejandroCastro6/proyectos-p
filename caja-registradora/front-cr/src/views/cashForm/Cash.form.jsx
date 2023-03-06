import {submitItems} from "../../actions/cartAction";
import TextField from "@mui/material/TextField";
import React, {useState} from "react";
import {useDispatch, useSelector} from "react-redux";
import {FormControl} from "@mui/material";
import Grid from '@mui/material/Unstable_Grid2';
import NumericFormatCustom from '../../component/Inputs/NumericFormatCustom'

const CashForm = () => {
  const state = useSelector((state) => state.cartReducer);
  const dispatch = useDispatch();
  const [cashIn, setCashIn] = useState()
  const [description, setDescription] = useState('')
  const [cashOut, setCashOut] = useState()
  const [subTotal, setSubTotal] = useState(0)
  const [transactions, setTransactions] = useState([])
  const handleChangeCashIn = (event) => {
    setCashIn(event.target.value)
  };
  const handleChangeDescription = (event) => {
    setDescription(event.target.value)
  };
  const handleChangeCashOut = (event) => {
    setCashOut(event.target.value)
  };

  const addSubTotal = (value) => {
    setTransactions([...transactions, {value: value, description: description, transactionType: 'IN'}])
    const calc = subTotal + parseInt(value)
    setSubTotal(calc)
    setCashIn('')
    setDescription('')
  };
  const subtractSubTotal = (value) => {
    setTransactions([...transactions, {value: value, description: description, transactionType: 'OUT'}])
    const calc = subTotal - parseInt(value)
    setSubTotal(calc)
    setCashOut('')
    setDescription('')
  };

  const resetFields = () => {
    setTransactions([])
    setSubTotal(0)
    setCashOut('')
    setCashIn('')
    setDescription('')
    console.log(" botrreo todo", transactions, "--", subTotal, "--")
  };
  return (
    <Grid container spacing={3} sx={{flexGrow: 1}}>
      <Grid xs={6} xsOffset={3} md={2} mdOffset={2}>
        <button
          onClick={() => {
            addSubTotal(cashIn)
          }}
          className="blue"
        >
          Sumar
        </button>
      </Grid>
      <Grid xs={4} xsOffset={4} md={2} mdOffset={4}>
        <button
          // disabled={state.numOfItems <= 0}
          onClick={() => {
            subtractSubTotal(cashOut)
            // dispatch(deleteItem());
          }}
          className="orange"
        >
          Restar
        </button>
      </Grid>
      <Grid xs={6} xsOffset={3} md={2} mdOffset={2}>
        <FormControl fullWidth sx={{m: 1}}>
          <TextField
            label="Valor ingreso"
            value={cashIn}
            onChange={handleChangeCashIn}
            name="numberformat"
            id="formatted-numberformat-input"
            InputProps={{
              inputComponent: NumericFormatCustom,
            }}
            variant="outlined"
          />
        </FormControl>
      </Grid>
      <Grid xs={6} xsOffset={3} md={2} mdOffset={1}>
        <FormControl fullWidth sx={{m: 1}}>
          <TextField
            label="Descripcion"
            value={description}
            onChange={handleChangeDescription}
            name="descritpion"
            id="formatted-descroption"
            variant="outlined"
          />
        </FormControl>
      </Grid>
      <Grid xs={4} xsOffset={4} md={2} mdOffset={1}>
        <FormControl fullWidth sx={{m: 1}}>
          <TextField
            label="Valor egreso"
            value={cashOut}
            onChange={handleChangeCashOut}
            name="numberformat2"
            id="formatted-numberformat-input-exit"
            InputProps={{
              inputComponent: NumericFormatCustom,
            }}
            variant="outlined"
          />
        </FormControl>
      </Grid>
      <Grid xs={4} xsOffset={4} md={2} mdOffset={5}>
        <button
          // disabled={state.numOfItems <= 0}
          onClick={ () => {
            console.log(" ya me canse")
            dispatch(submitItems(transactions))
            console.log(" ya me canse dedspues")
            resetFields()
          }}
          className="black"
        >
          Enter
        </button>
      </Grid>
      <Grid xs={4} xsOffset={4} md={2} mdOffset={5}>
        <TextField
          name="numberformat2"
          id="filled-read-only-input"
          label="Total"
          value={subTotal}
          InputProps={{
            inputComponent: NumericFormatCustom,
            readOnly: true,
          }}
          variant="outlined"
        />
      </Grid>
    </Grid>
  );
}

export default CashForm;