import {ADD_ITEM, DELETE_ITEM, GET_TOTAL_CASHIER, REFRESH_TOTAL_VALUE_CASHIER} from "../actionTypes/actionTypes";

const initialState = {
  numOfItems: 0,
  refreshValueCashier: true,
  totalValueCashier: 0
};

export const cartReducer = (state = initialState, action) => {
  switch (action.type) {
    case GET_TOTAL_CASHIER:
      return {
        ...state,
        totalValueCashier: action.payload,
      };
      case REFRESH_TOTAL_VALUE_CASHIER:
      return {
        ...state,
        refreshValueCashier: !state.refreshValueCashier,
      };
    case ADD_ITEM:
      return {
        ...state,
        numOfItems: state.numOfItems + 1,
      };

    case DELETE_ITEM:
      return {
        ...state,
        numOfItems: state.numOfItems - 1,
      };
    default:
      return state;
  }
};
