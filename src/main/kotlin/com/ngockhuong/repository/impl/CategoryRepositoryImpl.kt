package com.ngockhuong.repository.impl

import com.ngockhuong.model.entity.CategoryEntity
import com.ngockhuong.repository.CategoryRepository
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CategoryRepositoryImpl : CategoryRepository, PanacheRepository<CategoryEntity> {
    override fun checkStatus(): CategoryEntity {
        return findAll().firstResult<CategoryEntity>()
    }

    override fun list(): List<CategoryEntity> {
        return findAll().list<CategoryEntity>()
    }

    override fun findItemById(id: Long): CategoryEntity? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create(item: CategoryEntity): CategoryEntity {
        println(item)
        if (item.isPersistent) {
            println("OKKK")
        } else {
            print("Not OK")
        }
        item.persist()
        return item
    }

    override fun update(item: CategoryEntity): CategoryEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
