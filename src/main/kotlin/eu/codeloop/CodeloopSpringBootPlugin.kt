package eu.codeloop

import eu.codeloop.configurations.Configuration
import eu.codeloop.configurations.spring.SpringBootConfiguration
import eu.codeloop.configurations.tool.GitPropertiesConfiguration

open class CodeloopSpringBootPlugin : CodeloopPlugin {

    override fun onAfterEvaluate(): List<Configuration> = listOf(
        SpringBootConfiguration(),
        GitPropertiesConfiguration()
    )
}
