import nu.studer.gradle.jooq.JooqEdition
import org.jooq.meta.jaxb.Logging

plugins {
    id("spring-convention") apply true
    id("org.jetbrains.kotlin.plugin.jpa") apply true
    id("org.flywaydb.flyway") apply true
    id("nu.studer.jooq") apply true
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jooq")



	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-mysql")
	implementation("org.jooq:jooq-kotlin")
	implementation("org.hsqldb:hsqldb")
	implementation("com.h2database:h2")
	implementation("org.mariadb.jdbc:mariadb-java-client")
	implementation("org.liquibase:liquibase-core")

	implementation("org.glassfish.jaxb:jaxb-runtime")
	implementation("jakarta.xml.bind:jakarta.xml.bind-api")

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
	edition.set(JooqEdition.OSS)

	configurations {
		create("main") {
			jooqConfiguration.apply {
				logging = Logging.DEBUG
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

