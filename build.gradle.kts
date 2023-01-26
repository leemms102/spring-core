plugins {
    java
    id("org.springframework.boot") version "2.7.7"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

// lombok 설정 추가
configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}
repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // lombok 라이브러리 추가
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")
}


tasks.withType<Test> {
    useJUnitPlatform()
}

