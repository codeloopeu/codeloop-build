package eu.codeloop.configurations

import org.gradle.api.Action
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class JavaConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(JavaPlugin::class)

        configure<JavaPluginConvention> {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }
}
