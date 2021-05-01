package eu.codeloop

import eu.codeloop.configurations.Configuration
import eu.codeloop.configurations.dependencymanagement.DependencyManagementConfiguration
import eu.codeloop.configurations.dependencymanagement.RepositoriesConfiguration
import eu.codeloop.configurations.style.DetektConfiguration
import eu.codeloop.configurations.tool.JacocoReportConfiguration
import eu.codeloop.configurations.tool.KotlinConfiguration
import eu.codeloop.configurations.tool.WrapperConfiguration

open class CodeloopKotlinPlugin : CodeloopPlugin {

    override fun onConfigure(): List<Configuration> = listOf(
        RepositoriesConfiguration(),
        DependencyManagementConfiguration()
    )

    override fun onAfterEvaluate(): List<Configuration> = listOf(
        KotlinConfiguration(),
        DetektConfiguration(),
        JacocoReportConfiguration(),
        WrapperConfiguration()
    )
}
