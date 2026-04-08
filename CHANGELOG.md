# 📝 Changelog - CLAW

Todas as mudanças notáveis para este projeto serão documentadas neste arquivo.

O formato é baseado em [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
e este projeto segue [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [1.0.3] - 2026-04-08

### ✨ Adicionado
- 🎨 Integração completa de identidade visual para JetBrains Marketplace
- 📚 Documentação profissional (README, CONTRIBUTING, SECURITY)
- 🔒 Política de segurança detalhada
- 📖 Guia de contribuição com exemplos de código
- 🔄 Changelog estruturado

### 🔧 Alterado
- 📦 Atualização de versão no build.gradle.kts (1.0.2 → 1.0.3)
- 🎭 Ícones do plugin finalizados (pluginIcon.svg e pluginIcon_dark.svg)
- 📝 plugin.xml atualizado com mudanças v1.0.3

### 🐛 Corrigido
- ⚠️ Aviso "Parameter 'element' is never used" em InlineCompletionProvider.kt (sem impact)
- 🔍 Verificações de configuração

### 📊 Status
- ✅ BUILD SUCCESSFUL
- ✅ 13 tasks executadas
- ✅ Pronto para distribuição

---

## [1.0.2] - 2026-04-07

### ✨ Adicionado
- 🚀 Lançamento estável do plugin
- ✅ Suporte completo para Google Gemini
- ✅ Suporte para OpenAI (GPT-4, GPT-3.5)
- ✅ Suporte para Anthropic Claude
- ✅ Suporte para modelos locais (Ollama, LM Studio)
- 🎯 Configurações por projeto
- 📊 Widget de status na barra lateral
- 🎨 Interface intuitiva
- ⚙️ Configurações globais avançadas

### 🔧 Alterado
- 🏗️ Estrutura do projeto finalizada
- 📦 Dependências do IntelliJ SDK atualizadas
- 🔧 Build Gradle otimizado

### 📋 Documentação
- 📖 README inicial
- 🚀 QUICK_START.md

### 🧪 Testes
- ✅ Testes de integração realizados
- ✅ Compatibilidade com múltiplas IDEs verificada

---

## [1.0.1] - 2026-04-05

### ✨ Adicionado
- 🎯 Funcionalidade básica de sugestões inline
- 🧠 Engine de processamento de sugestões
- ⚙️ Configurações iniciais
- 🎨 Interface básica do status bar

### 🐛 Corrigido
- 🔌 Problemas iniciais de integração com IDE
- 🔧 Compatibilidade com Kotlin 1.9.21
- 📦 Resolver dependências conflitantes

### 📚 Documentação
- 📖 Setup básico documentado

---

## [1.0.0] - 2026-04-01

### ✨ Adicionado
- 🎉 Release inicial do CLAW
- 📦 Estrutura básica do plugin
- 🔌 Integração com JetBrains IDE SDK
- 🧪 Framework de testes inicial

### 🎯 Funcionalidades Principais
- ✨ Completação automática de código
- 🤖 Suporte a IA (placeholder)
- 📝 Estrutura para configurações
- 🎨 Estrutura para UI

---

## [Unreleased]

### 🔄 Em Desenvolvimento

#### ✨ Planejado
- 🌍 Suporte para mais idiomas de programação
- 🔌 Novos provedores de IA (Anthropic Claude 4, Grok)
- ⚡ Otimizações de performance
- 🧠 Análise contextual melhorada
- 📊 Estatísticas de uso
- 🔐 Suporte a autenticação OAuth
- 🌐 Suporte multi-repositório
- 📱 Sincronização na nuvem

#### 🚀 Features Futuras
- **v1.1.0**: Análise de performance de código
- **v1.2.0**: Geração de testes automáticos
- **v1.3.0**: Refatoração inteligente
- **v2.0.0**: Marketplace official & suporte profissional

---

## Legenda das Mudanças

- ✨ **Adicionado** - Nova funcionalidade
- 🔧 **Alterado** - Mudança em funcionalidade existente
- 🐛 **Corrigido** - Correção de bug
- 🗑️ **Removido** - Funcionalidade removida
- ⚠️ **Deprecado** - Funcionalidade que será removida
- 🔒 **Segurança** - Correções de segurança críticas

---

## Como Reportar Mudanças

Ao contribuir, atualize este arquivo seguindo:

```markdown
## [X.X.X] - YYYY-MM-DD

### ✨ Adicionado
- Descrição da mudança

### 🔧 Alterado
- Descrição da mudança

### 🐛 Corrigido
- Descrição do fix

### 🗑️ Removido
- Descrição da remoção
```

---

## Versionamento

Seguimos [Semantic Versioning](https://semver.org/):

- **MAIOR** (Major): Mudanças incompatíveis na API
- **MINOR** (Minor): Novas funcionalidades compatíveis
- **PATCH** (Patch): Correção de bugs compatível

Exemplo: `1.0.3`
- `1` = Versão Maior
- `0` = Versão Menor  
- `3` = Patch

---

## Linha do Tempo de Releases

```
2026-04-01: v1.0.0 ✨ Release Inicial
2026-04-05: v1.0.1 🐛 Fixes
2026-04-07: v1.0.2 🚀 Lançamento Estável
2026-04-08: v1.0.3 🎨 Marketplace Ready
```

---

## Suporte de Versão

| Versão | Status | Suporte Até |
|--------|--------|-------------|
| 1.0.3 | ✅ Atual | 2027-04-08 |
| 1.0.2 | 📦 Legacy | 2026-10-08 |
| 1.0.1 | 📦 Legacy | 2026-07-08 |
| 1.0.0 | 🗑️ EOL | 2026-05-01 |

Política: Suporte de 1 ano após release, corridos com segurança até 18 meses.

---

## Próxima Release

**Prevista:** Q2 2026 (Junho)
**Versão:** 1.1.0
**Focus:** Performance e Análise de Código

---

**Última Atualização:** 8 de Abril de 2026  
**Mantainer:** Rafael Batista  
**Email:** rafaellbatistadev@outlook.com.br
