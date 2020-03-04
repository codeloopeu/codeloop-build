# Codeloop.eu build plugins

[![Build Status](https://travis-ci.org/codeloopeu/codeloop-build.svg?branch=master)](https://travis-ci.org/codeloopeu/codeloop-build)
[![](https://jitpack.io/v/codeloopeu/codeloop-build.svg)](https://jitpack.io/#codeloopeu/codeloop-build)

## Features

### Java

* Java compiler options
* Lombok
* Checkstyle
* PMD
* SpotBugs
* Jacoco
* Spock
* Repositories
* Dependency Management
* Gradle Wrapper

## Kotlin

* Kotlin compiler options
* Repositories
* Dependency Management
* Detekt
* Jacoco
* Gradle Wrapper

## Spring Boot

* Spring Boot Configuration
* Git Properties Configuration (actuator/info)

## Settings

To use plugins you need to add [jitpack](https://jitpack.io) to plugin management repositories.

`settings.gradle`

```kts
pluginManagement {
    repositories {
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "app-name"
```

## Plugins

### Java Plugin

`build.gradle.kts`

```kts
plugins {
        id("eu.codeloop.java") version "<CURRENT_RELEASE>"
}
```

### Spring Boot Plugin

`build.gradle.kts`

```kts
plugins {
        id("eu.codeloop.springboot") version "<CURRENT_RELEASE>"
}
```

### Kotlin Plugin

`build.gradle.kts`

```kts
plugins {
    id("eu.codeloop.kotlin") version "<CURRENT_RELEASE>"
}
```
