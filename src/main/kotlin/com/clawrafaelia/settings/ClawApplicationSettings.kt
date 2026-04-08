package com.clawrafaelia.settings

import com.intellij.openapi.options.Configurable
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBTextField
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import java.awt.BorderLayout
import java.awt.GridLayout

class ClawApplicationSettings : Configurable {
    private val enableNotificationsCheckBox = JBCheckBox("Ativar notificações", true)
    private val enableLoggingCheckBox = JBCheckBox("Ativar log de atividades", true)
    private val enableCacheCheckBox = JBCheckBox("Ativar cache", true)
    private val cacheSizeField = JBTextField("100", 10)
    private val timeoutMsField = JBTextField("30000", 10)
    private val maxRetriesField = JBTextField("3", 5)
    
    override fun getDisplayName(): String = "CLAW - Configurações Globais"
    
    override fun getHelpTopic(): String? = null
    
    override fun createComponent(): JComponent? {
        return try {
            val mainPanel = JPanel(BorderLayout(10, 10))
            mainPanel.border = javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10)
            
            val settings = ClawSettingsState.getInstance()
            
            // Carregar valores salvos
            enableNotificationsCheckBox.isSelected = settings.enableNotifications
            enableLoggingCheckBox.isSelected = settings.enableLogging
            enableCacheCheckBox.isSelected = settings.cacheEnabled
            cacheSizeField.text = settings.cacheSize.toString()
            timeoutMsField.text = settings.timeoutMs.toString()
            maxRetriesField.text = settings.maxRetries.toString()
            
            val contentPanel = JPanel(GridLayout(6, 2, 10, 10))
            
            contentPanel.add(JLabel("Notificações:"))
            contentPanel.add(enableNotificationsCheckBox)
            
            contentPanel.add(JLabel("Log de Atividades:"))
            contentPanel.add(enableLoggingCheckBox)
            
            contentPanel.add(JLabel("Cache de Sugestões:"))
            contentPanel.add(enableCacheCheckBox)
            
            contentPanel.add(JLabel("Tamanho do Cache (MB):"))
            contentPanel.add(cacheSizeField)
            
            contentPanel.add(JLabel("Timeout (ms):"))
            contentPanel.add(timeoutMsField)
            
            contentPanel.add(JLabel("Máx de Tentativas:"))
            contentPanel.add(maxRetriesField)
            
            mainPanel.add(contentPanel, BorderLayout.NORTH)
            mainPanel.add(JPanel(), BorderLayout.CENTER)
            
            mainPanel
        } catch (e: Exception) {
            System.err.println("[CLAW] Erro em createComponent: ${e.message}")
            e.printStackTrace()
            null
        }
    }
    
    override fun isModified(): Boolean {
        return try {
            val settings = ClawSettingsState.getInstance()
            enableNotificationsCheckBox.isSelected != settings.enableNotifications ||
            enableLoggingCheckBox.isSelected != settings.enableLogging ||
            enableCacheCheckBox.isSelected != settings.cacheEnabled ||
            cacheSizeField.text.toIntOrNull() != settings.cacheSize ||
            timeoutMsField.text.toIntOrNull() != settings.timeoutMs ||
            maxRetriesField.text.toIntOrNull() != settings.maxRetries
        } catch (e: Exception) {
            false
        }
    }
    
    override fun apply() {
        try {
            val settings = ClawSettingsState.getInstance()
            settings.enableNotifications = enableNotificationsCheckBox.isSelected
            settings.enableLogging = enableLoggingCheckBox.isSelected
            settings.cacheEnabled = enableCacheCheckBox.isSelected
            settings.cacheSize = cacheSizeField.text.toIntOrNull() ?: 100
            settings.timeoutMs = timeoutMsField.text.toIntOrNull() ?: 30000
            settings.maxRetries = maxRetriesField.text.toIntOrNull() ?: 3
        } catch (e: Exception) {
            System.err.println("[CLAW] Erro ao apply: ${e.message}")
        }
    }
    
    override fun reset() {
        try {
            val settings = ClawSettingsState.getInstance()
            enableNotificationsCheckBox.isSelected = settings.enableNotifications
            enableLoggingCheckBox.isSelected = settings.enableLogging
            enableCacheCheckBox.isSelected = settings.cacheEnabled
            cacheSizeField.text = settings.cacheSize.toString()
            timeoutMsField.text = settings.timeoutMs.toString()
            maxRetriesField.text = settings.maxRetries.toString()
        } catch (e: Exception) {
            System.err.println("[CLAW] Erro ao reset: ${e.message}")
        }
    }
}
