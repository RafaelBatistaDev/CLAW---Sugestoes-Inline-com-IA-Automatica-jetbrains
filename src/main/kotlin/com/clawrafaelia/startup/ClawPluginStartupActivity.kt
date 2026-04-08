package com.clawrafaelia.startup

import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class ClawPluginStartupActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        try {
            System.out.println("[CLAW] Plugin iniciado para projeto: ${project.name}")
            
            // Inicializar o SuggestionsManager
            val manager = project.getService(com.clawrafaelia.suggestions.SuggestionsManager::class.java)
            manager.initialize()
            
            // Carregar configurações
            val settings = com.clawrafaelia.settings.ClawSettingsState.getInstance()
            System.out.println("[CLAW] Sugestões habilitadas: ${settings.enableSuggestions}")
            System.out.println("[CLAW] Provedor IA: ${settings.aiProvider}")
            System.out.println("[CLAW] Debug logging: ${settings.enableLogging}")
            
        } catch (e: Exception) {
            System.err.println("[CLAW] Erro ao iniciar plugin: ${e.message}")
            e.printStackTrace()
        }
    }
}
