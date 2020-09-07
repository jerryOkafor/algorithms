
//Ref: https://rollbar.com/guides/javascript-throwing-exceptions/
let CustomException = function (message) {
    const error = new Error(message)
    error.code = "CLIENT_ERROR"

    return error
}

CustomException.prototype = Object.create(Error.prototype)

module.exports = CustomException