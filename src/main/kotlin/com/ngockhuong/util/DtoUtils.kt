package com.ngockhuong.util

import com.ngockhuong.model.dto.res.BrandResDto
import com.ngockhuong.model.entity.BrandEntity
import kotlin.reflect.full.memberProperties

fun BrandEntity.toBrandResDto() = with(::BrandResDto) {
    val propertiesByName = BrandEntity::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        parameter to when (parameter.name) {
            else -> propertiesByName[parameter.name]?.get(this@toBrandResDto)
        }
    })
}
