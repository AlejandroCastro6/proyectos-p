const mongoose = require('mongoose')
const configDB = require("./config/config.json")

mongoose.set('useCreateIndex', true)
mongoose.connect(configDB.database, {
  useNewUrlParser: true,
  useUnifiedTopology: true,
  useFindAndModify: false,
  useCreateIndex: true
}).then(() => {
  console.info("successful DB connection")
}).catch((err) => {
  console.error("connection error", err.message)
  process.exit()
})
