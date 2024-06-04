plugins {
    application
    id("java")
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.3"
    id("io.freefair.lombok") version "8.6"
}

group = "org.example"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("org.example.Main")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.h2database:h2:2.2.224")

    implementation("net.datafaker:datafaker:2.2.2")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}