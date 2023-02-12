plugins {
    id("spring-convention") apply true
    id("org.jetbrains.kotlin.plugin.jpa") apply true
    id("org.flywaydb.flyway") apply true
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jooq")

    implementation("jakarta.persistence:jakarta.persistence-api")
    implementation("jakarta.validation:jakarta.validation-api")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")
    implementation("org.jooq:jooq-kotlin")
    implementation("org.hsqldb:hsqldb")
    implementation("com.h2database:h2")
    implementation("org.mariadb.jdbc:mariadb-java-client")
    implementation("org.liquibase:liquibase-core")
}
