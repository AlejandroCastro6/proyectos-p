/**
* @name cash-v1-api
* @description This module packages the cashier API.
*/
'use strict';

const express = require('express')

// const auth = require('../helpers/Auth')
const CashController = require('../controllers/CashController')

let api = express.Router();
api.get('/',[], async (req, res) => {
  const resp = await CashController.index(req)
  if (resp.code >= 400) console.error({result: resp.data})
  return res.status(resp.code).send({result: resp.data})
});

api.post('/',[], async (req, res) => {
  const resp = await CashController.postCash(req)
  if (resp.code >= 400) console.error({result: resp.data})
  return res.status(resp.code).send({result: resp.data})
});

module.exports = api;
