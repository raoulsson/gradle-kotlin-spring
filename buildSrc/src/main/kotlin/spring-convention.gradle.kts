import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("kotlin-convention") apply true
    id("spring-version-convention") apply true
    id("org.springframework.boot") apply true
    kotlin("plugin.spring") apply true
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("jakarta.servlet:jakarta.servlet-api")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true