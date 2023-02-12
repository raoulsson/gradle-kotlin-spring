plugins {
    id("kotlin-conventions")
    id("testing-conventions")
    id("dokka-conventions")
    id("spring-conventions")
}

val loremVersion: String by rootProject.extra

dependencies {
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation(libs.bundles.lorem)

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("commons-codec:commons-codec:1.15")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("javax.persistence:persistence-api:1.0.2")
    implementation("org.jooq:jooq:3.17.8")

}


//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
//
//plugins {
//    id("vg-spring-convention")
//    kotlin("jvm") version "1.8.10"
//}
//
//repositories {
//    mavenCentral()
//}
//
//dependencies {
//    implementation("org.springframework.boot:spring-boot-starter")
//    implementation("org.springframework.boot:spring-boot-starter-actuator")
//
//    testImplementation("org.springframework.boot:spring-boot-starter-web")
//    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation(kotlin("stdlib-jdk8"))
//}
//
//tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
//    enabled = true
//    archiveFileName.set("videogames.jar")
//}
//
//springBoot {
//    buildInfo()
//}
//
//tasks.named("clearBackend") {
//    dependsOn("clearFrontendFromSpringBoot")
//}
//val compileKotlin: KotlinCompile by tasks
//compileKotlin.kotlinOptions {
//    jvmTarget = "1.8"
//}
//val compileTestKotlin: KotlinCompile by tasks
//compileTestKotlin.kotlinOptions {
//    jvmTarget = "1.8"
//}