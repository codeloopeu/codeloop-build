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
                mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
                mavenBom("org.springframework.cloud:spring-cloud-dependencies:2020.0.0")
            }
            dependencies {
                dependency("com.google.guava:guava:30.1.1-jre")

                dependency("org.mapstruct:mapstruct:1.4.2.Final")
                dependency("org.mapstruct:mapstruct-processor:1.4.2.Final")

                dependency("com.vladmihalcea:hibernate-types-52:2.10.4")

                dependency("org.springdoc:springdoc-openapi-ui:1.5.8")

                dependency("org.codehaus.groovy:groovy-all:3.0.2")
                dependency("org.spockframework:spock-spring:2.0-M2-groovy-3.0")

                dependency("net.javacrumbs.json-unit:json-unit-assertj:2.25.0")
                dependency("net.javacrumbs.json-unit:json-unit-spring:2.25.0")
            }
        }
    }
}
