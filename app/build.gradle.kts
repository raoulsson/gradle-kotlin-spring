import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
//    id("kotlin-convention") apply true
//    id("spring-version-convention") apply true
//    id("spring-convention") apply true
//    id("domain-convention") apply true
//    id("persistence-convention") apply true
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.7.22"

    id("org.flywaydb.flyway") version "9.14.1"
    id("nu.studer.jooq") version "8.0"
}

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

java.sourceSets["main"].java {
    srcDir("src/main/jooq")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("org.liquibase:liquibase-core")
//    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    implementation("org.springframework.boot:spring-boot-starter-validation")

//    implementation("org.jooq:jooq-kotlin:3.17.8")

//    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
//
    jooqGenerator("org.glassfish.jaxb:jaxb-runtime")
    jooqGenerator("jakarta.xml.bind:jakarta.xml.bind-api")
//
    jooqGenerator("jakarta.xml.bind:jakarta.xml.bind-api")
//
//    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
//    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    runtimeOnly("org.springframework.boot:spring-boot-devtools")
////    kapt("org.springframework.boot:spring-boot-configuration-processor")
//    testImplementation("org.springframework.boot:spring-boot-starter-test") {
//        exclude(module = "mockito-core")
//        exclude(module = "junit-vintage-engine")
//    }
//    testImplementation("org.junit.jupiter:junit-jupiter-api")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
//    testImplementation("com.ninja-squad:springmockk:4.0.0")
//    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
//    implementation("org.springframework.boot:spring-boot-starter-data-rest")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    testImplementation("org.springframework.restdocs:spring-restdocs-asciidoctor")
//    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
//    implementation("org.springframework.boot:spring-boot-starter-jooq")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.flywaydb:flyway-core")
//    implementation("org.flywaydb:flyway-mysql")
//    implementation("org.jooq:jooq-kotlin")
//    runtimeOnly("com.h2database:h2")
//    jooqGenerator("com.h2database:h2")
//    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    jooqGenerator("org.mariadb.jdbc:mariadb-java-client")
//    implementation("org.fusesource.jansi:jansi:2.4.0")
//    implementation("commons-codec:commons-codec:1.15")
//    implementation("org.springframework.boot:spring-boot-starter-validation")

//    jooqGenerator("org.mariadb.jdbc:mariadb-java-client")
//
//    implementation("jakarta.xml.bind:jakarta.xml.bind-api")
//
//    implementation("jakarta.validation:jakarta.validation-api")
//    implementation("jakarta.annotation:jakarta.annotation-api")
//    implementation("jakarta.servlet:jakarta.servlet-api")
//    implementation("jakarta.persistence:jakarta.persistence-api")
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//
//
////    implementation("org.glassfish.jaxb:jaxb-runtime")
//    implementation("jakarta.xml.bind:jakarta.xml.bind-api")

    implementation("commons-codec:commons-codec:1.15")
//    implementation("org.jooq:jooq-kotlin:3.17.8")
//
//    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
//    implementation("org.springframework.boot:spring-boot-starter-web")
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    runtimeOnly("org.springframework.boot:spring-boot-devtools")
////    kapt("org.springframework.boot:spring-boot-configuration-processor")
//    testImplementation("org.springframework.boot:spring-boot-starter-test") {
//        exclude(module = "mockito-core")
//        exclude(module = "junit-vintage-engine")
//    }
//    testImplementation("org.junit.jupiter:junit-jupiter-api")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
//    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
//    implementation("org.springframework.boot:spring-boot-starter-data-rest")
//    testImplementation("org.springframework.restdocs:spring-restdocs-asciidoctor")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
//    implementation("org.springframework.boot:spring-boot-starter-jooq")
//    implementation("org.flywaydb:flyway-core")
//    implementation("org.flywaydb:flyway-mysql")
//    implementation("org.jooq:jooq-kotlin")
//    runtimeOnly("com.h2database:h2")
//    jooqGenerator("com.h2database:h2")
//    testImplementation("com.ninja-squad:springmockk")
//    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
//    jooqGenerator("org.mariadb.jdbc:mariadb-java-client")
//    implementation("org.fusesource.jansi:jansi:2.4.0")
//    implementation("commons-codec:commons-codec:1.15")
//    implementation("org.springframework.boot:spring-boot-starter-validation")

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val jooqDb = mapOf(
    "driver" to "org.mariadb.jdbc.Driver",
    "url" to "jdbc:mariadb://127.0.0.1:3306/video_games",
    "schema" to "video_games",
    "user" to "user",
    "password" to "password",
    "jooq_db_type" to "org.jooq.meta.mysql.MySQLDatabase"
)

//jooq {
//    version.set("3.17.6")
//    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)
//
//    configurations {
//        create("main") {
//            jooqConfiguration.apply {
//                logging = org.jooq.meta.jaxb.Logging.DEBUG
//                jdbc.apply {
//                    driver = jooqDb["driver"]
//                    url = jooqDb["url"]
//                    user = jooqDb["user"]
//                    password = jooqDb["password"]
//                }
//                generator.apply {
//                    name = "org.jooq.codegen.KotlinGenerator"
//                    database.apply {
//                        name = jooqDb["jooq_db_type"]
//                        inputSchema = jooqDb["schema"]
//                    }
//                    generate.apply {
//                        isDeprecated = false
//                        isRecords = true
//                        isImmutablePojos = false
//                        isFluentSetters = true
//                        //withPojos(true)
//                        //withDaos(true)
//                        //withSerializablePojos(false)
//                        withSequences(true)
//                    }
//                    target.apply {
//                        packageName = "com.example.videogames.jooq"
//                        directory = "src/main/jooq/"
//                    }
//                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
//                }
//            }
//        }
//    }
//}
//
