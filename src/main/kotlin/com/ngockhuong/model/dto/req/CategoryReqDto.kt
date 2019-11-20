package com.ngockhuong.model.dto.req

import com.ngockhuong.model.entity.CategoryEntity

class CategoryReqDto {
    var categoryId: Int = 0

    lateinit var categoryName: String

    fun toEntity(): CategoryEntity {
        val categoryEntity = CategoryEntity()
        categoryEntity.categoryId = this.categoryId
        categoryEntity.categoryName = this.categoryName
        return categoryEntity;
    }
}
