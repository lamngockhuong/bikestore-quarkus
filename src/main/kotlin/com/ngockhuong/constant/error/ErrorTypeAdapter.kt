package com.ngockhuong.constant.error

import javax.json.bind.adapter.JsonbAdapter

class ErrorTypeAdapter : JsonbAdapter<ErrorType, String> {

    override fun adaptToJson(item: ErrorType): String {
        return item.type
    }

    override fun adaptFromJson(s: String): ErrorType {
        return ErrorType.valueOf(s)
    }
}
