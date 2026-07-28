package com.clawrafaelia.settings

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.options.Configurable
import com.intellij.ui.components.JBTextField
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent
import javax.swing.JPasswordField

class ClawSettingsConfigurable : Configurable {
    private val apiKeyField = JPasswordField()
    private val providerComboBox = javax.swing.JComboBox(PROVIDERS.toTypedArray())
    private val localEndpointField = JBTextField("http://localhost:11434", 30)
    private val customEndpointField = JBTextField(30)

    override fun getDisplayName(): String = "CLAW - Sugestões de Código"

    override fun getHelpTopic(): String? = null

    override fun createComponent(): JComponent? {
        return try {
            val settings = ClawSettingsState.getInstance()

            apiKeyField.text = settings.apiKey
            providerComboBox.selectedItem = settings.aiProvider.ifEmpty { PROVIDERS.first() }
            localEndpointField.text = settings.localEndpoint
            customEndpointField.text = settings.customEndpoint

            panel {
                group("Provedor de IA") {
                    row("Provedor:") {
                        cell(providerComboBox)
                            .align(AlignX.FILL)
                            .comment("Selecione o provedor de IA para sugestões")
                    }
                    row("Chave da API:") {
                        cell(apiKeyField)
                            .align(AlignX.FILL)
                            .comment("Sua chave de API (armazenada localmente)")
                    }
                    row("Endpoint Local:") {
                        cell(localEndpointField)
                            .align(AlignX.FILL)
                            .comment("Usado apenas com provedor Local (ex: Ollama)")
                    }
                    row("Endpoint Custom:") {
                        cell(customEndpointField)
                            .align(AlignX.FILL)
                            .comment("URL customizada para provedores compatíveis com OpenAI")
                    }
                }

                group("Status") {
                    row("") {
                        val statusText = if (ClawSettingsState.getInstance().enableSuggestions)
                            "✓ Plugin ativo" else "✗ Plugin inativo"
                        comment(statusText)
                    }
                }
            }
        } catch (e: Exception) {
            LOG.error("Erro ao criar painel de configurações: ${e.message}", e)
            null
        }
    }

    override fun isModified(): Boolean {
        return try {
            val settings = ClawSettingsState.getInstance()
            apiKeyField.text != settings.apiKey ||
            providerComboBox.selectedItem.toString() != settings.aiProvider ||
            localEndpointField.text != settings.localEndpoint ||
            customEndpointField.text != settings.customEndpoint
        } catch (e: Exception) {
            false
        }
    }

    override fun apply() {
        try {
            val settings = ClawSettingsState.getInstance()
            settings.apiKey = apiKeyField.text
            settings.aiProvider = providerComboBox.selectedItem.toString()
            settings.localEndpoint = localEndpointField.text.ifBlank { "http://localhost:11434" }
            settings.customEndpoint = customEndpointField.text
            LOG.info("Configurações do provedor atualizadas: ${settings.aiProvider}")
        } catch (e: Exception) {
            LOG.error("Erro ao aplicar configurações: ${e.message}", e)
        }
    }

    override fun reset() {
        try {
            val settings = ClawSettingsState.getInstance()
            apiKeyField.text = settings.apiKey
            providerComboBox.selectedItem = settings.aiProvider.ifEmpty { PROVIDERS.first() }
            localEndpointField.text = settings.localEndpoint
            customEndpointField.text = settings.customEndpoint
        } catch (e: Exception) {
            LOG.error("Erro ao redefinir configurações: ${e.message}", e)
        }
    }

    companion object {
        private val LOG = Logger.getInstance(ClawSettingsConfigurable::class.java)
        private val PROVIDERS = listOf("Google Gemini", "OpenAI", "Anthropic Claude", "Local (Ollama)", "Custom")
    }
}
