package com.ngockhuong.repository

import com.ngockhuong.model.entity.CategoryEntity

interface CategoryRepository : BaseRepository<CategoryEntity> {
    fun checkStatus(): CategoryEntity
}
