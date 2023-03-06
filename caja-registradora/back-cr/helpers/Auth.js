const jwt = require('express-jwt')
const config = require('../config/config.json')

const getTokenFromHeaders = (req) => {
  const {headers: {authorization}} = req
  if (authorization && authorization.split(' ')[0] === 'Token') {
    return authorization.split(' ')[1]
  }
  return null
}

exports.required = jwt({
  secret: config.secret,
  userProperty: 'payload',
  getToken: getTokenFromHeaders,
})

exports.optional = jwt({
  secret: config.secret,
  userProperty: 'payload',
  getToken: getTokenFromHeaders,
  credentialsRequired: false,
})

exports.authorize = (permissions = []) => {
  if (typeof permissions === 'string') {
    permissions = [permissions];
  }
  return async (req, res, next) => {
    let userPermissions = req.payload.userPermission;
    if (permissions.length > 0) {
      if (userPermissions.length > 0) {
        let validatePermission = 0;
        for (let i in userPermissions) {
          for (let j in permissions) {
            if (permissions[j] === userPermissions[i]) {
              validatePermission++;
            }
          }
        }
        if (validatePermission > 0) {
          next()
        } else {
          res.status(403).send({result: {errors: "Usuario sin permisos"}})
        }
      } else {
        res.status(403).send({result: {errors: "Usuario sin permisos"}})
      }
    } else {
      next()
    }
  }
}

exports.temp = function (req, res, next) {
  if (req.headers.token && req.headers.token === config.token) return next()
  return res.status(403).send({})
}
