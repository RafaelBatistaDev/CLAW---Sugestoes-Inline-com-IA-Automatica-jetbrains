package com.clawrafaelia.suggestions

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext

class InlineCompletionProvider : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(),
            ClawCompletionProvider()
        )
    }
    
    private class ClawCompletionProvider : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
        ) {
            try {
                val settings = com.clawrafaelia.settings.ClawSettingsState.getInstance()
                
                if (!settings.enableSuggestions) {
                    logDebug("Sugestões desabilitadas", settings)
                    return
                }
                
                val element = parameters.position
                logDebug("Completion acionado - Position: ${element.text.take(20)}", settings)
                
                // Gerar sugestões
                val suggestions = generateSuggestions(element, result, settings)
                logDebug("${suggestions} sugestões adicionadas", settings)
                
            } catch (e: Exception) {
                System.err.println("[CLAW] Erro em completion: ${e.message}")
            }
        }
        
        private fun generateSuggestions(
            element: PsiElement,
            result: CompletionResultSet,
            settings: com.clawrafaelia.settings.ClawSettingsState
        ): Int {
            val suggestions = listOf(
                Triple("// TODO: implementar", "Implementar função", AllIcons.General.TodoDefault),
                Triple("// TODO: validar entrada", "Validar input", AllIcons.General.InspectionsEye),
                Triple("// TODO: tratamento de erro", "Try-catch block", AllIcons.General.Error),
                Triple("// TODO: refatorar", "Otimizar código", AllIcons.General.Warning),
                Triple("// TODO: testes", "Criar teste unitário", AllIcons.General.InspectionsTypos),
                Triple("// FIXME: bug conhecido", "Corrigir bug", AllIcons.General.Information)
            )
            
            var count = 0
            for ((suggestion, description, icon) in suggestions) {
                try {
                    val lookup = LookupElementBuilder.create(suggestion)
                        .withPresentableText(suggestion)
                        .withTypeText(description, true)
                        .withIcon(icon)
                        .withLookupString(suggestion.replace("//", "").trim())
                        .bold()
                    
                    result.addElement(lookup)
                    count++
                } catch (e: Exception) {
                    logDebug("Erro ao adicionar sugestão: ${e.message}", settings)
                }
            }
            return count
        }
        
        private fun logDebug(message: String, settings: com.clawrafaelia.settings.ClawSettingsState) {
            if (settings.enableLogging) {
                System.out.println("[CLAW] $message")
            }
        }
    }
}
