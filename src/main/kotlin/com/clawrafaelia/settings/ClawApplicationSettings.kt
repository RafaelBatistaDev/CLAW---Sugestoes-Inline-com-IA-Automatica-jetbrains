package com.clawrafaelia.settings

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.options.Configurable
import com.intellij.ui.components.JBTextField
import com.intellij.ui.dsl.builder.AlignX
import com.intellij.ui.dsl.builder.panel
import javax.swing.JComponent

class ClawApplicationSettings : Configurable {
    private val enableNotificationsCheckBox = com.intellij.ui.components.JBCheckBox("Ativar notificações", true)
    private val enableLoggingCheckBox = com.intellij.ui.components.JBCheckBox("Ativar log de atividades", true)
    private val enableCacheCheckBox = com.intellij.ui.components.JBCheckBox("Ativar cache", true)
    private val cacheSizeField = JBTextField("100", 10)
    private val timeoutMsField = JBTextField("30000", 10)
    private val maxRetriesField = JBTextField("3", 5)

    override fun getDisplayName(): String = "CLAW - Configurações Globais"

    override fun getHelpTopic(): String? = null

    override fun createComponent(): JComponent? {
        return try {
            val settings = ClawSettingsState.getInstance()

            enableNotificationsCheckBox.isSelected = settings.enableNotifications
            enableLoggingCheckBox.isSelected = settings.enableLogging
            enableCacheCheckBox.isSelected = settings.cacheEnabled
            cacheSizeField.text = settings.cacheSize.toString()
            timeoutMsField.text = settings.timeoutMs.toString()
            maxRetriesField.text = settings.maxRetries.toString()

            panel {
                group("Notificações e Log") {
                    row("") {
                        cell(enableNotificationsCheckBox)
                            .comment("Exibir notificações ao ativar/desativar sugestões")
                    }
                    row("") {
                        cell(enableLoggingCheckBox)
                            .comment("Registrar atividades do plugin para diagnóstico")
                    }
                }

                group("Cache de Sugestões") {
                    row("") {
                        cell(enableCacheCheckBox)
                            .comment("Armazenar sugestões em cache para melhor desempenho")
                    }
                    row("Tamanho do Cache (MB):") {
                        cell(cacheSizeField)
                            .align(AlignX.FILL)
                            .comment("Máximo de memória para cache (recomendado: 50-500)")
                    }
                }

                group("Performance") {
                    row("Timeout (ms):") {
                        cell(timeoutMsField)
                            .align(AlignX.FILL)
                            .comment("Tempo máximo de espera por resposta da IA")
                    }
                    row("Máx. Tentativas:") {
                        cell(maxRetriesField)
                            .align(AlignX.FILL)
                            .comment("Número de tentativas em caso de falha na requisição")
                    }
                }
            }
        } catch (e: Exception) {
            LOG.error("Erro ao criar painel de configurações globais: ${e.message}", e)
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

            settings.cacheSize = cacheSizeField.text.toIntOrNull()
                ?.coerceIn(MIN_CACHE_SIZE, MAX_CACHE_SIZE)
                ?: DEFAULT_CACHE_SIZE
            settings.timeoutMs = timeoutMsField.text.toIntOrNull()
                ?.coerceIn(MIN_TIMEOUT_MS, MAX_TIMEOUT_MS)
                ?: DEFAULT_TIMEOUT_MS
            settings.maxRetries = maxRetriesField.text.toIntOrNull()
                ?.coerceIn(MIN_RETRIES, MAX_RETRIES)
                ?: DEFAULT_RETRIES

            LOG.info("Configurações globais atualizadas: cache=${settings.cacheSize}MB, timeout=${settings.timeoutMs}ms, retries=${settings.maxRetries}")
        } catch (e: Exception) {
            LOG.error("Erro ao aplicar configurações globais: ${e.message}", e)
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
            LOG.error("Erro ao redefinir configurações globais: ${e.message}", e)
        }
    }

    companion object {
        private val LOG = Logger.getInstance(ClawApplicationSettings::class.java)
        private const val MIN_CACHE_SIZE = 10
        private const val MAX_CACHE_SIZE = 1000
        private const val DEFAULT_CACHE_SIZE = 100
        private const val MIN_TIMEOUT_MS = 1000
        private const val MAX_TIMEOUT_MS = 300000
        private const val DEFAULT_TIMEOUT_MS = 30000
        private const val MIN_RETRIES = 0
        private const val MAX_RETRIES = 10
        private const val DEFAULT_RETRIES = 3
    }
}
