import nu.studer.gradle.jooq.JooqEdition
import org.jooq.meta.jaxb.Logging

plugins {
    id("spring-convention") apply true
    id("org.jetbrains.kotlin.plugin.jpa") apply true
    id("org.flywaydb.flyway") apply true
    id("nu.studer.jooq") apply true
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
}
