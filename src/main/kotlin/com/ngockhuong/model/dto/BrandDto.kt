package com.ngockhuong.model.dto

import org.eclipse.microprofile.openapi.annotations.media.Schema
import javax.json.bind.annotation.JsonbProperty

open class BrandDto {
    @Schema(name = "brand_name")
    @JsonbProperty("brand_name")
    var brandName: String = ""
}
