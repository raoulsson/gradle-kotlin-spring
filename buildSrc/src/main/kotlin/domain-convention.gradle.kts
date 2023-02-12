plugins {
    id("spring-convention") apply true
    id("java-test-fixtures") apply true
}

dependencies {
    implementation("org.slf4j:slf4j-api")
    implementation("org.springframework:spring-context")

    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core")
    testImplementation("org.mockito:mockito-junit-jupiter")
    testImplementation("org.hamcrest:hamcrest")
}
