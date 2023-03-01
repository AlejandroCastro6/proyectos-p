import { ADD_ITEM, DELETE_ITEM } from "../actionTypes/actionTypes";
// import axios from 'axios'
const addItem = () => async (dispatch) => {
    return dispatch({
      type: ADD_ITEM,
    })
 // return await axios.post(``, {}).then(res => {
 //  }).catch(async reason => {
 //  })
};

const deleteItem = () => {
  return {
    type: DELETE_ITEM,
  };
};

export { addItem, deleteItem };
