package com.ngockhuong.rest

import com.ngockhuong.model.dto.mfk.CustomerMFKRes
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.annotations.jaxrs.HeaderParam
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/v2/customers")
@RegisterRestClient
interface CustomerRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun customers(@HeaderParam("apikey") apiKey: String): CustomerMFKRes
}