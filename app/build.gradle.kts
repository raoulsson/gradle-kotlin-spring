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
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.2")
    implementation("org.glassfish.jaxb:jaxb-xjc:4.0.2")
    implementation("org.glassfish.jaxb:jaxb-jxc:4.0.2")
    implementation("javax.activation:activation:1.1.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    compileOnly("org.jooq:jooq:3.16.6")
    compileOnly("org.jooq:jooq-codegen:3.16.6")

    implementation("org.glassfish.jaxb:jaxb-runtime:4.0.0")
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")



    implementation("commons-codec:commons-codec:1.15")
    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("org.jooq:jooq-kotlin:3.17.8")

}
