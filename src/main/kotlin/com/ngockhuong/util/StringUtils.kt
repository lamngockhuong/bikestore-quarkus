package com.ngockhuong.util

class StringUtils {
    companion object {
        fun convertCamelToSnake(camelCase: String): String {
            return camelCase.replace("([A-Z]+)".toRegex(), "\\_$1").toLowerCase()
        }
    }
}
