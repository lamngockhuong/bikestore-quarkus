package com.ngockhuong.exception

class EntityNotFoundException : ServiceException {
    var code: String? = null

    constructor(message: String?) : super(message)

    constructor(message: String?, code: String) : super(message) {
        this.code = code
    }

    constructor(message: String?, code: String, cause: Throwable?) : super(message, cause) {
        this.code = code
    }

    constructor(code: String, cause: Throwable?) : super(cause) {
        this.code = code
    }

    constructor(message: String?, code: String, cause: Throwable?, enableSuppression: Boolean, writableStackTrace: Boolean) : super(message, cause, enableSuppression, writableStackTrace) {
        this.code = code
    }
}
