const cors = require('cors')
const express = require('express')
const logger = require('morgan')
require('./connections')
const config = require("./config/config.json")


const app = express()
app.set('port', config.port || 9012)
app.use(cors())
app.use(logger('combined'))

app.use(express.json())
app.use(express.urlencoded({extended: true}))

app.use('/cash', require('./routes/cash-v1-routes'))


module.exports = app
