package eu.codeloop.configurations.spring

import eu.codeloop.configurations.Configuration
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.named
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.springframework.boot.gradle.tasks.run.BootRun

class SpringBootConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(SpringBootPlugin::class)

        tasks.named<BootRun>("bootRun") {
            systemProperties = System.getProperties().mapKeys { it.key.toString() }
            args = listOf("--spring.profiles.active=localhost")
        }
    }
}
