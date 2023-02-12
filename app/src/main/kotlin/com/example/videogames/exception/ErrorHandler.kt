package com.example.videogames.exception

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * @see: https://www.baeldung.com/kotlin/spring-rest-error-handling
 */
class ErrorMessageModel(
    var status: Int? = null,
    var message: String? = null
)

/**
 * General "advice", aka place to put all the exception handlers.
 * If just prototyping, ResponseStatusException is a better alternative:
 *  throw ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found")
 * Later, when things settle, add a proper type and handler here.
 */
@ControllerAdvice
class ExceptionControllerAdvice {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler
    fun handleIllegalStateException(ex: IllegalStateException): ResponseEntity<ErrorMessageModel> {
        val errorMessage = ErrorMessageModel(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

//    @ExceptionHandler
//    fun handleArticleNotFoundException(ex: ArticleNotFoundException): ResponseEntity<ErrorMessageModel> {
//        val errorMessage = ErrorMessageModel(
//            HttpStatus.NOT_FOUND.value(),
//            ex.message
//        )
//        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
//    }
}
