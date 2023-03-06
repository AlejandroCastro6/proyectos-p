import {ADD_ITEM, GET_TOTAL_CASHIER, GET_TRANSACTIONS, REFRESH_TOTAL_VALUE_CASHIER} from "../actionTypes/actionTypes";
import axios from 'axios'

const getTransactions = () => async (dispatch) => {
  console.log("entre")
  return await axios.get(`http://localhost:9012/cash/`).then((res) => {
    return dispatch({type: GET_TRANSACTIONS, payload: res.data.result})
  }).catch(async reason => {
    console.error(reason, " error front")
  })
};

const submitItems = (dataArray) => async (dispatch) => {
  console.log(dataArray, " Envío de info");
  return await axios.post(`http://localhost:9012/cash/`, {dataArray}).then(() => {
    return dispatch({
      type: ADD_ITEM,
    })
  }).catch(async reason => {
    console.error(reason, " error front")
  })
};

const refreshValueCashier = () => (dispatch) => {
  return dispatch({
    type: REFRESH_TOTAL_VALUE_CASHIER,
  })
};

const getValueTotalCashier = () => async (dispatch) => {
  return await axios.get(`http://localhost:9012/cash/total`).then(res => {
    return dispatch({
      type: GET_TOTAL_CASHIER,
      payload: res.data.result
    })
  }).catch(async reason => {
    console.error(reason, " error front")
  })
};


export {submitItems, getValueTotalCashier, refreshValueCashier, getTransactions};
