package eu.codeloop.configurations

import com.github.spotbugs.SpotBugsExtension
import com.github.spotbugs.SpotBugsPlugin
import com.github.spotbugs.SpotBugsTask
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import eu.codeloop.ext.isMain

class SpotBugsConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(SpotBugsPlugin::class)

        configure<SpotBugsExtension> {
            toolVersion = "3.1.12"
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
