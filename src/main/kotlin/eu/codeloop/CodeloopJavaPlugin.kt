package eu.codeloop

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.closureOf
import eu.codeloop.configurations.style.CheckstyleConfiguration
import eu.codeloop.configurations.dependencymanagement.DependencyManagementConfiguration
import eu.codeloop.configurations.tool.JacocoReportConfiguration
import eu.codeloop.configurations.tool.JavaConfiguration
import eu.codeloop.configurations.tool.LombokConfiguration
import eu.codeloop.configurations.style.PmdConfiguration
import eu.codeloop.configurations.dependencymanagement.RepositoriesConfiguration
import eu.codeloop.configurations.tool.SpockConfiguration
import eu.codeloop.configurations.style.SpotBugsConfiguration
import eu.codeloop.configurations.tool.WrapperConfiguration

open class CodeloopJavaPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configure(project, closureOf<Project> {
            val configurations = listOf(
                    JavaConfiguration(),
                    SpockConfiguration(),
                    RepositoriesConfiguration(),
                    DependencyManagementConfiguration()
            )
            configurations.forEach { it.configureAndExec(this) }
        })

        project.afterEvaluate {
            val configurations = listOf(
                    CheckstyleConfiguration(),
                    PmdConfiguration(),
                    SpotBugsConfiguration(),
                    JacocoReportConfiguration(),
                    LombokConfiguration(),
                    WrapperConfiguration()
            )

            configurations.forEach { it.configureAndExec(this) }
        }
    }
}
