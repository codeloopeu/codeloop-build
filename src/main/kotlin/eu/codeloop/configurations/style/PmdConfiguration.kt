package eu.codeloop.configurations.style

import eu.codeloop.configurations.Configuration
import eu.codeloop.ext.isMain
import eu.codeloop.ext.textResource
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.quality.Pmd
import org.gradle.api.plugins.quality.PmdExtension
import org.gradle.api.plugins.quality.PmdPlugin
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType

class PmdConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(PmdPlugin::class)

        configure<PmdExtension> {
            toolVersion = "6.22.0"
            isConsoleOutput = true
            ruleSets = emptyList()
            ruleSetConfig = textResource("pmd-ruleset.xml")
        }

        tasks.withType<Pmd>().configureEach {
            enabled = isMain()
        }
    }
}
