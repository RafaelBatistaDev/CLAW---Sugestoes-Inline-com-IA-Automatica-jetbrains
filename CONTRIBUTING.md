# 🤝 Guia de Contribuição - CLAW

Obrigado por seu interesse em contribuir para o CLAW! Este documento fornece orientações para contribuir de forma efetiva.

## 📋 Código de Conduta

- Seja respeitoso e inclusivo
- Não tolere discriminação
- Seja apreciativo com feedback
- Foque no que é melhor para a comunidade

## 🚀 Como Contribuir

### 1. Reportar Bugs

**Antes de reportar**, verifique se o bug já foi reportado em:
→ [Issues do Projeto](https://github.com/RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains/issues)

#### Template para Bug Report

```markdown
## Descrição do Bug
[Descrição clara do bug]

## Passos para Reproduzir
1. [Passo 1]
2. [Passo 2]
3. [Passo 3]

## Comportamento Esperado
[O que deveria acontecer]

## Comportamento Atual
[O que está acontecendo]

## Screenshots
[Se aplicável]

## Ambiente
- IDE: [IntelliJ IDEA 2024.1, Rider 2026, etc]
- Plugin Version: 1.0.3
- OS: [Windows, macOS, Linux]
- Java Version: [17+]
```

### 2. Sugerir Melhorias

Abra uma issue com o título `[Feature Request]` incluindo:
- **Descrição da Feature**
- **Por quê** essa feature seria útil
- **Exemplos** de uso
- **Alternativas** que você considerou

```markdown
[Feature Request] Adicionar suporte para análise de performance

## Descrição
Uma análise automática de performance do código gerado...

## Caso de Uso
Quando desenvolvo código com IA, quero garantir que não há...

## Valores Agregados
- Melhor qualidade de código
- Performance garantida
- Economia de tokens de API
```

### 3. Contribuir com Código

#### Configuração do Ambiente

```bash
# 1. Fork o repository em GitHub

# 2. Clone seu fork
git clone git@github.com:seu-usuario/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains.git
cd claw-jetbrains-rider-plugin

# 3. Adicione upstream (original)
git remote add upstream git@github.com:RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains.git

# 4. Crie uma branch para sua feature
git checkout -b feature/nome-da-feature

# 5. Configure IDE (IntelliJ IDEA)
# - Abra o projeto em IntelliJ
# - Deixe indexar completamente
# - Configure JDK 17+ em Project Structure
```

#### Desenvolvimento

**Padrões de Código:**
- Language: Kotlin (preferido) ou Java
- Style: Official Kotlin Coding Conventions
- Indentation: 4 espaços
- Line length: 120 caracteres máximo

**Exemplo de Código Bem Formatado:**

```kotlin
// com/clawrafaelia/suggestions/MyNewFeature.kt

package com.clawrafaelia.suggestions

import com.intellij.openapi.components.Service
import org.jetbrains.annotations.NotNull

@Service(Service.Level.PROJECT)
class MyNewFeature(@NotNull private val project: Project) {
    
    fun processCode(element: PsiElement): String {
        // Implementação clara
        return element.text
    }
    
    companion object {
        fun getInstance(project: Project): MyNewFeature {
            return project.getService(MyNewFeature::class.java)
        }
    }
}
```

#### Testes

**Adicione testes para suas mudanças:**

```kotlin
// src/test/kotlin/com/clawrafaelia/suggestions/MyNewFeatureTest.kt

import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.junit.Test

@TestDataPath("\$CONTENT_ROOT/src/test/testData")
class MyNewFeatureTest : BasePlatformTestCase() {
    
    @Test
    fun testProcessCode() {
        // Arrange
        val feature = MyNewFeature(project)
        val element = createPsiElement()
        
        // Act
        val result = feature.processCode(element)
        
        // Assert
        assertEquals("expected", result)
    }
}
```

#### Commit e Push

```bash
# 1. Faça commits atômicos com mensagens claras
git add .
git commit -m "feat: adicionar análise de performance

- Implementa análise automática de código
- Inclui detecção de loop infinito
- Adiciona testes unitários
- Atualiza documentação

Closes #123"

# 2. Atualize sua branch com a principal
git pull upstream master

# 3. Push para seu fork
git push origin feature/nome-da-feature
```

**Formato de Commit (Conventional Commits):**
- `feat:` - Nova funcionalidade
- `fix:` - Correção de bug
- `docs:` - Mudanças na documentação
- `style:` - Formatação, sem mudança lógica
- `refactor:` - Refatoração sem mudança funcional
- `perf:` - Melhoria de performance
- `test:` - Adicionar ou atualizar testes
- `chore:` - Mudanças em build, deps, etc

### 4. Pull Request

#### Checklist Antes de Submeter

- [ ] Código segue o style guide
- [ ] Adicionei testes para novas funcionalidades
- [ ] Testes passam localmente
- [ ] Atualizei documentação
- [ ] Commitei com mensagens claras
- [ ] Não há conflitos com `master`

#### Template de PR

```markdown
## Descrição
[Descrição clara do que foi mudado e por quê]

## Tipo de Mudança
- [ ] Bug fix (não quebra funcionalidade)
- [ ] Nova funcionalidade (não quebra funcionalidade)
- [ ] Mudança quebra compatibilidade
- [ ] Documentação

## Relacionado a Issue
Fecha #(número da issue)

## Como Testar
1. [Passo 1]
2. [Passo 2]
3. [Passo 3]

## Screenshots
[Se aplicável]

## Checklist
- [ ] Código segue o style guide
- [ ] Testes passam
- [ ] Documentação atualizada
```

---

## 📚 Diretrizes de Documentação

### README

- Mantenha atualizado com novas funcionalidades
- Inclua exemplos práticos
- Documente configurações

### Code Comments

```kotlin
// ✅ BOM - Explica o POR QUÊ
// Usamos cache porque as sugestões são caras em tokens.
// O TTL de 5 minutos equilibra frescura vs performance
val suggestions = cache.getOrCompute(key) { generateSuggestions() }

// ❌ RUIM - Explica o QUÊ (óbvio)
// Inicializa cache
val cache = HashMap<String, Any>()
```

### Inline Documentation

```kotlin
/**
 * Gera sugestões de código usando o provedor de IA configurado.
 *
 * @param element O elemento PSI a processar
 * @param context O contexto do editor
 * @return Lista de sugestões ordenadas por relevância
 *
 * @throws ApiException se a chamada à API falhar
 */
fun generateSuggestions(element: PsiElement, context: EditorContext): List<Suggestion>
```

---

## 🧪 Executando Testes

```bash
# Todos os testes
gradle test

# Teste específico
gradle test --tests MyNewFeatureTest

# Com coverage
gradle test jacocoTestReport
```

---

## 📈 Melhorias Bem-Vindas

- 🎨 Melhorias de UI/UX
- 🚀 Otimizações de performance
- 📚 Documentação melhorada
- 🧪 Mais testes
- 🌍 Suporte a novos idiomas
- 🔌 Novos provedores de IA
- ♿ Acessibilidade

---

## 🏃 Processo de Review

1. Seu PR será revisado por mantedores
2. Você receberá feedback
3. Faça as mudanças solicitadas
4. PR será mesclado quando aprovado

**Tempo esperado de review:** 3-7 dias

---

## 🛠️ Desenvolvimento

### Estrutura do Projeto

```
src/main/kotlin/com/clawrafaelia/
├── actions/          # Ações do menu
├── settings/         # Configurações
├── suggestions/      # Engine principal
├── startup/          # Inicialização
└── ui/              # Interface
```

### Compilar e Testar Localmente

```bash
# Build
gradle clean build

# Executar IDE de debug
gradle runIde

# Verificar compatibilidade
gradle runPluginVerifier
```

---

## 📞 Perguntas?

- 💬 Crie uma issue para discussão
- 📧 Email: rafaellbatistadev@outlook.com.br
- 💭 Abra uma Discussion

---

## 🎉 Obrigado!

Sua contribuição faz o CLAW melhor para todos!

