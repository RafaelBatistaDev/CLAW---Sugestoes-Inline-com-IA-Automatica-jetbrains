package com.clawrafaelia.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "com.clawrafaelia.settings.ClawSettingsState",
    storages = [Storage("ClawSettings.xml")]
)
class ClawSettingsState : PersistentStateComponent<ClawSettingsState> {
    // API Configuration
    var apiKey: String = ""
    var aiProvider: String = "Google Gemini"
    var localEndpoint: String = "http://localhost:11434"
    var customEndpoint: String = ""
    
    // Suggestions Settings
    var enableSuggestions: Boolean = true
    var autoComplete: Boolean = true
    var debounce: Int = 500
    
    // Model Parameters
    var maxTokens: Int = 2000
    var temperature: Double = 0.7
    
    // Global Settings
    var enableNotifications: Boolean = true
    var enableLogging: Boolean = true
    var cacheSize: Int = 100
    var cacheEnabled: Boolean = true
    
    // Performance
    var timeoutMs: Int = 30000
    var maxRetries: Int = 3
    
    override fun getState(): ClawSettingsState = this
    
    override fun loadState(state: ClawSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }
    
    companion object {
        fun getInstance(): ClawSettingsState =
            ApplicationManager.getApplication().getService(ClawSettingsState::class.java)
    }
}
