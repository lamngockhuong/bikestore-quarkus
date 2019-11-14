package com.ngockhuong.constant.error

enum class ErrorType(var type: String) {
    SYSTEM_ERROR("System Error"),
    RESOURCE_NOT_FOUND("Resource Not found"),
    REQUEST_METHOD_INVALID("Invalid Request Method"),
    MEDIA_TYPE_INVALID("Invalid Media Type"),
    PARAMETER_INVALID("Invalid Query Parameter"),
    ATTRIBUTE_INVALID("Invalid Attribute"),
}
