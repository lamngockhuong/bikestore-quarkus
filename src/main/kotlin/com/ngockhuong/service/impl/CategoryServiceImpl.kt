package com.ngockhuong.service.impl

import com.ngockhuong.model.dto.req.CategoryReqDto
import com.ngockhuong.model.dto.res.CategoryResDto
import com.ngockhuong.model.entity.CategoryEntity
import com.ngockhuong.service.CategoryService

class CategoryServiceImpl : CategoryService {
    override fun list(): List<CategoryResDto>? {
        return CategoryEntity().findAll()?.map { categoryEntity -> categoryEntity.transformToCategoryResDto() }
    }

    override fun findById(id: Long): CategoryResDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create(item: CategoryReqDto): CategoryResDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(item: CategoryReqDto): CategoryResDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
