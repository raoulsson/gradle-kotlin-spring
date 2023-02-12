package com.example.videogames.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("app.config-properties")
data class ConfigProperties(var title: String, val banner: Banner) {
    data class Banner(val title: String? = null, val content: String)
}
