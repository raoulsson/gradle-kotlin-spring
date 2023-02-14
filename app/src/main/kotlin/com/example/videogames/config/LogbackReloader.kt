package com.example.videogames.config

import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.util.ContextInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import java.io.FileNotFoundException
import java.net.URL


@Component
class LogbackReloader: InitializingBean {

    @Autowired
    var env: Environment? = null

    override fun afterPropertiesSet() {
        LOGGER.info("LogbackReloader init. Env: ${env?.activeProfiles?.contentToString()}")

        val runningInDev = env?.activeProfiles?.any { it.contains( "dev") || it.contains( "test") } ?: false

        if (runningInDev) {
            LOGGER.info("Running in dev mode. Reloading logback config from: $LOGBACK_DEV_CONFIG_FILE")
            val loggerContext: LoggerContext = LoggerFactory.getILoggerFactory() as LoggerContext
            val ci = ContextInitializer(loggerContext)
            val url = URL(LOGBACK_DEV_CONFIG_FILE)

            try {
                url.openConnection()
                loggerContext.reset()
                ci.configureByResource(url)
            } catch (e: FileNotFoundException) {
                LOGGER.error("Logback configuration file not found: {}", url)
            }
        }
    }

    companion object {
        const val LOGBACK_DEV_CONFIG_FILE = "classpath:logback-spring-colored.xml"
        val LOGGER: Logger = LoggerFactory.getLogger(LogbackReloader::class.java)
    }

}