# Codeloop.eu build plugins

## Features

* checkstyle
* pmd
* spotbugs
* ...

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
