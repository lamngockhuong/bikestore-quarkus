package com.ngockhuong.constant.error

open class ErrorDetail {
    var code: String? = null

    var type: ErrorType? = null

    var field: String? = null

    var message: String? = null

    var log: String? = null

    constructor()

    constructor(code: String?, type: ErrorType?, field: String?, message: String?, log: String?) {
        this.code = code
        this.type = type
        this.field = field
        this.message = message
        this.log = log
    }
}
