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
            version.set("1.18.16")
            config.put("lombok.anyConstructor.addConstructorProperties", "true")
            config.put("lombok.val.flagUsage", "error")
            config.put("lombok.var.flagUsage", "error")
        }
    }
}
