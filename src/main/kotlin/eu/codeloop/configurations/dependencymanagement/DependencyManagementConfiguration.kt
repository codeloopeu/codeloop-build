package eu.codeloop.configurations.dependencymanagement

import eu.codeloop.configurations.Configuration
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
                mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR3")
            }
            dependencies {
                dependency("com.github.spotbugs:spotbugs-annotations:3.1.12")

                dependency("com.google.guava:guava:28.2-jre")

                dependency("org.mapstruct:mapstruct:1.3.1.Final")
                dependency("org.mapstruct:mapstruct-processor:1.3.1.Final")

                dependency("com.vladmihalcea:hibernate-types-52:2.9.7")

                dependency("org.springdoc:springdoc-openapi-ui:1.3.0")

                dependency("org.codehaus.groovy:groovy-all:3.0.2")
                dependency("org.spockframework:spock-spring:2.0-M2-groovy-3.0")

                dependency("net.javacrumbs.json-unit:json-unit-assertj:2.16.2")
                dependency("net.javacrumbs.json-unit:json-unit-spring:2.16.2")
            }
        }
    }
}
