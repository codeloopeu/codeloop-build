package eu.codeloop.ext

import org.gradle.api.Task

fun Task.isMain(): Boolean = name.contains("main", ignoreCase = true)
