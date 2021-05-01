plugins {
    kotlin("jvm") version "1.3.72"
    id("java-gradle-plugin")
    id("maven-publish")
    id("io.gitlab.arturbosch.detekt") version "1.16.0"
    id("org.gradle.kotlin.kotlin-dsl") version "1.3.6"
    id("com.github.ben-manes.versions") version "0.36.0"
}

group = "eu.codeloop"
version = "2.2.6.0-SNAPSHOT"

gradlePlugin {
    plugins {
        create("CodeloopJavaPlugin") {
            id = "eu.codeloop.java"
            implementationClass = "eu.codeloop.CodeloopJavaPlugin"
        }
        create("CodeloopKotlinPlugin") {
            id = "eu.codeloop.kotlin"
            implementationClass = "eu.codeloop.CodeloopKotlinPlugin"
        }
        create("CodeloopSpringBootPlugin") {
            id = "eu.codeloop.springboot"
            implementationClass = "eu.codeloop.CodeloopSpringBootPlugin"
        }
    }
}

detekt {
    failFast = true
    config = files("detekt.yml")
    input = files("src/main/kotlin", "src/test/kotlin")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs += listOf("-Xjsr305=strict")
}

repositories {
    jcenter()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(gradleApi())
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.16.0")

    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.16.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.71")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.4.1")
    implementation("gradle.plugin.com.github.spotbugs.snom:spotbugs-gradle-plugin:4.6.0")
    implementation("io.spring.gradle:dependency-management-plugin:1.0.10.RELEASE")
    implementation("io.freefair.gradle:lombok-plugin:5.3.0")
    implementation("gradle.plugin.com.gorylenko.gradle-git-properties:gradle-git-properties:2.2.4")
}

tasks.wrapper {
    gradleVersion = "6.7.1"
}
