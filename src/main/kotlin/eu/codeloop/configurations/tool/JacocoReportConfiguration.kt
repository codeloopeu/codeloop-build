package eu.codeloop.configurations.tool

import eu.codeloop.configurations.Configuration
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.gradle.testing.jacoco.plugins.JacocoPlugin
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.tasks.JacocoReport

class JacocoReportConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(JacocoPlugin::class)

        configure<JacocoPluginExtension> {
            toolVersion = "0.8.7"
        }

        tasks.withType<JacocoReport> {
            reports {
                xml.isEnabled = true
                html.isEnabled = true
                csv.isEnabled = false
                executionData(tasks.withType<Test>())
            }
        }
    }
}
