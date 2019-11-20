package com.ngockhuong.model.dto.mfk

import java.time.LocalDateTime

data class CustomerMFKReq(
        var number: String,
        var paymentMethods: List<String>?,
        var hasAlert: Boolean?,
        var createdAtFrom: LocalDateTime?,
        var createdAtTo: LocalDateTime?,
        var after: String?,
        var before: String?,
        var limit: Int
) {
    constructor() : this("", null, null, null, null, null, null, 100)
}