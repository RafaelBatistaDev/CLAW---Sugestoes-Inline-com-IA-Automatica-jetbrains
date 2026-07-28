package com.clawrafaelia.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.wm.WindowManager

class ToggleSuggestionsAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        try {
            val project = e.project ?: return
            val manager = project.getService(com.clawrafaelia.suggestions.SuggestionsManager::class.java)
            manager.toggleSuggestions()

            val status = manager.getStatus()
            LOG.info("Sugestões: $status")

            val statusBar = WindowManager.getInstance().getStatusBar(project)
            statusBar?.updateWidget("ClawStatusBarWidget")

        } catch (ex: Exception) {
            LOG.error("Erro ao alternar sugestões: ${ex.message}", ex)
        }
    }

    override fun update(e: AnActionEvent) {
        super.update(e)
        e.presentation.isEnabled = e.project != null
    }

    companion object {
        private val LOG = Logger.getInstance(ToggleSuggestionsAction::class.java)
    }
}
