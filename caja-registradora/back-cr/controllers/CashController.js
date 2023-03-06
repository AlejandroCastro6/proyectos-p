const Cash = require('../models/Cash')
const R = require('ramda')
/**
 * Get all cashier
 *
 * @returns {Promise<{code: number, data: *}>}
 */
exports.index = async function () {
  console.log("ahi voy bien ???")
  let data = await Cash.find({}).catch(console.error)
  return {data, code: 200}
}

exports.postCash = async function (req) {
  if (!req.body.dataArray || !req.body.dataArray.length) return {data: {error: 'Registro inválido'}, code: 422}
  const resp =  req.body.dataArray.map(async (item) => {
    const transaction = new Cash({
      value: item.value,
      description: item.description,
      transactionType: item.transactionType,
    })
    return await transaction.save().then(() => {
      console.log("gurde cositas....")
      return {data: transaction, code: 200}
    }).catch(reason => {
      return {data: {errors: 'Algo salio mal: ' + reason}, code: 422}
    })
  })
  return Promise.all(resp)
}

/**
 * Get value total
 *
 * @returns {Promise<{code: number, data: *}>}
 */
exports.getTotalValue = async function () {
  let data = await Cash.find({}).catch((err) => {
    console.error(err, " ????")
  })
  let total = 0
  if (!data.length) return {data: {error: 'Búsqueda inválida'}, code: 400}
  data.forEach((item) => {
    isCashIn(item) ? total = total += item.value : total -= item.value
  })
  return {data: total, code: 200}
}
const isCashIn = x => R.equals('IN', x.transactionType)
