package eu.codeloop.configurations

import eu.codeloop.ext.ext
import eu.codeloop.ext.sourceSets
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.GroovyPlugin
import org.gradle.api.tasks.GroovySourceSet
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withConvention
import org.gradle.kotlin.dsl.withType

class SpockConfiguration : Configuration {

    @SuppressWarnings("StringLiteralDuplication")
    override fun configure(): Action<Project> = Action {
        plugins.apply(GroovyPlugin::class)

        ext["groovy.version"] = "3.0.1"

        sourceSets {
            create("integration-test") {
                java.srcDir("src/integration-test/java")
                withConvention(GroovySourceSet::class) {
                    groovy.srcDir(file("src/integration-test/groovy"))
                }
                resources.srcDir("src/integration-test/resources")
                compileClasspath += sourceSets["main"].output + sourceSets["test"].output + configurations["testRuntimeClasspath"]
                runtimeClasspath += output + compileClasspath + sourceSets["test"].runtimeClasspath
            }
        }

        tasks.register<Test>("integrationTest") {
            description = "Runs the integration tests."
            group = "verification"
            testClassesDirs = sourceSets["integration-test"].output.classesDirs
            classpath = sourceSets["integration-test"].runtimeClasspath
            mustRunAfter(tasks.named("test"))
        }

        tasks.named("check") {
            dependsOn("integrationTest")
        }

        tasks.withType<Test>().configureEach {
            useJUnitPlatform()
        }
    }
}
