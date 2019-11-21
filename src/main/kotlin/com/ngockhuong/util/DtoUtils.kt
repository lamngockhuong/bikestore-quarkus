package com.ngockhuong.util

import com.ngockhuong.model.dto.req.BrandReqDto
import com.ngockhuong.model.dto.res.BrandResDto
import com.ngockhuong.model.entity.BrandEntity
import kotlin.reflect.full.memberProperties

fun BrandEntity.toBrandResDto(): BrandResDto {
    val item = BrandResDto()
    item.brandId = this.brandId
    item.brandName = this.brandName
    item.createdAt = this.createdAt
    item.updatedAt = this.updatedAt

    return item
}

fun BrandReqDto.toBrandEntity(): BrandEntity {
    return BrandEntity(0, this.brandName, DateTimeUtils.getCurrentDateTime(), null)
}

fun BrandEntity.toBrandResDtoTmp() = with(::BrandResDto) {
    val propertiesByName = BrandEntity::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        parameter to when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toBrandResDtoTmp)
        }
    })
}
