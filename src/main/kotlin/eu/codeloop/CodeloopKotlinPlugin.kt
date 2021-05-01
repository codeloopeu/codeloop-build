package eu.codeloop

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.closureOf
import eu.codeloop.configurations.Configuration
import eu.codeloop.configurations.dependencymanagement.DependencyManagementConfiguration
import eu.codeloop.configurations.tool.DetektConfiguration
import eu.codeloop.configurations.tool.JacocoReportConfiguration
import eu.codeloop.configurations.tool.KotlinConfiguration
import eu.codeloop.configurations.dependencymanagement.RepositoriesConfiguration
import eu.codeloop.configurations.tool.WrapperConfiguration

open class CodeloopKotlinPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configure(project, closureOf<Project> {
            val configurations = listOf(
                    RepositoriesConfiguration(),
                    DependencyManagementConfiguration()
            )
            configurations.forEach { it.configureAndExec(this) }
        })

        project.afterEvaluate {
            val configurations: List<Configuration> = listOf(
                    KotlinConfiguration(),
                    DetektConfiguration(),
                    JacocoReportConfiguration(),
                    WrapperConfiguration()
            )

            configurations.forEach { it.configureAndExec(this) }
        }
    }
}
