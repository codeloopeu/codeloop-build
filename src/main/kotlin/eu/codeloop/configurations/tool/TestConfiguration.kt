package eu.codeloop.configurations.tool

import eu.codeloop.configurations.Configuration
import eu.codeloop.ext.sourceSets
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
import org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType

class TestConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        sourceSets {
            create("test-integration") {
                java.srcDir("src/test-integration/java")
                resources.srcDir("src/test-integration/resources")
                compileClasspath += sourceSets["main"].output + sourceSets["test"].output + configurations["testRuntimeClasspath"]
                runtimeClasspath += output + compileClasspath + sourceSets["test"].runtimeClasspath
            }
        }

        tasks.register<Test>("integrationTest") {
            description = "Runs the integration tests."
            group = "verification"
            testClassesDirs = sourceSets["test-integration"].output.classesDirs
            classpath = sourceSets["test-integration"].runtimeClasspath
            mustRunAfter(tasks.named("test"))
        }

        tasks.named("check") {
            dependsOn("integrationTest")
        }

        tasks.withType<Test>().configureEach {
            useJUnitPlatform()
            testLogging {
                events = setOf(PASSED, SKIPPED, FAILED)
            }
        }
    }
}
