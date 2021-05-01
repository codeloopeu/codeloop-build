package eu.codeloop.configurations.tool

import eu.codeloop.configurations.Configuration
import eu.codeloop.ext.lombok
import io.freefair.gradle.plugins.lombok.LombokPlugin
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class LombokConfiguration : Configuration {

    @Suppress("UnstableApiUsage")
    override fun configure(): Action<Project> = Action {
        plugins.apply(LombokPlugin::class)

        lombok {
            config.put("config.stopBubbling", "true")
            config.put("lombok.extern.findbugs.addSuppressFBWarnings", "true")
            config.put("lombok.addLombokGeneratedAnnotation", "true")
            config.put("lombok.anyConstructor.addConstructorProperties", "true")
            config.put("lombok.val.flagUsage", "error")
        }
    }
}
