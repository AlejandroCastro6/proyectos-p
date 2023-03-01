const Cash = require('../models/Cash')
/**
 * Get all cashier
 *
 * @returns {Promise<{code: number, data: *}>}
 */
exports.index = async function (req) {
  const count = await Cash.countDocuments({})
  let data = await Cash.find({})
  return {data, code: 200}
}

exports.postCash = async function (req) {
  const transaction = new Cash({
    valueTotal: 100,
    description: "cien pesos de prueba",
    transactionType: 'IN',
  })
  return await transaction.save().then(() => {
    return {data: transaction, code: 200}
  }).catch(reason => {
    return {data: {errors: 'Algo salio mal: '+reason}, code: 422}
  })
}