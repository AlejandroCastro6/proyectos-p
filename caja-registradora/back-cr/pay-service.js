'use strict'

const app = require('./app')
const swagger = require('./helpers/Swagger')


app.listen(app.get('port'), () => {
  console.info(`Server listening on port ${app.get('port')}`)
})

app.use('/pay/api-docs', swagger.serve, swagger.swaggerUI)

app.use(function (err, req, res, next) {
  if (err.name === 'UnauthorizedError') res.status(401).send({result: 'UnauthorizedError: No authorization token was found'})
  return next
})
