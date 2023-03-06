const swaggerUI = require('swagger-ui-express')
const swaggerJsDoc = require('swagger-jsdoc');
const path = require('path')
const options = {
  definition: {
    openapi: "3.0.0",
    info: {
      title: "Microservices transacciones casa",
      version: "1.0.0",
      description: "Use el token con la palabra Token al inicio: 'Token eyJhbGc...'"
    },
    servers: [

    ],
  },
  apis: [`${path.join(__dirname, "../routes/*.js")}`],
};
const specs = swaggerJsDoc(options);
module.exports = {
  serve: swaggerUI.serve,
  swaggerUI: swaggerUI.setup(specs),
}
