package com.ngockhuong.resource

import com.ngockhuong.model.dto.res.BrandResDto
import com.ngockhuong.service.BrandService
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/brands")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class BrandResource {

    @Inject
    private lateinit var brandService: BrandService

    @GET
    fun getBrands(): List<BrandResDto> {
        return brandService.list()!!
    }

    @GET
    @Path("/{id}")
    fun getBrand(@PathParam("id") id: Long): BrandResDto {
        return brandService.findById(id)
    }
}
