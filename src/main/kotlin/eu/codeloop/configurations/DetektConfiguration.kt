package eu.codeloop.configurations

import eu.codeloop.ext.textResource
import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class DetektConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(DetektPlugin::class)

        configure<DetektExtension> {
            toolVersion = "1.7.4"
            failFast = true
            config = files("$buildDir/tmp/detekt.yml")
            input = files("src/main/kotlin", "src/test/kotlin", "src/integration-test/kotlin")
        }

        tasks.getByName("detekt").doFirst {
            val file = project.file("$buildDir/tmp/detekt.yml")
            file.parentFile.mkdirs()
            file.writeText(textResource("detekt.yml").asString())
        }

        dependencies.add("detektPlugins", "io.gitlab.arturbosch.detekt:detekt-formatting:1.6.0")
    }
}
