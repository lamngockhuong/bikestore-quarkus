package com.ngockhuong.handler.rest

import io.vertx.core.http.HttpServerRequest
import org.apache.commons.io.IOUtils
import org.slf4j.LoggerFactory
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.container.ContainerResponseContext
import javax.ws.rs.container.ContainerResponseFilter
import javax.ws.rs.core.Context
import javax.ws.rs.core.UriInfo
import javax.ws.rs.ext.Provider

@Provider
class TimeMeasureHandler : ContainerRequestFilter, ContainerResponseFilter {
    companion object {
        private val LOG = LoggerFactory.getLogger(TimeMeasureHandler::class.java)

        class TimerThreadLocal : ThreadLocal<Long>() {
            fun start(): Long {
                val value = System.currentTimeMillis()
                this.set(value)

                return value
            }

            fun stop(): Long {
                return System.currentTimeMillis() - get()
            }

            override fun initialValue(): Long {
                return System.currentTimeMillis()
            }
        }

        val timer = TimerThreadLocal()
    }

    @Context
    lateinit var info: UriInfo

    @Context
    lateinit var request: HttpServerRequest

    override fun filter(context: ContainerRequestContext?) {
        LOG.info("Request [{}] {} at time: {}", context!!.method, info.path, timer.start())
        // LOG.info("Body : {}", IOUtils.toString(BufferedInputStream(context.entityStream, 100000), Charsets.UTF_8))
    }

    override fun filter(reqContext: ContainerRequestContext?, resContext: ContainerResponseContext?) {
        LOG.info("Total request execution time for [{}] {} : {} milliseconds", reqContext!!.method, info.path, timer.stop())
    }
}
