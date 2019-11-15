package com.ngockhuong.resource

import com.ngockhuong.model.dto.res.BrandResDto
import com.ngockhuong.service.BrandService
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/brands")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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

    @GET
    @Path("/{id}")
    fun getBrand(@PathParam("id") id: Long): BrandResDto {
        return brandService.findById(id)
    }
}
