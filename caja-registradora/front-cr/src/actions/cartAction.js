import {ADD_ITEM} from "../actionTypes/actionTypes";
import axios from 'axios'
const submitItems = (dataArray) => async (dispatch) => {
  console.log(dataArray, " lo que nvio");
  return await axios.post(`http://localhost:9012/cash/`, {dataArray}).then(res => {
    console.log(res, " la tapa de los taqnues")
    return dispatch({
      type: ADD_ITEM,
    })
  }).catch(async reason => {
    console.error(reason, " error front")
  })
};


export {submitItems};
