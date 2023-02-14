buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()

    }
    dependencies {
//        classpath("org.glassfish.jaxb:jaxb-runtime:4.0.0")
        classpath("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")

        classpath("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
    }
    apply(from = "config.gradle.kts")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

val fileProjectVersion = readVersionFile()

allprojects {
    group = "com.example.videogames"
    version = fileProjectVersion
}

fun readVersionFile(): String {
    return rootDir.resolve("VERSION").readLines()[0].trim()
}

tasks.register("projectinfo") {
    doLast { println("Project ${project.group}:${project.name}:${project.version} Enjoy!") }
}

tasks.register("zulu") {
    doLast { println("Zulu") }
}

// Tasks modules can hook into. Analogue names, but different, to standard gradle tasks, like clean, build, assemble, etc.
subprojects {
    // Clear
    tasks.register("clear") {
        group = "Composite-Tasks"
        description = "Clear all generated artefacts"
        dependsOn("clearFrontend")
        dependsOn("clearBackend")
    }
    tasks.register("clearBackend") {
        group = "Composite-Tasks"
        description = "Clear backend tasks"
    }
    tasks.register("clearFrontend") {
        group = "Composite-Tasks"
        description = "Clear frontend tasks"
    }
    // Generate
    tasks.register("generate") {
        group = "Composite-Tasks"
        description = "Generate all artefacts"
        dependsOn("generateFrontend")
        dependsOn("generateBackend")
    }
    tasks.register("generateBackend") {
        group = "Composite-Tasks"
        description = "Generate backend artefacts"
    }
    tasks.register("generateFrontend") {
        group = "Composite-Tasks"
        description = "Generate frontend artefacts"
    }
    // Produce
    tasks.register("produce") {
        group = "Composite-Tasks"
        description = "Compile and assemble all"
        dependsOn("produceFrontend")
        dependsOn("produceBackend")
    }
    tasks.register("produceBackend") {
        group = "Composite-Tasks"
        description = "Compile and assemble backend"
        dependsOn("generateBackend")
    }
    tasks.register("produceFrontend") {
        group = "Composite-Tasks"
        description = "Compile and assemble frontend"
        dependsOn("generateFrontend")
    }
    // Verify
    tasks.register("verify") {
        group = "Composite-Tasks"
        description = "Run all tests"
        dependsOn("verifyFrontend")
        dependsOn("verifyBackend")
    }
    tasks.register("verifyBackend") {
        group = "Composite-Tasks"
        description = "Run backend tests"
        dependsOn("produceBackend")
    }
    tasks.register("verifyFrontend") {
        group = "Composite-Tasks"
        description = "Run frontend tests"
        dependsOn("produceFrontend")
    }
    // Audit
    tasks.register("audit") {
        group = "Composite-Tasks"
        description = "Run all audits"
        dependsOn("auditFrontend")
        dependsOn("auditBackend")
    }
    tasks.register("auditBackend") {
        group = "Composite-Tasks"
        description = "Run backend audits"
        dependsOn("produceBackend")
    }
    tasks.register("auditFrontend") {
        group = "Composite-Tasks"
        description = "Run frontend audits"
        dependsOn("produceFrontend")
    }
    // Make
    tasks.register("make") {
        group = "Composite-Tasks"
        description = "Make all"
        dependsOn("makeFrontend")
        dependsOn("makeBackend")
    }
    tasks.register("makeBackend") {
        group = "Composite-Tasks"
        description = "Make backend"
        dependsOn("produceBackend")
        dependsOn("verifyBackend")
        dependsOn("auditBackend")
    }
    tasks.register("makeFrontend") {
        group = "Composite-Tasks"
        description = "Make frontend"
        dependsOn("produceFrontend")
        dependsOn("verifyFrontend")
        dependsOn("auditFrontend")
    }
}
