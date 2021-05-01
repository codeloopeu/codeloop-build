package eu.codeloop.configurations.dependencymanagement

import eu.codeloop.configurations.Configuration
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.repositories

class RepositoriesConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        repositories {
            mavenLocal()
            mavenCentral()
            maven {
                name = "Confluent"
                url = uri("https://packages.confluent.io/maven/")
            }
            maven {
                name = "Sonatype Snapshots"
                url = uri("https://oss.sonatype.org/content/repositories/snapshots")
            }
        }
    }
}
