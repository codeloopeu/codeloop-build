package eu.codeloop

import eu.codeloop.configurations.Configuration
import eu.codeloop.configurations.spring.SpringBootConfiguration
import eu.codeloop.configurations.tool.GitPropertiesConfiguration
import org.gradle.api.Plugin
import org.gradle.api.Project

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
