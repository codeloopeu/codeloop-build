package eu.codeloop.configurations.tool

import eu.codeloop.configurations.Configuration
import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType

class JavaConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(JavaPlugin::class)

        configure<JavaPluginConvention> {
            sourceCompatibility = JavaVersion.VERSION_15
            targetCompatibility = JavaVersion.VERSION_15
        }

        tasks.withType<JavaCompile>().configureEach {
            options.compilerArgs.addAll(
                listOf(
                    "-Xlint:all",
                    "-Werror",
                    "-parameters",
                    "-Xlint:-processing",
                    "-Xlint:-serial"
                )
            )
        }
    }
}
