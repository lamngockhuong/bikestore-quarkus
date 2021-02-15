package com.ngockhuong.model.dto.mfk

import javax.json.bind.annotation.JsonbProperty

class BankTransfer {
    @JsonbProperty("account_number")
    var accountNumber: String = ""

    @JsonbProperty("bank_name")
    var bankName: String = ""

    @JsonbProperty("branch_name")
    var branchName: String = ""

    @JsonbProperty("type")
    var type: String = ""

    @JsonbProperty("holder_name")
    var holderName: String = ""
}