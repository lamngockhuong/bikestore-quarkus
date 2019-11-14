package com.ngockhuong.constant.error

class CsvErrorDetail : ErrorDetail {
    var line: String? = null

    constructor(code: String?, type: ErrorType?, field: String?, line: String?, message: String?, log: String?) : super(code, type, field, message, log) {
        this.line = line
    }
}
