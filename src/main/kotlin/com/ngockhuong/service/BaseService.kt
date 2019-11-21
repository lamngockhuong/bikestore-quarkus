package com.ngockhuong.service

interface BaseService<E, R, T> {
    fun list(): List<R>?

    fun findById(id: Long): T

    fun get(id: Long): R

    fun create(item: E): R

    fun update(item: E): R

    fun delete(id: Long)
}
