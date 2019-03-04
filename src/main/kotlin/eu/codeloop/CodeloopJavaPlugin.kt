package eu.codeloop

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.closureOf
import eu.codeloop.configurations.CheckstyleConfiguration
import eu.codeloop.configurations.DependencyManagementConfiguration
import eu.codeloop.configurations.JacocoReportConfiguration
import eu.codeloop.configurations.JavaConfiguration
import eu.codeloop.configurations.LombokConfiguration
import eu.codeloop.configurations.PmdConfiguration
import eu.codeloop.configurations.RepositoriesConfiguration
import eu.codeloop.configurations.SpockConfiguration
import eu.codeloop.configurations.SpotBugsConfiguration
import eu.codeloop.configurations.WrapperConfiguration

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
