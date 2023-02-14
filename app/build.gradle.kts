plugins {
    id("kotlin-convention") apply true
    id("spring-version-convention") apply true
    id("spring-convention") apply true
    id("domain-convention") apply true
    id("persistence-convention") apply true
}

repositories {
    mavenCentral()
}

java.sourceSets["main"].java {
    srcDir("src/main/jooq")
}

dependencies {
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    jooqGenerator("org.glassfish.jaxb:jaxb-runtime:4.0.0")
    jooqGenerator("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
//    jooqGenerator("org.mariadb.jdbc:mariadb-java-client")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")


    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.0")
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")

    implementation("commons-codec:commons-codec:1.15")
    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("org.jooq:jooq-kotlin:3.17.8")

    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
//    kapt("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "mockito-core")
        exclude(module = "junit-vintage-engine")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.ninja-squad:springmockk:4.0.0")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.restdocs:spring-restdocs-asciidoctor")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")
    implementation("org.jooq:jooq-kotlin")
    runtimeOnly("com.h2database:h2")
    jooqGenerator("com.h2database:h2")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    jooqGenerator("org.mariadb.jdbc:mariadb-java-client")
    implementation("org.fusesource.jansi:jansi:2.4.0")
    implementation("commons-codec:commons-codec:1.15")
    implementation("org.springframework.boot:spring-boot-starter-validation")

}

val jooqDb = mapOf(
    "driver" to "org.mariadb.jdbc.Driver",
    "url" to "jdbc:mariadb://127.0.0.1:3306/video_games",
    "schema" to "video_games",
    "user" to "user",
    "password" to "password",
    "jooq_db_type" to "org.jooq.meta.mysql.MySQLDatabase"
)

jooq {
    version.set("3.17.6")
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)

    configurations {
        create("main") {
            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.DEBUG
                jdbc.apply {
                    driver = jooqDb["driver"]
                    url = jooqDb["url"]
                    user = jooqDb["user"]
                    password = jooqDb["password"]
                }
                generator.apply {
                    name = "org.jooq.codegen.KotlinGenerator"
                    database.apply {
                        name = jooqDb["jooq_db_type"]
                        inputSchema = jooqDb["schema"]
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = true
                        isImmutablePojos = false
                        isFluentSetters = true
                        //withPojos(true)
                        //withDaos(true)
                        //withSerializablePojos(false)
                        withSequences(true)
                    }
                    target.apply {
                        packageName = "com.example.videogames.jooq"
                        directory = "src/main/jooq/"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}

