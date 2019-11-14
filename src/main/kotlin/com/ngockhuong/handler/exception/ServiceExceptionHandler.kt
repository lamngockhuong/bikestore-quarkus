package com.ngockhuong.handler.exception

import com.ngockhuong.constant.error.ErrorCode
import com.ngockhuong.constant.error.ErrorDetail
import com.ngockhuong.constant.error.ErrorMessage
import com.ngockhuong.constant.error.ErrorType
import com.ngockhuong.exception.EntityNotFoundException
import com.ngockhuong.util.DateTimeUtils
import io.vertx.core.http.HttpServerRequest
import io.vertx.core.json.Json
import org.slf4j.LoggerFactory
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

    @Context
    lateinit var info: UriInfo

    @Context
    lateinit var request: HttpServerRequest

    override fun toResponse(exception: Exception?): Response {
        val error = ErrorMessage()
        error.timestamp = DateTimeUtils.getCurrentDateTime()

        val errorDetails = mutableListOf<ErrorDetail?>()
        var errorDetail: ErrorDetail? = null

        errorDetail = when (exception) {
            is EntityNotFoundException -> {
                ErrorDetail((exception as EntityNotFoundException)!!.code ?: ErrorCode.SYSTEM_ERROR, ErrorType.SYSTEM_ERROR, null, exception.message, "")
            }
            else -> {
                ErrorDetail(ErrorCode.SYSTEM_ERROR, ErrorType.SYSTEM_ERROR, null, null, "")
            }
        }

        errorDetails.add(errorDetail)
        error.errors = errorDetails
        LOG.info("Request {} {} {} {}: {}", info.path, request.headers(), request.params(), request.query(), Json.encode(error))
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
