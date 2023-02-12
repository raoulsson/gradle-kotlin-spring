plugins {
    id("kotlin-convention") apply true
    id("spring-version-convention") apply true
    id("spring-convention") apply true
    id("domain-convention") apply true
    id("persistence-convention") apply true
}

java.sourceSets["main"].java {
    srcDir("src/main/jooq")
}

dependencies {
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
    implementation("commons-codec:commons-codec:1.15")
    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
}
