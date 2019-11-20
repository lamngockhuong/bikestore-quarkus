package com.ngockhuong.resource

import com.ngockhuong.model.dto.req.CategoryReqDto
import com.ngockhuong.model.dto.res.CategoryResDto
import com.ngockhuong.service.CategoryService
import com.ngockhuong.service.impl.CategoryServiceImpl
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/categories")
class CategoryResource {

    @Inject
    lateinit var categoryService: CategoryService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getCategories(): List<CategoryResDto>? {
        return CategoryServiceImpl().list();
    }

    @POST
    fun createCategory(categoryReqDto: CategoryReqDto): CategoryResDto {
        return categoryService.create(categoryReqDto)
    }
}
