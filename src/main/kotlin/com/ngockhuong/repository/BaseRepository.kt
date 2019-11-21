package com.ngockhuong.repository

interface BaseRepository<T> {
    fun list(): List<T>

    fun findItemById(id: Long): T?

    fun create(item: T): T

    fun update(item: T): T

    fun delete(id: Long)

    fun remove(item: T)
}
