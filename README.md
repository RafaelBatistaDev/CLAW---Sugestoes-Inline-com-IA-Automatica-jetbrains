# 🦅 CLAW - Sugestões Inline com IA Automática para JetBrains

![Version](https://img.shields.io/badge/version-1.0.4-blue.svg)
![License](https://img.shields.io/badge/license-MIT-green.svg)
![JetBrains Plugin](https://img.shields.io/badge/Jetbrains-Plugin-orange.svg)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.21-blue.svg)

> Um plugin poderoso para JetBrains IDE (IntelliJ IDEA, Rider, WebStorm, PyCharm) que fornece sugestões de código inteligentes e em tempo real usando IA (Gemini, OpenAI, Claude e modelos locais).

## ✨ Funcionalidades

- 🤖 **Sugestões de Código em Tempo Real** - Completações inteligentes enquanto você digita
- 🧠 **Múltiplos Provedores de IA:**
  - Google Gemini (recomendado)
  - OpenAI (GPT-4, GPT-3.5)
  - Anthropic (Claude)
  - Modelos Locais (Ollama, LM Studio)
- 💾 **Análise de Contexto** - Entende seu código e o contexto do projeto
- 🎨 **Interface Visual Integrada** - Widget de status na barra lateral
- ⚙️ **Configurações Flexíveis:**
  - Modelos customizáveis
  - Controle de temperatura e contexto
  - Suporte a múltiplas linguagens
- 📊 **Suporte para 10+ Linguagens de Programação**
  - Java, Kotlin, Python, JavaScript, TypeScript, Go, Rust, C#, C++, PHP, mais...

---

## 🚀 Instalação Rápida

### Via JetBrains Marketplace

1. Abra sua IDE JetBrains
2. Vá para **Settings → Plugins → Marketplace**
3. Procure por **"CLAW"**
4. Clique em **Install**
5. Reinicie a IDE

### Build Manual

```bash
# Clone o repositório
git clone git@github.com:RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains.git
cd claw-jetbrains-rider-plugin

# Compile com Gradle
gradle clean build

# O arquivo .zip do plugin estará em:
# build/distributions/claw-jetbrains-rider-plugin-1.0.3.zip
```

---

## ⚙️ Configuração Inicial

### 1️⃣ Google Gemini (Recomendado)

```bash
# Obtenha sua chave em: https://ai.google.dev/

# No plugin (Settings → Tools → CLAW - Configurações Globais):
┌─ API Provider: Google Gemini
├─ API Key: (cole aqui)
└─ Model: gemini-2.0-flash (padrão)
```

### 2️⃣ OpenAI

```bash
# Chave em: https://platform.openai.com/api-keys

# No plugin:
┌─ API Provider: OpenAI
├─ API Key: sk-...
└─ Model: gpt-4 ou gpt-3.5-turbo
```

### 3️⃣ Claude (Anthropic)

```bash
# Chave em: https://console.anthropic.com/

# No plugin:
┌─ API Provider: Claude
└─ API Key: (cole aqui)
```

### 4️⃣ Modelos Locais

```bash
# Instale: https://ollama.ai ou https://lmstudio.ai

# No plugin:
┌─ API Provider: Local
├─ Base URL: http://localhost:11434
└─ Model: mistral (ou outro)
```

---

## 📖 Como Usar

### ⌨️ Atalhos de Teclado

| Atalho | Ação |
|--------|------|
| `Alt + /` | Ativar completação CLAW |
| `Tab` | Aceitar sugestão |
| `Esc` | Rejeitar sugestão |
| `↑ ↓` | Navegar entre sugestões |

### 🖱️ Menu Contextual

Clique com botão direito no editor:
- 🔍 Gerar sugestões de código
- ♻️ Refatorar código selecionado
- 📝 Documentar função
- 🧪 Gerar testes

### 📊 Widget de Status

Na barra inferior direita, você verá:
- 🟢 **Verde**: Conectado e pronto
- 🟡 **Amarelo**: Processando sugestão
- 🔴 **Vermelho**: Erro de conexão

---

## 🔧 Configurações Avançadas

### Projeto → CLAW - Sugestões de Código

```yaml
Ativar/Desativar: true
Contexto de Linhas: 10
Temperatura: 0.7
Max Tokens: 200
Cache: Habilitado
```

### Global → CLAW - Configurações Globais

```yaml
Provedor Padrão: Google Gemini
API Keys: (suas credenciais)
Timeout: 30s
Retenção de Cache: 1h
Log Level: INFO
```

---

## 🏗️ Estrutura do Projeto

```
src/main/kotlin/com/clawrafaelia/
├── actions/          # Ações do menu
│   ├── RefactorAction.kt
│   ├── DocumentAction.kt
│   └── GenerateTestAction.kt
├── settings/         # Configurações (UI + State)
│   ├── ClawSettingsState.kt
│   ├── ClawSettingsConfigurable.kt
│   └── ClawApplicationSettings.kt
├── suggestions/      # Engine de sugestões
│   ├── InlineCompletionProvider.kt
│   └── SuggestionsManager.kt
├── startup/          # Inicialização
│   └── ClawPluginStartupActivity.kt
└── ui/              # Interface
    ├── ClawStatusBarWidget.kt
    └── ClawStatusBarWidgetFactory.kt

build/
├── classes/         # Bytecode compilado
├── distributions/   # ZIP do plugin
└── libs/           # Dependências
```

---

## 📋 Requisitos

| Item | Mínimo | Recomendado |
|------|--------|-------------|
| **IDE** | IntelliJ 2023.2 | IntelliJ 2024.1+ |
| **Rider** | 2023.2 | 2026+ |
| **Java** | 17 | 17+ |
| **Kotlin** | 1.9.21 | 1.9.21+ |
| **Gradle** | 8.0 | 8.0+ |

### 🌍 IDEs Suportadas

- ✅ IntelliJ IDEA (Community & Ultimate)
- ✅ JetBrains Rider (C# & .NET)
- ✅ JetBrains PyCharm (Python)
- ✅ JetBrains WebStorm (JavaScript/TypeScript)
- ✅ JetBrains GoLand (Go)
- ✅ JetBrains CLion (C/C++)
- ✅ JetBrains PhpStorm (PHP)
- ✅ JetBrains RubyMine (Ruby)
- ✅ JetBrains DataGrip (SQL)

---

## 🔨 Build e Compilação

### Compilar

```bash
cd /home/recifecrypto/Documentos/claw-jetbrains-rider-plugin
gradle clean build
```

### Modo Debug

```bash
gradle runIde
# Abre IDE de teste com plugin ativo
```

### Verificador de Plugin

```bash
gradle runPluginVerifier
# Verifica compatibilidade com versões do IDE
```

---

## 📊 Changelog

### v1.0.3 (2026-04-08) ✨

- 🎨 Correções de ícones
- 🎭 Integração de identidade visual JetBrains Marketplace
- 🐛 Bugs fixes em InlineCompletionProvider
- ♻️ Refatoração de código
- ✅ Compilação 100% limpa

### v1.0.2

- 🚀 Lançamento estável
- ✅ Suporte Gemini/OpenAI/Claude
- 🎯 Configurações por projeto
- 📊 Widget de status

### v1.0.1

- 🐛 Fixes iniciais
- 📚 Primeira documentação

### v1.0.0

- 🎉 Release inicial

---

## 🐛 Reportar Bugs

Encontrou um problema?

1. Vá para [Issues](https://github.com/RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains/issues)
2. Clique em **New Issue**
3. Descreva o problema com:
   - Versão do plugin
   - Versão da IDE
   - Sistema operacional
   - Passos para reproduzir
   - Screenshots (se aplicável)

---

## 💡 Sugestões de Melhorias

Tem uma ideia brilhante?

👉 Vá para [Discussions](https://github.com/RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains/discussions)

---

## 🤝 Contribuindo

Adoraríamos sua contribuição!

### Processo

```bash
# 1. Fork o repositório
# 2. Clone seu fork
git clone git@github.com:seu-usuario/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains.git

# 3. Crie uma branch
git checkout -b feature/sua-feature

# 4. Faça alterações e commit
git add .
git commit -m "Add: minha feature incrível"

# 5. Push
git push origin feature/sua-feature

# 6. Abra Pull Request
```

### Diretrizes

- ✅ Código em Kotlin (preferido) ou Java
- ✅ Siga Kotlin oficial style guide
- ✅ Adicione testes
- ✅ Atualize documentação
- ✅ Commits com mensagens claras

---

## 📄 Licença

MIT License - veja [LICENSE](LICENSE) para detalhes

```
Copyright (c) 2026 Rafael Batista

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction...
```

---

## 👨‍💻 Autor

<div align="center">

**Rafael Batista**

[GitHub](https://github.com/RafaelBatistaDev) • [Email](mailto:rafaellbatistadev@outlook.com.br)

Desenvolvedor Full-Stack | Plugin Creator | IA Enthusiast

</div>

---

## 🙏 Agradecimentos

- [JetBrains](https://www.jetbrains.com/) - IDE e Plugin SDK excelentes
- [Google Gemini](https://ai.google.dev/) - IA de ponta
- [OpenAI](https://openai.com/) - GPT models
- [Anthropic](https://www.anthropic.com/) - Claude
- Comunidade Kotlin e JetBrains

---

## 📞 Suporte e Links

### Documentação e Comunidade

- 📘 **Documentação**: [Wiki do Projeto](https://github.com/RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains/wiki)
- 💬 **Discussões**: [GitHub Discussions](https://github.com/RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains/discussions)
- 🐛 **Reportar Bug**: [Issues](https://github.com/RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains/issues)
- 🌟 **Deixar uma Star**: [Repository](https://github.com/RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains)

### Legal & Informações

- 📄 **License**: [MIT License](https://github.com/RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains/blob/master/LICENSE)
- 🔐 **Privacy Policy**: [Política de Privacidade](https://github.com/RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains/blob/master/PRIVACY_POLICY.md)
- 📜 **Copyright**: [Direitos Autorais](https://github.com/RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains/blob/master/COPYRIGHT.md)
- 💻 **Source Code**: [GitHub Repository](https://github.com/RafaelBatistaDev/CLAW---Sugestoes-Inline-com-IA-Automatica-jetbrains)

---

## ⭐ Mostre seu Apoio

Se este plugin é útil para você:

- 🌟 **Star** este repositório
- 🐦 **Compartilhe** nas redes sociais
- 💬 **Recomende** para colegas
- 🐛 **Reporte** bugs para melhorar

---

<div align="center">

**Feito com ❤️ para a comunidade JetBrains**

![Last Update](https://img.shields.io/badge/Last%20Update-Apr%202026-brightgreen)
![Status](https://img.shields.io/badge/Status-Ativo-brightgreen)

</div>

### Executar em Desenvolvimento

```bash
./gradlew runIde
```

### Empacotar para Distribuição

```bash
./gradlew buildPlugin
```

O arquivo ZIP compilado estará em `build/distributions/claw-jetbrains-rider-plugin-1.1.2.zip`

## Instalação

1. Abra Rider
2. Vá para: **File → Settings → Plugins**
3. Clique em **⚙️ → Install Plugin from Disk...**
4. Selecione o arquivo `.zip` compilado
5. Reinicie a IDE
6. Vá para: **File → Settings → Tools → CLAW**

## Configuração

Após instalar:

1. **Sugestões de Código**: Configure sua API key (Google Gemini, OpenAI, etc.)
2. **Configurações Globais**: Ajuste cache, logging, timeout

## Recursos

✅ Sugestões inline em tempo real  
✅ Suporte a múltiplos provedores de IA  
✅ Cache de sugestões  
✅ Configuração persistente  
✅ Logging e debugging  
✅ Completamente async (sem bloqueios)  

## Estrutura de Classes

### ClawSettingsState
- PersistentStateComponent que armazena todas as configurações em `ClawSettings.xml`
- Propriedades: apiKey, aiProvider, enableSuggestions, debounce, maxTokens, temperature, etc.
- Acesso: `ClawSettingsState.getInstance()`

### ClawSettingsConfigurable
- Configurable para "CLAW - Sugestões de Código" (nível de projeto)
- 3 campos principais: API Key, Provedor, Status

### ClawApplicationSettings
- Configurable para "CLAW - Configurações Globais" (nível de aplicação)
- 6 campos: Notificações, Logging, Cache, Timeout, Retries

### InlineCompletionProvider
- CompletionContributor para todas as linguagens
- Mostra sugestões de placeholder (pronto para integração com APIs)

### SuggestionsManager
- Service de projeto para gerenciar sugestões
- Métodos: initialize(), getStatus(), toggleSuggestions()

## Desenvolvimento

Para adicionar novos provedores de IA:

1. Estenda `InlineCompletionProvider.kt` para chamar APIs
2. Adicione configurações em `ClawSettingsState.kt`
3. Atualize a UI em `ClawSettingsConfigurable.kt`

## Recursos Técnicos

- **Threading**: Todas as operações usam `ProcessingContext` do IntelliJ (thread-safe)
- **Persistência**: Usa `PersistentStateComponent` + `XmlSerializerUtil`
- **UI**: GridLayout + JPanel (compatível com JetBrains Swing)
- **Build**: Gradle Kotlin DSL com plugin JetBrains IntelliJ

## Troubleshooting

### Settings não aparecem
```
Verifique que parentId="tools" está correto em plugin.xml
Reinicie a IDE após instalar
```

### Erro de classe não encontrada
```
gradle clean build
Limpe ~/.gradle/caches/
```

### Plugin não funciona em Rider
```
Verifique compatibilidade: Rider 2023+ (build 232.10300+)
```

## Autor

Rafael Batista - [@RafaelBatistaDev](https://github.com/RafaelBatistaDev)

## Licença

MIT
