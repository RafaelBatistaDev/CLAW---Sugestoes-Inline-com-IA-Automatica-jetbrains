# Quick Start - CLAW Rider Plugin

## ⚡ Começar em 3 Passos

### 1. Compilar o Plugin

```bash
cd /home/recifecrypto/Documentos/claw-jetbrains-rider-plugin
./gradlew build
```

Resultado: `build/distributions/claw-jetbrains-rider-plugin-1.1.2.zip`

### 2. Instalar no Rider

1. Abra **Rider 2023+** (ou qualquer JetBrains IDE)
2. **File → Settings → Plugins**
3. ⚙️ **→ Install Plugin from Disk...**
4. Selecione o ZIP compilado
5. **Reinicie** a IDE

### 3. Configurar

1. **File → Settings → Tools → CLAW - Sugestões de Código**
2. Cole sua API key (Google Gemini, OpenAI, etc.)
3. Escolha o Provedor de IA
4. Clique em **Apply → OK**

## ✅ Verificar que Funciona

1. **File → Settings → Tools → CLAW - Configurações Globais**
2. Veja as opções de notificações, cache, timeout
3. Tudo deve carregar **sem freezing**!

## 📁 Estrutura de Arquivos

```
src/main/
├── kotlin/com/clawrafaelia/
│   ├── settings/          ← Configurações UI + estado
│   ├── suggestions/       ← Completion provider
│   └── actions/           ← Ações do menu
└── resources/META-INF/
    └── plugin.xml         ← Registro do plugin
```

## 🛠️ Desenvolvimento

### Editar Configurações
- **Adicionar campo**: Edite `ClawSettingsState.kt` + `ClawSettingsConfigurable.kt`
- **Novo provider IA**: Estenda `InlineCompletionProvider.kt`

### Testar em Desenvolvimento
```bash
./gradlew runIde
```

Será aberto uma IDE de teste com seu plugin.

## 🚀 Empacotar para Distribuição

```bash
./gradlew buildPlugin
```

Resultado em: `build/distributions/`

## 📦 Compatibilidade

- ✅ Rider 2023, 2024, 2025, 2026
- ✅ IntelliJ IDEA Community & Ultimate
- ✅ PyCharm, WebStorm, CLion, etc. (todas as JetBrains IDEs)
- ✅ Java 11+

## ⚠️ Troubleshooting

### Settings não aparecem?
```bash
./gradlew clean build
Reinicie a IDE
```

### Plugin não instala?
```
Verifique: File → Settings → Plugins → Settings ⚙️ → Show All
Procure por "CLAW"
```

### Erro de classe não encontrada?
```bash
rm -rf ~/.gradle/caches/
./gradlew build
```

---

**✨ Pronto para usar!** Configure sua API e comece a receber sugestões de IA em tempo real.
