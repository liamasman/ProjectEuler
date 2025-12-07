plugins {
    id("java")
    id("application")
}

group = "com.liamasman"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

repositories {
    mavenCentral()
}

application {
    mainClass = "com.liamasman.Main"
}

dependencies {
    implementation("org.reflections:reflections:0.10.2")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}