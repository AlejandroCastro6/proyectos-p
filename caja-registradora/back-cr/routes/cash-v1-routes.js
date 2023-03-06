/**
 * @name cash-v1-api
 * @description This module packages the cashier API.
 */
'use strict';

const express = require('express')

// const auth = require('../helpers/Auth')
const CashController = require('../controllers/CashController')

let api = express.Router();
/**
 * @swagger
 *  /cash/:
 *  get:
 *    summary: Obtener transacciones.
 *    tags:
 *      - Transaction
 *    security:
 *      - ApiKeyAuth: []
 *    responses:
 *      200:
 *        description: Descarga correcta.
 *      400:
 *        description: Se genero un error.
 *      422:
 *        description: Error en el formulario.
 */

api.get('/', [], async (req, res) => {
  console.log("El rpinciop de lso tiempos")
  const resp = await CashController.index()
  if (resp.code >= 400) console.error({result: resp.data})
  return res.status(resp.code).send({result: resp.data})
});

/**
 * @swagger
 *  /cash/:
 *  post:
 *    summary: Guardar transaccion.
 *    tags:
 *      - Transaction
 *    security:
 *      - ApiKeyAuth: []
 *    requestBody:
 *      content:
 *        application/json:
 *          schema:
 *            type: object
 *            properties:
 *              runt:
 *                type: string
 *                example: 1305580
 *              sicov:
 *                type: number
 *                example: 86156
 *              recaudo:
 *                type: number
 *                example: 10591
 *              ANSV:
 *                type: number
 *                example: 6500
 *              valueService:
 *                type: number
 *                example: 0
 *              valueTotal:
 *                type: number
 *                example: 420200
 *              reference:
 *                type: string
 *                example: 01012897168
 *              idLiquidation:
 *                type: string
 *                example: 123
 *              paymentMethod:
 *                type: object
 *                properties:
 *                  _id:
 *                    type: string
 *                    example: 6399f994653397371896198c
 *                  name:
 *                    type: string
 *                    example: Epayco
 *                  isDirect:
 *                    type: boolean
 *                    example: true
 *              dateGenerate:
 *                type: date
 *                example: 2022-09-10T07:03:50
 *              service:
 *                type: string
 *                example: 6400e19ce3bdcf048873871d
 *              quota:
 *                type: string
 *                example: 1
 *              gender:
 *                type: string
 *                example: F
 *              birthday:
 *                type: date
 *                example: 08/11/2003
 *              documentNumberClient:
 *                type: string
 *                example: 123400023
 *              documentTypeClient:
 *                type: string
 *                example: CC
 *              name:
 *                type: string
 *                example: Julian Gonzales
 *              email:
 *                type: string
 *                example: david@gmail.com
 *              phone:
 *                type: string
 *                example: 3114786899
 *    responses:
 *      200:
 *        description: Consulta correcta.
 *      422:
 *        description: "Saldo insuficiente, wallet: ###"
 *      400:
 *        description: Se genero un error.
 */
api.post('/', [], async (req, res) => {
  const resp = await CashController.postCash(req).catch((err) => console.error(err, "pos no entiendo"))
  if(resp.length) {
    for (const respElement of resp) {
      if (respElement.code >= 400) console.error({result: respElement.data})
      return res.status(respElement.code).send({result: respElement.data})
    }
  }
  return res.status(400).send({result: 'Error MÁXIMO'})
});

/**
 * @swagger
 *  /cash/total:
 *  get:
 *    summary: Obtener valor total de transacciones.
 *    tags:
 *      - Transaction
 *    security:
 *      - ApiKeyAuth: []
 *    responses:
 *      200:
 *        description: Descarga correcta.
 *      400:
 *        description: Se genero un error.
 *      422:
 *        description: Error en el formulario.
 */

api.get('/total', [], async (req, res) => {
  const resp = await CashController.getTotalValue().catch((err) => console.error(err, " dios que pasa"))
  console.log(resp, " fayute")
  if (resp.code >= 400) console.error({result: resp.data})
  return res.status(resp.code).send({result: resp.data})
});

module.exports = api;
