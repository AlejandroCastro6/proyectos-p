'use strict'
const R = require('ramda')
const moment = require("moment")

const {processErrors} = require("./Errors")

async function saveTransactionPin(transaction) {
  if (!transaction.pin && transaction.payState === 'APR') {
    transaction.pin = moment().format('YYMMDDhhmmssSSS')
    await transaction.save().then().catch(async reason => {
      const error = processErrors(reason)
      if (error.keyValue && error.keyValue.pin === transaction.pin) await saveTransactionPin(transaction)
    })
  }
}

module.exports = {
  getNow: function () {
    if (Intl.DateTimeFormat().resolvedOptions().timeZone === "UTC") return {$gte: moment().startOf('day').add(5, 'hours'), $lte: moment().add(5, 'hours').endOf('day')}
    return {$gte: moment().startOf('day').toISOString(), $lte: moment().endOf('day').toISOString()}
  },
  getDateFormatFind: function (start, end) {
    let createdAt = {}
    if (Intl.DateTimeFormat().resolvedOptions().timeZone === "UTC") {
      if (start) Object.assign(createdAt, {$gte: moment(start).startOf('day').add(5, 'hours')})
      if (end) Object.assign(createdAt, {$lte: moment(end).endOf('day').add(5, 'hours')})
    } else {
      if (start) Object.assign(createdAt, {$gte: moment(start).startOf('day').toISOString()})
      if (end) Object.assign(createdAt, {$lte: moment(end).endOf('day').toISOString()})
    }
    return createdAt
  },
  getDate: function (date) {
    return date ? moment(date).format('DD/MM/YYYY hh:mm') : ''
  },
  getFilenameFromPath: R.compose(
    R.last,
    R.split('/')
  ),
  curryJoinPath: R.curry((p, pathX, pathY) => p.join(pathX, pathY)),
  curryResolvePath: R.curry((p, dir, path) => p.resolve(dir, path)),
  notEmpty: R.compose(R.not, R.isEmpty),
  //Responses endpoints
  onRejected: R.curry((res, err) => {
    if (R.has('code', err) && R.has('message', err)) {
      res.status(err.code)
        .send({result: err.message})
    } else {
      console.error(moment().format(), err)
      res.status(500).send({
        result: {
          errors: {
            error: 'Internal Error'
          }
        }
      })
    }
  }),
  onResolved: R.curry((res, data) => {
    res.status(200).send({
      result: data
    })
  }),
  saveTransactionPin
}
