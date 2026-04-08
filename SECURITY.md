# 🔒 Política de Segurança - CLAW

## Relatório de Vulnerabilidades

Estamos levando a segurança do CLAW muito a sério. Se você descobrir uma vulnerabilidade, **não** abra uma issue pública.

### Como Reportar uma Vulnerabilidade

1. **Email**: rafaellbatistadev@outlook.com.br
2. **Assunto**: `[SECURITY] Vulnerabilidade em CLAW`
3. **Conteúdo**:
   - Descrição detalhada da vulnerabilidade
   - Passos para reproduzir (se aplicável)
   - Possível impacto
   - Sua sugestão de fix (se tiver)

### Resposta

- Você receberá confirmação do seu report em **48 horas**
- Trabalharemos em um fix dentro de **7 dias**
- Você poderá sugerir um CVE se apropriado
- Será mencionado no changelog quando corrigido

---

## 🛡️ Segurança das API Keys

### ✅ Boas Práticas

1. **Nunca commit API Keys**
   ```bash
   # ❌ NÃO FAÇA ISSO
   git add config.properties
   
   # ✅ FAÇA ISSO
   echo "config.properties" >> .gitignore
   ```

2. **Use variáveis de ambiente**
   ```kotlin
   // ✅ BOM
   val apiKey = System.getenv("CLAW_API_KEY")
   
   // ❌ RUIM
   val apiKey = "sk-..." // Hardcoded!
   ```

3. **Rotação de chaves**
   - Gire API keys regularmente (a cada 90 dias)
   - Revogue chaves antigas no provider
   - Não compartilhe chaves entre máquinas

4. **Escopo mínimo**
   - Use scopes mínimos em APIs Google/OpenAI
   - Crie API keys separadas para dev/prod
   - Delete chaves não usadas

### 🔐 Como Configurar Seguro

1. **Crie arquivo `.env.local`** (nunca commit)
   ```env
   CLAW_API_PROVIDER=google
   CLAW_API_KEY=your-key-here
   CLAW_API_MODEL=gemini-2.0-flash
   ```

2. **Configure no plugin:**
   - Vá a Settings → CLAW - Configurações Globais
   - Cole sua API Key (será criptografada localmente)

3. **Criptografia local:**
   - Chaves são criptografadas com JetBrains IDE Credentials Store
   - Não são salvos em plain text
   - Removidas ao desinstalar o plugin

---

## 🔍 Verificações de Segurança

### Testes Automáticos

```bash
# Executar análise de segurança
gradle check

# Verificar dependências
gradle dependencyCheck

# OWASP Dependency Check
gradle dependencyCheckAnalyze
```

### Análise de Código Estático

```bash
# SpotBugs (findbugs)
gradle spotbugsMain

# Detekt (Kotlin linter)
gradle detekt
```

---

## ⚠️ Vulnerabilidades Conhecidas

### v1.0.3

- Nenhuma vulnerabilidade conhecida

### v1.0.2

- Nenhuma vulnerabilidade conhecida

### v1.0.1

- **CVE-PENDING**: [Descrição] - Corrigido em v1.0.3

---

## 🔄 Atualizações de Segurança

### Política

- Atualizações críticas: Lançadas em até **24 horas**
- Atualizações altas: Lançadas em até **7 dias**
- Atualizações médias: Próxima versão regular

### Você será notificado de:

- Vulnerabilidades em dependências
- Atualizações de segurança do JetBrains SDK
- Mudanças nas políticas de APIs (Google, OpenAI, etc)

---

## 📦 Dependências Seguras

### Verificar Vulnerabilidades

```bash
# Gradle dependency audit
gradle dependencyAudit

# JAVA-verified packages
gradle dependencies
```

### Dependências Atuais

```gradle
// build.gradle.kts
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

intellij {
    version.set("2023.2.1")
}
```

**Status**: ✅ Todas as dependências estão atualizadas e verificadas

---

## 🔧 Desenvolvimento Seguro

### Antes de Fazer Push

```bash
# 1. Verifique se há secrets
git grep -P '^(?i)(password|api|secret|token|key)=' -- '*.properties' '*.xml' '*.kt'

# 2. Verifique modificações suspeitas
git diff --cached

# 3. Rode testes
gradle test

# 4. Análise estática
gradle check
```

### No CI/CD

- Escaneie commits por secrets
- Verifique dependências vulneráveis
- Execute testes de segurança
- Valide assinaturas de commit

---

## 🎓 Educação em Segurança

### Recursos Recomendados

- [OWASP Top 10](https://owasp.org/www-project-top-ten/)
- [Kotlin Security Guide](https://pinterest.github.io/ktlint/)
- [JetBrains Plugin Security](https://plugins.jetbrains.com/docs/intellij/)
- [API Security Best Practices](https://cloud.google.com/docs/authentication)

---

## 📊 Auditoria de Segurança

## Última Auditoria

- **Data**: Abril de 2026
- **Tipo**: Interna
- **Status**: ✅ Passou

### Próximas Auditorias

- Trimestral (a cada 3 meses)
- Após atualizações maiores
- Sob demanda por comunidade

---

## 🚀 Roadmap de Segurança

- [ ] Implementar 2FA em GitHub
- [ ] Adicionar SBOM (Software Bill of Materials)
- [ ] Auditoria de segurança profissional
- [ ] Integração com GitHub Security Advisory
- [ ] Certificação OWASP

---

## 📞 Contato

**Security Email**: rafaellbatistadev@outlook.com.br

Inclua `[SECURITY]` no assunto para prioridade máxima.

---

**Última Atualização**: 8 de Abril de 2026
