package eu.codeloop.ext

import io.freefair.gradle.plugins.lombok.LombokExtension
import io.spring.gradle.dependencymanagement.internal.dsl.StandardDependencyManagementExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.resources.TextResource
import org.gradle.api.tasks.SourceSetContainer
import java.io.FileNotFoundException

fun Project.textResource(filename: String): TextResource {
    val resourceUrl = buildscript.classLoader.getResource(filename) ?: throw FileNotFoundException("Not found $filename")
    return resources.text.fromUri(resourceUrl.toURI())
}

@SuppressWarnings("UnsafeCast")
fun Project.dependencyManagement(configure: StandardDependencyManagementExtension.() -> Unit) =
    (this as ExtensionAware).extensions.configure("dependencyManagement", configure)

@SuppressWarnings("UnsafeCast")
fun Project.lombok(configure: LombokExtension.() -> Unit) =
    (this as ExtensionAware).extensions.configure("lombok", configure)

@SuppressWarnings("UnsafeCast")
fun Project.sourceSets(configure: SourceSetContainer.() -> Unit) =
    (this as ExtensionAware).extensions.configure("sourceSets", configure)

val Project.sourceSets: SourceSetContainer
    @SuppressWarnings("UnsafeCast")
    get() = (this as ExtensionAware).extensions.getByName("sourceSets") as SourceSetContainer
