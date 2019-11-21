package com.ngockhuong.repository

import com.ngockhuong.model.entity.BrandEntity

interface BaseRepository<T> {
    fun list(): List<T>

    fun findItemById(id: Long): BrandEntity?

    fun create(item: T): BrandEntity

    fun update(item: T): BrandEntity

    fun delete(id: Long)
}
