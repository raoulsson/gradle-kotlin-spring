plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

object Versions {
    const val javaTargetVersion = "11"
    const val kotlinPlugin = "1.6.10"
    const val kotlin = "1.8.0"
    const val springBoot = "2.7.6"
    const val dependencyManagement = "1.0.11.RELEASE"
    const val liquibasePlugin = "2.1.1"
    const val spotless = "6.6.1"
    const val junit = "5.8.2"
    const val junitJupiter = "5.8.2"
    const val hamcrest = "2.2"
    const val studer = "8.0"
    const val jooq = "3.17.7"
    const val dokka = "1.7.20"
    const val flyway = "9.14.1"
    const val hsql = "2.7.1"
    const val h2 = "2.1.214"
    const val mariaDbDriver = "3.1.2"
    const val liquibase = "4.19.0"
//    const val asciidoctorPlugin = "1.5.7"
//    const val asciidoctor = "3.3.2"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-noarg:${Versions.kotlinPlugin}") // 1.6.10
    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:${Versions.kotlinPlugin}") // 1.6.10
    implementation("org.jetbrains.kotlin.plugin.spring:org.jetbrains.kotlin.plugin.spring.gradle.plugin:${Versions.kotlinPlugin}") // 1.6.10

    implementation("org.springframework.boot:spring-boot-gradle-plugin:${Versions.springBoot}") // 2.7.6
    implementation("io.spring.dependency-management:io.spring.dependency-management.gradle.plugin:${Versions.dependencyManagement}") // 1.0.11.RELEASE

    implementation("org.liquibase:liquibase-gradle-plugin:${Versions.liquibasePlugin}") // 2.1.1
    implementation("com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotless}") // 6.6.1
    implementation("org.flywaydb:flyway-gradle-plugin:${Versions.flyway}") // 9.14.1
    implementation("nu.studer.jooq:nu.studer.jooq.gradle.plugin:${Versions.studer}") // 8.0

    testImplementation("org.junit.jupiter:junit-jupiter:${Versions.junitJupiter}") // 5.8.2
    testImplementation("org.hamcrest:hamcrest:${Versions.hamcrest}") // 2.2
    implementation("jakarta.xml.bind:jakarta.xml.bind-api")



//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-jooq")

//    implementation("org.jetbrains.kotlin.plugin.spring:org.jetbrains.kotlin.plugin.spring.gradle.plugin:${Versions.kotlin}")
//    implementation("nu.studer:gradle-jooq-plugin:${Versions.studer}")
//    implementation("org.jooq:jooq:${Versions.jooq}")
//    implementation("org.jetbrains.dokka:dokka-gradle-plugin:${Versions.dokka}")
////    implementation("org.asciidoctor:asciidoctor-gradle-plugin:${Versions.asciidoctorPlugin}")
////    implementation("org.asciidoctor.jvm.convert:${Versions.asciidoctor}")
//
//
//
//    implementation("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")
//
//    implementation("org.slf4j:slf4j-api:2.0.6")
//
//    implementation("org.flywaydb:flyway-core:${Versions.flyway}")
//    implementation("org.flywaydb:flyway-mysql:${Versions.flyway}")
//    implementation("org.flywaydb:flyway-gradle-plugin:${Versions.flyway}")
//
//    implementation("org.jooq:jooq-kotlin:${Versions.jooq}")
//
//    implementation("org.hsqldb:hsqldb:${Versions.hsql}")
//
//    runtimeOnly("com.h2database:h2:${Versions.h2}")
//    runtimeOnly("org.mariadb.jdbc:mariadb-java-client:${Versions.mariaDbDriver}")
//
//    testImplementation("org.liquibase:liquibase-core:${Versions.liquibase}")
//
//    testImplementation("com.ninja-squad:springmockk:4.0.0")
////    testImplementation("org.springframework.boot:spring-boot-starter-test") {
////        exclude(module = "mockito-core")
////        exclude(module = "junit-vintage-engine")
////    }
//    testImplementation("org.springframework.restdocs:spring-restdocs-asciidoctor:3.0.0")
//    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc:3.0.0")
//
////    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
