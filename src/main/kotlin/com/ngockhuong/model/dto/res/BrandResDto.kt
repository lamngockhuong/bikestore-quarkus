package com.ngockhuong.model.dto.res

import com.ngockhuong.model.dto.BrandDto
import org.eclipse.microprofile.openapi.annotations.media.Schema
import java.time.LocalDateTime
import javax.json.bind.annotation.JsonbProperty

class BrandResDto : BrandDto() {
    @Schema(name = "brand_id")
    @JsonbProperty("brand_id")
    var brandId: Long = 0

    @Schema(name = "created_at")
    @JsonbProperty("created_at")
    lateinit var createdAt: LocalDateTime

    @Schema(name = "updated_at")
    @JsonbProperty("updated_at")
    var updatedAt: LocalDateTime? = null
}
