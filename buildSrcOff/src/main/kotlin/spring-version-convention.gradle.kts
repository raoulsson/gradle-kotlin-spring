plugins {
    id("io.spring.dependency-management") apply true
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:3.0.2")
    }
}