package eu.codeloop.configurations.style

import com.github.spotbugs.snom.Confidence
import com.github.spotbugs.snom.Effort
import com.github.spotbugs.snom.SpotBugsExtension
import com.github.spotbugs.snom.SpotBugsPlugin
import com.github.spotbugs.snom.SpotBugsTask
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
            toolVersion.set("4.2.3")
            effort.set(Effort.DEFAULT)
            reportLevel.set(Confidence.HIGH)
        }

        tasks.withType<SpotBugsTask>().configureEach {
            enabled = isMain()
            reports.register("text") {
                isEnabled = true
            }
        }
    }
}
