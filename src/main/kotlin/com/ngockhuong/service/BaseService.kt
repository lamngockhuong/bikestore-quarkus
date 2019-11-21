package com.ngockhuong.service

interface BaseService<E, T> {
    fun list(): List<T>?

    fun findById(id: Long): T

    fun create(item: E): T

    fun update(item: E): T

    fun delete(id: Long)
}
