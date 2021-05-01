package eu.codeloop.configurations.tool

import com.gorylenko.GitPropertiesPlugin
import eu.codeloop.configurations.Configuration
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class GitPropertiesConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(GitPropertiesPlugin::class)
    }
}
