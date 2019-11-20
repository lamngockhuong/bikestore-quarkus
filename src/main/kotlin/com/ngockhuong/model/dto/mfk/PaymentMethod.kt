package com.ngockhuong.model.dto.mfk

import javax.json.bind.annotation.JsonbProperty

class PaymentMethod {
    @JsonbProperty("bank_transfer")
    var bankTransfer: BankTransfer? = null
}