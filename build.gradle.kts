import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.61"
    id("java-gradle-plugin")
    id("maven-publish")
    id("io.gitlab.arturbosch.detekt") version "1.6.0"
    id("org.gradle.kotlin.kotlin-dsl") version "1.3.3"
    id("com.github.ben-manes.versions") version "0.28.0"
}

group = "eu.codeloop"
version = "2.2.5.0-SNAPSHOT"

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

tasks.withType<KotlinCompile>().configureEach {
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
    implementation("org.gradle.kotlin:plugins:1.3.3")
    implementation("gradle.plugin.com.github.spotbugs:spotbugs-gradle-plugin:2.0.0")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.6.0")
    implementation("io.spring.gradle:dependency-management-plugin:1.0.9.RELEASE")
    implementation("io.freefair.gradle:lombok-plugin:5.0.0-rc4")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.2.5.RELEASE")
    implementation("gradle.plugin.com.gorylenko.gradle-git-properties:gradle-git-properties:2.2.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.6.0")
}

tasks.wrapper {
    gradleVersion = "6.2.1"
}
