import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") apply true
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("commons-codec:commons-codec")
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core")
    testImplementation("org.mockito:mockito-junit-jupiter")
    testImplementation("org.hamcrest:hamcrest")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named("clearBackend")  {
    dependsOn("clean")
}

tasks.named("produceBackend")  {
    dependsOn("assemble")
}

//tasks.named("auditBackend")  {
//    dependsOn("spotlessKotlinCheck")
//}

tasks.named("verifyBackend")  {
    dependsOn("check")
}

tasks.named("makeBackend")  {
    dependsOn("build")
}