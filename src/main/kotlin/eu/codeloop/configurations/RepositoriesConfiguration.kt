package eu.codeloop.configurations

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.repositories

class RepositoriesConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        repositories {
            jcenter()
        }
    }
}
