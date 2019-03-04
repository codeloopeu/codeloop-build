package eu.codeloop

import org.gradle.api.Plugin
import org.gradle.api.Project
import eu.codeloop.configurations.Configuration
import eu.codeloop.configurations.GitPropertiesConfiguration
import eu.codeloop.configurations.SpringBootConfiguration

open class CodeloopSpringBootPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.afterEvaluate {
            val configurations: List<Configuration> = listOf(
                    SpringBootConfiguration(),
                    GitPropertiesConfiguration()
            )

            configurations.forEach { it.configureAndExec(this) }
        }
    }
}
