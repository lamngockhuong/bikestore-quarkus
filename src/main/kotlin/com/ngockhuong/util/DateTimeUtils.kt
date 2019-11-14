package com.ngockhuong.util

import java.time.LocalDateTime
import java.time.ZoneId

class DateTimeUtils {
    companion object {
        fun getCurrentDateTime(): LocalDateTime {
            return LocalDateTime.now(ZoneId.systemDefault())
        }
    }
}
