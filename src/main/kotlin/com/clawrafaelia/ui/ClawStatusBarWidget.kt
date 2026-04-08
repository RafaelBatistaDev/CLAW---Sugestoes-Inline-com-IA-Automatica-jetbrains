package com.clawrafaelia.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.StatusBar
import com.intellij.openapi.wm.StatusBarWidget
import com.intellij.openapi.wm.StatusBarWidgetFactory
import com.intellij.util.Consumer
import java.awt.event.MouseEvent

class ClawStatusBarWidgetFactory : StatusBarWidgetFactory {
    override fun getId(): String = "ClawStatusBarWidget"
    override fun getDisplayName(): String = "CLAW - Sugestões"
    override fun isAvailable(project: Project): Boolean = true
    override fun createWidget(project: Project): StatusBarWidget = ClawStatusBarWidget(project)
    override fun disposeWidget(widget: StatusBarWidget) {}
    override fun canBeEnabledOn(statusBar: StatusBar): Boolean = true
}

class ClawStatusBarWidget(private val project: Project) : StatusBarWidget {
    private var statusBar: StatusBar? = null
    private val manager = project.getService(com.clawrafaelia.suggestions.SuggestionsManager::class.java)
    
    override fun install(statusBar: StatusBar) {
        this.statusBar = statusBar
    }
    
    override fun dispose() {
        statusBar = null
    }
    
    override fun ID(): String = "ClawStatusBarWidget"
    
    override fun getPresentation(): StatusBarWidget.WidgetPresentation {
        return ClawWidgetPresentation()
    }
    
    private inner class ClawWidgetPresentation : StatusBarWidget.TextPresentation {
        override fun getTooltipText(): String {
            val settings = com.clawrafaelia.settings.ClawSettingsState.getInstance()
            return if (settings.enableSuggestions) 
                "CLAW ✓ Ativo (${settings.aiProvider}) - Clique para desativar" 
            else 
                "CLAW ✗ Inativo - Clique para ativar"
        }
        
        override fun getClickConsumer(): Consumer<MouseEvent>? = Consumer { _: MouseEvent ->
            try {
                manager.toggleSuggestions()
                statusBar?.updateWidget(ID())
            } catch (e: Exception) {
                System.err.println("[CLAW] Erro no toggle: ${e.message}")
            }
        }
        
        override fun getText(): String {
            val settings = com.clawrafaelia.settings.ClawSettingsState.getInstance()
            return if (settings.enableSuggestions) "CLAW ✓" else "CLAW ✗"
        }
        
        override fun getAlignment(): Float = 0f
    }
}
