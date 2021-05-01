package eu.codeloop.configurations

import org.gradle.api.Action
import org.gradle.api.Project

interface Configuration {

    fun configure(): Action<Project>
}
