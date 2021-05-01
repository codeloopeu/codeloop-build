package eu.codeloop.configurations.tool

import eu.codeloop.configurations.Configuration
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.tasks.wrapper.Wrapper
import org.gradle.kotlin.dsl.named

class WrapperConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        tasks.named<Wrapper>("wrapper") {
            gradleVersion = "6.7.1"
        }
    }
}
