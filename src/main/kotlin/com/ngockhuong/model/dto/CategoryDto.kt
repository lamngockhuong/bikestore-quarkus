package com.ngockhuong.model.dto

import org.eclipse.microprofile.openapi.annotations.media.Schema

open class CategoryDto {
    @Schema(name = "category_id")
    var categoryId: Int = 0

    @Schema(name = "category_name")
    var categoryName: String = ""
}
