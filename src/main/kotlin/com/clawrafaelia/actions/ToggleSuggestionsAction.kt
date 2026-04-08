package com.clawrafaelia.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.wm.WindowManager

class ToggleSuggestionsAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        try {
            val project = e.project ?: return
            val manager = project.getService(com.clawrafaelia.suggestions.SuggestionsManager::class.java)
            manager.toggleSuggestions()
            
            val status = manager.getStatus()
            System.out.println("[CLAW] Sugestões: $status")
            
            // Atualizar status bar
            val statusBar = WindowManager.getInstance().getStatusBar(project)
            statusBar?.updateWidget("ClawStatusBarWidget")
            
        } catch (ex: Exception) {
            System.err.println("[CLAW] Erro ao toggle: ${ex.message}")
            ex.printStackTrace()
        }
    }
}
