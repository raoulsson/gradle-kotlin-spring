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
    jooqGenerator("org.glassfish.jaxb:jaxb-runtime:4.0.0")
    jooqGenerator("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
//    jooqGenerator("org.mariadb.jdbc:mariadb-java-client")

    implementation("commons-codec:commons-codec:1.15")
    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("org.jooq:jooq-kotlin:3.17.8")

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

