import thunk from 'redux-thunk';
import storage from 'redux-persist/es/storage'
import {applyMiddleware, compose, createStore} from "redux"
import {createFilter} from 'redux-persist-transform-filter';
import {persistReducer} from 'redux-persist'
import rootReducer from './reducers'

const initialState = {};
const middleware = [thunk];

export default () => {
  const persistedFilter = createFilter(
    'authReducer');
  const reducer = persistReducer(
    {
      key: 'polls',
      storage: storage,
      whitelist: ['authReducer'],
      transforms: [persistedFilter]
    },
    rootReducer);
  return createStore(
    reducer,
    initialState,
    compose(
      applyMiddleware(...middleware),
      window.__REDUX_DEVTOOLS_EXTENSION__ ? window.__REDUX_DEVTOOLS_EXTENSION__() : f => f
    )
  )
}
