package com.ngockhuong.model.dto.mfk

import com.fasterxml.jackson.annotation.JsonProperty
import javax.json.bind.annotation.JsonbProperty

class CustomerMFK {
    @JsonbProperty("created_at")
    var createdAt: String?

    @JsonbProperty("has_alert")
    var hasAlert: Boolean?
    var id: String?
    var name: String?
    var number: String?

    @JsonbProperty("payment_method")
    var paymentMethod: PaymentMethod?
    var uri: String?

    constructor(createdAt: String?, hasAlert: Boolean?, id: String?, name: String?, number: String?, paymentMethod: PaymentMethod?, uri: String?) {
        this.createdAt = createdAt
        this.hasAlert = hasAlert
        this.id = id
        this.name = name
        this.number = number
        this.paymentMethod = paymentMethod
        this.uri = uri
    }

    constructor() : this(null, null, null, null, null, null, null)
}