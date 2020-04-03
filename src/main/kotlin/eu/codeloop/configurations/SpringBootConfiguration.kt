package eu.codeloop.configurations

import eu.codeloop.ext.springBoot
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.named
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.springframework.boot.gradle.tasks.run.BootRun

class SpringBootConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(SpringBootPlugin::class)

        springBoot {
            buildInfo()
        }

        tasks.named<BootRun>("bootRun") {
            systemProperties = System.getProperties().mapKeys { it.key.toString() }
            jvmArgs = listOf("-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005")
            args = listOf("--spring.profiles.active=localhost")
        }
    }
}
