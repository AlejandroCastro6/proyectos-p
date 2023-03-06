import * as React from 'react';
import {DataGrid, GridToolbar} from '@mui/x-data-grid';
import {useEffect, useState} from "react";
import {getTransactions} from "../../actions/cartAction";
import {useDispatch} from "react-redux";
import {numberWithCommas} from "../../helpers/Helpers";
import moment from 'moment-timezone';
moment.tz.setDefault("America/Bogota");

const ViewTransactions = () => {
  const [data, setData] = useState([])
  const dispatch = useDispatch();


  useEffect(() => {
    (async () => {
      return await dispatch(getTransactions())
    })().then((resp) => {
      setData(resp.payload)
    }).catch(console.error)

  }, [])

  let columns = [
    {field: '_id', headerName: 'Id', defaultHeader: true},
    {
      field: 'transactionType',
      headerName: 'Tipo de transaccion ',
      defaultHeader: true,
      valueGetter: (data) => data.row?.transactionType === 'IN' ? 'Entrada' : 'Salida'
    },
    {
      field: 'value',
      headerName: 'Valor',
      defaultHeader: true,
      valueGetter: (data) => numberWithCommas(data.row?.value)
    },
    {
      field: 'description',
      headerName: 'Descripción',
      defaultHeader: true,
    },
    {
      field: 'createdAt',
      headerName: 'Fecha',
      defaultHeader: true,
      valueGetter: (data) => (moment(new Date(data.row?.createdAt)).format('DD/MM/YYYY hh:mm'))
    },
  ];
  columns = columns.map((element) => {
    if (typeof element.defaultHeader === 'string') {
      return {
        ...element,
        headerClassName: element.defaultHeader,
        minWidth: element.minWidth,
      };
    } else {
      return {
        ...element,
        headerClassName: 'paynet-datagrid--header',
        flex: 1,
        minWidth: 150,
        align: 'center',
        headerAlign: 'center',
      };
    }
  });
  return (
    <div style={{height: 400, width: '100%'}}>
      <DataGrid
        columns={columns}
        rows={data}
        getRowId={(row) => row._id}
        slots={{
          toolbar: GridToolbar,
        }}
      />
    </div>
  );
}
export default ViewTransactions;