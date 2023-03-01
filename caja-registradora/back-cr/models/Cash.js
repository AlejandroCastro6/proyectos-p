const mongoose = require('mongoose')
const Schema = mongoose.Schema
const moment = require("moment-timezone")

let schema = new Schema({
  valueTotal: {
    type: Number,
    required: [true, 'Este campo es requerido'],
  },
  description: {
    type: String,
    required: [true, 'Este campo es requerido'],
  },
  transactionType: {
    type: String,
    required: [true, 'Este campo es requerido'],
    default: 'IN',
    enum: {
      values: [
        'IN', // ENTRADAS
        'OUT' // SALIDAS
      ],
      message: 'Valores permitidos IN - OUT'
    },
  },
  createdAt: {
    type: Date,
    immutable: true
  },
  updateAt: Date,
  deleteAt: Date,
})

schema.pre('save', function (next) {
  if (this.isNew) this.createdAt = moment()
  else if (this.isModified) this.updateAt = moment()
  next()
})

module.exports = mongoose.model('cash', schema)