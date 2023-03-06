const Cash = require('../models/Cash')
/**
 * Get all cashier
 *
 * @returns {Promise<{code: number, data: *}>}
 */
exports.index = async function (req) {
  const count = await Cash.countDocuments({})
  let data = await Cash.find({})
  console.log(data, " la db")
  return {data, code: 200}
}

exports.postCash = async function (req) {
  if (!req.body.dataArray && !req.body.dataArray.length) return {data: {error: 'Registro inválido'}, code: 422}
  req.body.dataArray.map(async (item) => {
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
}
