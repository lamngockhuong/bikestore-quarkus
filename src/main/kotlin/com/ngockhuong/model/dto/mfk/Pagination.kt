package com.ngockhuong.model.dto.mfk

class Pagination {
    var end: String?
    var hasNext: Boolean?
    var hasPrevious: Boolean?
    var limit: Int
    var start: String?
    var total: Int

    constructor(end: String?, hasNext: Boolean?, hasPrevious: Boolean?, limit: Int = 0, start: String?, total: Int = 0) {
        this.end = end
        this.hasNext = hasNext
        this.hasPrevious = hasPrevious
        this.limit = limit
        this.start = start
        this.total = total
    }

    constructor() : this(null, null, null, 0, null, 0)
}