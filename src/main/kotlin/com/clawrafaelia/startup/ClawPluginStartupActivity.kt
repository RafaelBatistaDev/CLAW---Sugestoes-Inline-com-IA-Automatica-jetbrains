package com.clawrafaelia.startup

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class ClawPluginStartupActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        try {
            LOG.info("Plugin iniciado para projeto: ${project.name}")

            val manager = project.getService(com.clawrafaelia.suggestions.SuggestionsManager::class.java)
            manager.initialize()

            val settings = com.clawrafaelia.settings.ClawSettingsState.getInstance()
            LOG.info("Sugestões habilitadas: ${settings.enableSuggestions}")
            LOG.info("Provedor IA: ${settings.aiProvider}")
            LOG.info("Debug logging: ${settings.enableLogging}")

        } catch (e: Exception) {
            LOG.error("Erro ao iniciar plugin: ${e.message}", e)
        }
    }

    companion object {
        private val LOG = Logger.getInstance(ClawPluginStartupActivity::class.java)
    }
}
