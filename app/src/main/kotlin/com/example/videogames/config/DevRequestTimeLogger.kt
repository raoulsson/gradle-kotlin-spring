package com.example.videogames.config

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.apache.commons.codec.digest.DigestUtils
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import java.util.*

@Component
class DevRequestTimeLogger: HandlerInterceptor {

    init {
        LOGGER.info("DevRequestTimeLogger initialized")
    }

    /**
     * We track the request time for support and performance analysis.
     *
     * @param request  current HTTP request
     * @param response current HTTP response
     * @param handler  chosen handler to execute, for type and/or instance evaluation
     * @return
     */
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val requestId = UUID.randomUUID().toString()
        request.setAttribute("requestId", requestId)
        request.setAttribute("startTime", System.currentTimeMillis())
        MDC.put("shortRequestId", requestId.substring(0, 8))
        val shortUserHash = calcUserHash(request)
        MDC.put("shortUserHash", shortUserHash.substring(0, 8))
        LOGGER.info("--> {} \"{}\" : req-id: {}", request.method, request.requestURI, requestId)
        return true
    }

    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {
        val requestId = request.getAttribute("requestId") as String
        val executeTime = System.currentTimeMillis() - request.getAttribute("startTime") as Long
        LOGGER.warn(
            "<-- {} \"{}\" : {} - {}ms req-id: {}",
            request.method,
            request.requestURI,
            response.status,
            executeTime,
            requestId
        )
    }

    /**
     *
     *
     * Used for MDC in logging. We don't know the user, but we can match the user by the hash. So we can 3rd level support
     * by analyzing the logs, filtering by user. Current implementation is not perfect, but it's good enough for now.
     *
     * Example log:
     *
     *
     * [15:55:56.219][bbb82e10][fc8ffc0c][INFO ] --> GET "/" : req-id: fc8ffc0c-a6d1-4e04-8df5-cfbd7f077058 [c.e.v.c.RequestTimeLogger.preHandle(RequestTimeLogger.java:37)]
     * [15:55:56.286][bbb82e10][fc8ffc0c][INFO ] <-- GET "/" : 200 - 69ms req-id: fc8ffc0c-a6d1-4e04-8df5-cfbd7f077058 [c.e.v.c.RequestTimeLogger.afterCompletion(RequestTimeLogger.java:45)]
     * [15:55:57.928][bbb82e10][c99b127b][INFO ] --> GET "/" : req-id: c99b127b-0a49-4149-8699-96724293db0d [c.e.v.c.RequestTimeLogger.preHandle(RequestTimeLogger.java:37)]
     * [15:55:57.933][bbb82e10][c99b127b][INFO ] <-- GET "/" : 200 - 5ms req-id: c99b127b-0a49-4149-8699-96724293db0d [c.e.v.c.RequestTimeLogger.afterCompletion(RequestTimeLogger.java:45)]
     *
     * Note that here, [bbb82e10] is always the same user. [fc8ffc0c] and [c99b127b] are different requests from the same user.
     *
     * @param request
     * @return
     */
    private fun calcUserHash(request: HttpServletRequest): String {
        val remoteHost = request.remoteHost
        val remoteAddr = request.remoteAddr
        val remoteUser = request.getHeader("USER-AGENT")
        return DigestUtils.md5Hex(remoteHost + remoteAddr + remoteUser).lowercase(Locale.getDefault())
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger("${DevRequestTimeLogger::class.java}")
    }
}