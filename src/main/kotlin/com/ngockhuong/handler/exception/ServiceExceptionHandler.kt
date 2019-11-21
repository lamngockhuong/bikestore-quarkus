package com.ngockhuong.handler.exception

import com.ngockhuong.constant.error.ErrorCode
import com.ngockhuong.constant.error.ErrorDetail
import com.ngockhuong.constant.error.ErrorMessage
import com.ngockhuong.constant.error.ErrorType
import com.ngockhuong.exception.EntityNotFoundException
import com.ngockhuong.util.DateTimeUtils
import io.vertx.core.http.HttpServerRequest
import io.vertx.core.json.Json
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.slf4j.LoggerFactory
import java.io.PrintWriter
import java.io.StringWriter
import javax.persistence.PersistenceException
import javax.ws.rs.core.Context
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriInfo
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class ServiceExceptionHandler : ExceptionMapper<Exception> {
    companion object {
        private val LOG = LoggerFactory.getLogger(ServiceExceptionHandler::class.java)
    }

    @ConfigProperty(name = "server.debug")
    var debug: Boolean = false

    @Context
    lateinit var info: UriInfo

    @Context
    lateinit var request: HttpServerRequest

    override fun toResponse(exception: Exception?): Response {
        val error = ErrorMessage()
        error.timestamp = DateTimeUtils.getCurrentDateTime()

        val errorDetails = mutableListOf<ErrorDetail?>()
        var errorDetail: ErrorDetail? = null
        var httpStatus: Response.Status

        when (exception) {
            is EntityNotFoundException -> {
                httpStatus = Response.Status.NOT_FOUND
                errorDetail = ErrorDetail(exception.code ?: ErrorCode.SYSTEM_ERROR, ErrorType.SYSTEM_ERROR, null, exception.message, getServerMessage(exception))
            }
            is PersistenceException -> {
                httpStatus = Response.Status.INTERNAL_SERVER_ERROR
                errorDetail = ErrorDetail(ErrorCode.DATA_ERROR, ErrorType.SYSTEM_ERROR, null, null, getServerMessage(exception))
            }
            else -> {
                httpStatus = Response.Status.INTERNAL_SERVER_ERROR
                errorDetail = ErrorDetail(ErrorCode.SYSTEM_ERROR, ErrorType.SYSTEM_ERROR, null, null, getServerMessage(exception!!))
            }
        }

        errorDetails.add(errorDetail)
        error.errors = errorDetails
        LOG.info("""
            
            ---- ERROR REQUEST ----
            -- Request path:
            ${request.absoluteURI()}
            -- Request method: ${request.method()}
            -- Request headers:
            ${request.headers()}
            -- Request params:
            ${request.params()}
            -- Query string:
            ${request.query()}
            -- Error response:
            ${Json.encode(error)}
        """.trimIndent())
        return Response.status(httpStatus).entity(error).build();
    }

    private fun getServerMessage(ex: Exception): String {
        var result = ""
        if (debug) {
            val sw = StringWriter()
            ex.printStackTrace(PrintWriter(sw))
            result = sw.toString()
        }

        return result
    }
}
