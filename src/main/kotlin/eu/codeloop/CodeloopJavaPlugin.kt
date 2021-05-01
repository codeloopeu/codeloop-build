package eu.codeloop

import eu.codeloop.configurations.Configuration
import eu.codeloop.configurations.dependencymanagement.DependencyManagementConfiguration
import eu.codeloop.configurations.dependencymanagement.RepositoriesConfiguration
import eu.codeloop.configurations.style.CheckstyleConfiguration
import eu.codeloop.configurations.style.PmdConfiguration
import eu.codeloop.configurations.style.SpotBugsConfiguration
import eu.codeloop.configurations.tool.JacocoReportConfiguration
import eu.codeloop.configurations.tool.JavaConfiguration
import eu.codeloop.configurations.tool.LombokConfiguration
import eu.codeloop.configurations.tool.SpockConfiguration
import eu.codeloop.configurations.tool.WrapperConfiguration

open class CodeloopJavaPlugin : CodeloopPlugin {

    override fun onConfigure(): List<Configuration> = listOf(
        JavaConfiguration(),
        SpockConfiguration(),
        RepositoriesConfiguration(),
        DependencyManagementConfiguration()
    )

    override fun onAfterEvaluate(): List<Configuration> = listOf(
        CheckstyleConfiguration(),
        PmdConfiguration(),
        SpotBugsConfiguration(),
        JacocoReportConfiguration(),
        LombokConfiguration(),
        WrapperConfiguration()
    )
}
