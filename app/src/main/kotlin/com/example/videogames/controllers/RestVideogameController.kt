package com.example.videogames.controllers

import com.example.videogames.dao.JooqDbAccessor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus.*
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api"], produces = [MediaType.APPLICATION_JSON_VALUE])
class RestVideogameController(private val jooqDbAccessor: JooqDbAccessor) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/all_games")
    fun findAll(@RequestParam(required = false) limit: Int?) = jooqDbAccessor.getGamesOrderByGenreName(limit)

    @GetMapping("/top_sellers_by_platform")
    fun topSellersByPlatform(@RequestParam(required = false) limit: Int?) =
        jooqDbAccessor.getTopSellersByPlatformJSON(limit)
}
