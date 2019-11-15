package com.ngockhuong.model.dto

import org.eclipse.microprofile.openapi.annotations.media.Schema

open class BrandDto {
    @Schema(name = "brand_id")
    var brandId: Long = 0

    @Schema(name = "brand_name")
    var brandName: String = ""
}
