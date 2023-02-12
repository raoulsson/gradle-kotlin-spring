package com.example.videogames

import com.example.videogames.config.ConfigProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties::class)
class VideogamesApplication

/**
 * The main entry point of the application. To choose between different profiles, use the `spring.profiles.active` property:
 * 		java -Dspring.profiles.active=foo -jar myapp-0.0.1-SNAPSHOT.jar
 * This would activate the `foo` profile, from resources/application-foo.yaml.
 */
fun main(args: Array<String>) {
    runApplication<VideogamesApplication>(*args)
}
