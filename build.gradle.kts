plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
    // https://mvnrepository.com/artifact/com.codeborne/selenide
    testImplementation("com.codeborne:selenide:6.14.1")
    // https://mvnrepository.com/artifact/io.qameta.allure/allure-junit5
    testImplementation("io.qameta.allure:allure-junit5:2.20.1")
    // https://mvnrepository.com/artifact/io.qameta.allure/allure-commandline
    testImplementation("io.qameta.allure:allure-commandline:2.21.0")
    // https://mvnrepository.com/artifact/io.qameta.allure/allure-java-commons
    testImplementation("io.qameta.allure:allure-java-commons:2.21.0")
    // https://mvnrepository.com/artifact/org.aspectj/aspectjweaver
    runtimeOnly("org.aspectj:aspectjweaver:1.9.19")



}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}