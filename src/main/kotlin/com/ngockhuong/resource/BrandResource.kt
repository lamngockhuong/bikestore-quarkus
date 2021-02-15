package com.ngockhuong.resource

import com.ngockhuong.model.dto.req.BrandReqDto
import com.ngockhuong.model.dto.res.BrandResDto
import com.ngockhuong.service.BrandService
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/brands")
@Produces(MediaType.APPLICATION_FORM_URLENCODED)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
class BrandResource {

    @Inject
    internal lateinit var brandService: BrandService

    @GET
    @Operation(summary = "Get brand list")
    @APIResponse(
            responseCode = "200",
            description = "The brand list"
    )
    fun getBrands(): List<BrandResDto> {
        return brandService.list()!!
    }

    @POST
    fun createBrand(brand: BrandReqDto): BrandResDto {
        return brandService.create(brand)
    }

    @PUT
    @Path("/{id}")
    fun updateBrand(brand: BrandReqDto): BrandResDto {
        return brandService.update(brand)
    }

    @DELETE
    @Path("/{id}")
    fun deleteBrand(@PathParam("id") id: Long) {
        brandService.findById(id)
        brandService.delete(id)
    }

    @GET
    @Path("/{id}")
    fun getBrand(@PathParam("id") id: Long): BrandResDto {
        return brandService.get(id)
    }
}
