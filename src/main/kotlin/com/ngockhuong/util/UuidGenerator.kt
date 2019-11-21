package com.ngockhuong.util

import java.util.UUID

class UuidGenerator {
    companion object {
        fun generateRandomUuid(): String {
            return UUID.randomUUID().toString()
        }
    }
}
