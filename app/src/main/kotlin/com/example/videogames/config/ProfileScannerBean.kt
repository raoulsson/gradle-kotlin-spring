package com.example.videogames.config

import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class ProfileScannerBean internal constructor(private val environment: Environment) {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    /**
     * Logs all active profiles after the application context is initialized.
     */
    @PostConstruct
    fun postConstruct() {
        val activeProfiles = environment.activeProfiles
        logger.info("Active profiles: ${activeProfiles.contentToString()}")
    }
}