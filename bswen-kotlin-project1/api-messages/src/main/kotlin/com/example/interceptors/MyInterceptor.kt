package com.example.interceptors

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class MyInterceptor: HandlerInterceptor {
    val Any.logger: Logger
        get() = LoggerFactory.getLogger(this.javaClass)

    override fun preHandle(request: HttpServletRequest,
                           response: HttpServletResponse, handler: Any): Boolean {
        logger.info("prehandle called.")
        return super.preHandle(request, response, handler)

    }
}