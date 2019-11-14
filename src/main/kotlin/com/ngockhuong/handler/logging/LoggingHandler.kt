package com.ngockhuong.handler.logging

import io.vertx.core.http.HttpServerRequest
import org.slf4j.LoggerFactory
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.core.Context
import javax.ws.rs.core.UriInfo
import javax.ws.rs.ext.Provider

@Provider
class LoggingHandler : ContainerRequestFilter {
    companion object {
        private val LOG = LoggerFactory.getLogger(LoggingHandler::class.java)
    }

    @Context
    lateinit var info: UriInfo

    @Context
    lateinit var request: HttpServerRequest

    override fun filter(context: ContainerRequestContext?) {
        LOG.info("Request {} {} from IP {}", context!!.method, info.path, request.remoteAddress().toString())
    }
}
