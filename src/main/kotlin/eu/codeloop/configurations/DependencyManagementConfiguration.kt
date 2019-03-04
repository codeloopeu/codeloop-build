package eu.codeloop.configurations

import eu.codeloop.ext.dependencyManagement
import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class DependencyManagementConfiguration : Configuration {

    override fun configure(): Action<Project> = Action {
        plugins.apply(DependencyManagementPlugin::class)

        dependencyManagement {
            imports {
                mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR2")
            }
            dependencies {
                dependency("com.github.spotbugs:spotbugs-annotations:3.1.12")
                dependency("com.google.guava:guava:28.2-jre")
                dependency("org.springdoc:springdoc-openapi-ui:1.2.33")
                dependency("org.codehaus.groovy:groovy-all:2.5.9")
                dependency("org.spockframework:spock-core:1.3-groovy-2.5")
                dependency("org.spockframework:spock-spring:1.3-groovy-2.5")
            }
        }
    }
}
