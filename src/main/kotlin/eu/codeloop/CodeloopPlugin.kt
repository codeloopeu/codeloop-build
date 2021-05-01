package eu.codeloop

import eu.codeloop.configurations.Configuration
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.closureOf

interface CodeloopPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.configure(
            project,
            closureOf<Project> {
                onConfigure().forEach { it.configure().execute(this) }
            }
        )
        project.afterEvaluate {
            onAfterEvaluate().forEach { it.configure().execute(this) }
        }
    }

    fun onConfigure(): List<Configuration> = listOf()

    fun onAfterEvaluate(): List<Configuration> = listOf()
}
