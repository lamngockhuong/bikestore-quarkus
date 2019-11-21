package com.ngockhuong.repository.impl

import com.ngockhuong.model.entity.BrandEntity
import com.ngockhuong.repository.BrandRepository
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class BrandRepositoryImpl : BrandRepository, PanacheRepository<BrandEntity> {
    override fun list(): List<BrandEntity> {
        return listAll()
    }

    override fun findItemById(id: Long): BrandEntity? {
        return findById(id)
    }

    override fun create(item: BrandEntity): BrandEntity {
        persistAndFlush(item)
        return item
    }

    override fun update(item: BrandEntity): BrandEntity {
        // TODO()
        return item
    }

    override fun delete(id: Long) {
        delete(findItemById(id))
    }

    override fun remove(item: BrandEntity) {
        delete(item)
    }
}
