package eu.codeloop.configurations.style

import com.github.spotbugs.SpotBugsExtension
import com.github.spotbugs.SpotBugsPlugin
import com.github.spotbugs.SpotBugsTask
import eu.codeloop.configurations.Configuration
import eu.codeloop.ext.isMain
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType

class SpotBugsConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(SpotBugsPlugin::class)

        configure<SpotBugsExtension> {
            toolVersion = "4.0.1"
            effort = "default"
            reportLevel = "high"
        }

        tasks.withType<SpotBugsTask>().configureEach {
            enabled = isMain()
            reports.html.isEnabled = true
            reports.xml.isEnabled = false
        }
    }
}
