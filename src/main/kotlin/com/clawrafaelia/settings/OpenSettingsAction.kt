package com.clawrafaelia.settings

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.options.ShowSettingsUtil

class OpenSettingsAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project
        if (project != null) {
            ShowSettingsUtil.getInstance().showSettingsDialog(project, ClawSettingsConfigurable::class.java)
        }
    }
}
