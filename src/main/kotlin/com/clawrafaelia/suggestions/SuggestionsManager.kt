package com.clawrafaelia.suggestions

import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType

@Service(Service.Level.PROJECT)
class SuggestionsManager(private val project: Project) {
    private var isInitialized = false

    fun initialize() {
        if (isInitialized) return

        try {
            val settings = com.clawrafaelia.settings.ClawSettingsState.getInstance()
            LOG.info("SuggestionsManager inicializado para projeto: ${project.name}")
            LOG.info("Estado - Ativo: ${settings.enableSuggestions}, Provider: ${settings.aiProvider}")

            isInitialized = true

            if (settings.enableNotifications) {
                showNotification("CLAW ativado com sucesso!", NotificationType.INFORMATION)
            }
        } catch (e: Exception) {
            LOG.error("Erro ao inicializar: ${e.message}", e)
        }
    }

    fun getStatus(): String {
        val settings = com.clawrafaelia.settings.ClawSettingsState.getInstance()
        return if (settings.enableSuggestions) "ATIVO" else "DESATIVADO"
    }

    fun toggleSuggestions() {
        try {
            val settings = com.clawrafaelia.settings.ClawSettingsState.getInstance()
            settings.enableSuggestions = !settings.enableSuggestions

            val status = if (settings.enableSuggestions) "habilitadas" else "desabilitadas"
            LOG.info("Sugestões $status")

            if (settings.enableNotifications) {
                val message = "Sugestões CLAW foram ${if (settings.enableSuggestions) "ativadas" else "desativadas"}!"
                showNotification(message, NotificationType.INFORMATION)
            }
        } catch (e: Exception) {
            LOG.error("Erro ao alternar estado: ${e.message}", e)
        }
    }

    fun isEnabled(): Boolean {
        return com.clawrafaelia.settings.ClawSettingsState.getInstance().enableSuggestions
    }

    private fun showNotification(message: String, type: NotificationType) {
        try {
            NotificationGroupManager.getInstance()
                .getNotificationGroup("CLAW Notifications")
                .createNotification(message, type)
                .notify(project)
        } catch (e: Exception) {
            LOG.warn("Notificação não pôde ser exibida: $message")
        }
    }

    companion object {
        private val LOG = Logger.getInstance(SuggestionsManager::class.java)
    }
}
