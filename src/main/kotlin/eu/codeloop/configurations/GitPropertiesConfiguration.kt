package eu.codeloop.configurations

import com.gorylenko.GitPropertiesPlugin
import eu.codeloop.ext.gitProperties
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class GitPropertiesConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(GitPropertiesPlugin::class)

        gitProperties {
            keys = listOf("git.commit.id", "git.commit.time", "git.closest.tag.name")
        }
    }
}
