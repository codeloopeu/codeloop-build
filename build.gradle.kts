plugins {
    kotlin("jvm") version "1.4.31"
    id("java-gradle-plugin")
    id("maven-publish")
    id("io.gitlab.arturbosch.detekt") version "1.16.0"
    id("org.gradle.kotlin.kotlin-dsl") version "2.1.4"
    id("com.github.ben-manes.versions") version "0.38.0"
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
    buildUponDefaultConfig = true
    allRules = true
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

    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.4.5")
    implementation("gradle.plugin.com.github.spotbugs.snom:spotbugs-gradle-plugin:4.7.1")
    implementation("io.spring.gradle:dependency-management-plugin:1.0.11.RELEASE")
    implementation("io.freefair.gradle:lombok-plugin:6.0.0-m2")
    implementation("com.gorylenko.gradle-git-properties:gradle-git-properties:2.3.1")
}

tasks.wrapper {
    gradleVersion = "7.0"
}
