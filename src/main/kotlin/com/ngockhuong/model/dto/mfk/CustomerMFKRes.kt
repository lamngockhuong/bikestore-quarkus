package com.ngockhuong.model.dto.mfk

class CustomerMFKRes {
    var items: List<CustomerMFK>?
    var pagination: Pagination?

    constructor(items: List<CustomerMFK>? = null, pagination: Pagination? = null) {
        this.items = items
        this.pagination = pagination
    }

    constructor() : this(null, null)
}