package com.clawrafaelia.settings

import com.intellij.openapi.options.Configurable
import com.intellij.ui.components.JBTextField
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel
import java.awt.BorderLayout
import java.awt.GridLayout

class ClawSettingsConfigurable : Configurable {
    private val apiKeyField = JBTextField(30)
    private val providerField = JBTextField(30)
    private var mainPanel: JPanel? = null
    
    override fun getDisplayName(): String = "CLAW - Sugestões de Código"
    
    override fun getHelpTopic(): String? = null
    
    override fun createComponent(): JComponent? {
        return try {
            if (mainPanel == null) {
                mainPanel = JPanel(BorderLayout(10, 10))
                val gridPanel = JPanel(GridLayout(3, 2, 10, 10))
                
                val settings = ClawSettingsState.getInstance()
                apiKeyField.text = settings.apiKey
                providerField.text = settings.aiProvider
                
                gridPanel.add(JLabel("Chave da API:"))
                gridPanel.add(apiKeyField)
                
                gridPanel.add(JLabel("Provedor:"))
                gridPanel.add(providerField)
                
                gridPanel.add(JLabel("Status:"))
                gridPanel.add(JLabel(if (settings.enableSuggestions) "✓ Ativo" else "✗ Inativo"))
                
                mainPanel!!.add(gridPanel, BorderLayout.CENTER)
                mainPanel!!.add(JPanel(), BorderLayout.SOUTH)
            }
            mainPanel
        } catch (e: Exception) {
            System.err.println("[CLAW] Erro ao createComponent: ${e.message}")
            e.printStackTrace()
            null
        }
    }
    
    override fun isModified(): Boolean {
        try {
            val settings = ClawSettingsState.getInstance()
            return apiKeyField.text != settings.apiKey || 
                   providerField.text != settings.aiProvider
        } catch (e: Exception) {
            return false
        }
    }
    
    override fun apply() {
        try {
            val settings = ClawSettingsState.getInstance()
            settings.apiKey = apiKeyField.text
            settings.aiProvider = providerField.text
        } catch (e: Exception) {
            System.err.println("[CLAW] Erro ao apply: ${e.message}")
        }
    }
    
    override fun reset() {
        try {
            val settings = ClawSettingsState.getInstance()
            apiKeyField.text = settings.apiKey
            providerField.text = settings.aiProvider
        } catch (e: Exception) {
            System.err.println("[CLAW] Erro ao reset: ${e.message}")
        }
    }
}
