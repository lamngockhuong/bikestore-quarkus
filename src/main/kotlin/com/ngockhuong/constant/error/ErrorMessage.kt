package com.ngockhuong.constant.error

import java.time.LocalDateTime

class ErrorMessage {
    lateinit var timestamp: LocalDateTime

    lateinit var errors: List<ErrorDetail?>
}
