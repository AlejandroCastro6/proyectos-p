import React from "react";
import { useSelector } from "react-redux";
import {Box, Tab, Tabs, Typography} from "@mui/material";
import CashForm from "./cashForm/Cash.form";
function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role='tabpanel'
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}>
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}
function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  };
}
const Cart = () => {
  const state = useSelector((state) => state.cartReducer);
  const [valueTab, setValueTab] = React.useState(0);
  const handleChange = (event, newValue) => {
    setValueTab(newValue);
  };

  return (
    <div className="cart">
      <h2>Caja registradora</h2>
      <h2 style={{color:'red'}}>{state.numOfItems}</h2>
      <Box sx={{ width: '100%' }}>
        <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
          <Tabs value={valueTab} onChange={handleChange} aria-label='basic tabs example'>
            <Tab label='Realizar transaccion' {...a11yProps(0)} />
            <Tab label='Ver transacciones' {...a11yProps(1)} />
          </Tabs>
        </Box>
        <TabPanel value={valueTab} index={0}>
          <CashForm />
        </TabPanel>
        <TabPanel value={valueTab} index={1}>
          {/*<CollectionChannelsTab />*/}
        </TabPanel>
      </Box>
    </div>
  );
};

export default Cart;