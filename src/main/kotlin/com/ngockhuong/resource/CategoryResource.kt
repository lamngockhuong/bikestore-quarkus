package com.ngockhuong.resource

import com.ngockhuong.model.dto.res.CategoryResDto
import com.ngockhuong.model.entity.CategoryEntity
import com.ngockhuong.service.CategoryService
import com.ngockhuong.service.impl.CategoryServiceImpl
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/categories")
class CategoryResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getCategories(): List<CategoryResDto>? {
        return CategoryServiceImpl().list();
    }
}
