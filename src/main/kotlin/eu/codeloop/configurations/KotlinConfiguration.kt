package eu.codeloop.configurations

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withConvention
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import eu.codeloop.ext.sourceSets

class KotlinConfiguration : Configuration {

    @SuppressWarnings("StringLiteralDuplication")
    override fun configure(): Action<Project> = Action {
        plugins.apply(KotlinPlatformJvmPlugin::class)

        tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions.jvmTarget = "1.8"
            kotlinOptions.freeCompilerArgs += listOf("-Xjsr305=strict")
        }

        sourceSets {
            create("integration-test") {
                withConvention(KotlinSourceSet::class) {
                    kotlin.srcDir(file("src/integration-test/kotlin"))
                }
                resources.srcDir("src/integration-test/resources")
                compileClasspath += sourceSets["main"].output + sourceSets["test"].output
                runtimeClasspath += sourceSets["main"].output + sourceSets["test"].output
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
    }
}
