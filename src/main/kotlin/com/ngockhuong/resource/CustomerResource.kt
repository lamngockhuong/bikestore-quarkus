package com.ngockhuong.resource

import com.ngockhuong.model.dto.mfk.CustomerMFKReq
import com.ngockhuong.model.dto.mfk.CustomerMFKRes
import com.ngockhuong.rest.CustomerRest
import io.vertx.core.json.JsonObject
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.inject.Inject
import javax.json.bind.Jsonb
import javax.json.bind.JsonbBuilder
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CustomerResource {

    @Inject
    @field: RestClient
    internal lateinit var customerRest: CustomerRest

    @GET
    fun getCustomers(): CustomerMFKRes? {
        val customerRequest = CustomerMFKReq()
        val responseObject = customerRest.customers("E532ekbZVWCYLbYYlMmIPe5uPi7T4uNe")
        return responseObject;
    }
}