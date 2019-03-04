package eu.codeloop.configurations

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.quality.Checkstyle
import org.gradle.api.plugins.quality.CheckstyleExtension
import org.gradle.api.plugins.quality.CheckstylePlugin
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import eu.codeloop.ext.textResource

class CheckstyleConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(CheckstylePlugin::class)

        configure<CheckstyleExtension> {
            toolVersion = "8.30"
            isShowViolations = true
            maxWarnings = 0
            config = textResource("checkstyle.xml")
        }

        tasks.withType<Checkstyle>().configureEach {
            enabled = true
        }
    }
}
