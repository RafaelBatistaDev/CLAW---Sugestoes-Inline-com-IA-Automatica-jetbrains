# 🔐 Política de Privacidade - CLAW

**Data de Vigência:** 8 de Abril de 2026  
**Última Atualização:** 8 de Abril de 2026  
**Versão:** 1.0

---

## 📋 Tabela de Conteúdos

1. [Introdução](#introdução)
2. [Informações que Coletamos](#informações-que-coletamos)
3. [Como Usamos Suas Informações](#como-usamos-suas-informações)
4. [Compartilhamento de Dados](#compartilhamento-de-dados)
5. [Segurança de Dados](#segurança-de-dados)
6. [Seus Direitos](#seus-direitos)
7. [Cookies e Tecnologias Similares](#cookies-e-tecnologias-similares)
8. [Retenção de Dados](#retenção-de-dados)
9. [Contato](#contato)

---

## 🎯 Introdução

Bem-vindo ao CLAW - Sugestões Inline com IA Automática para JetBrains ("nós", "nosso" ou "Plugin").

Estamos comprometidos em proteger sua privacidade. Esta Política de Privacidade explica como coletamos, usamos, divulgamos e protegemos suas informações quando você usa nosso plugin.

**Por favor, leia esta política cuidadosamente.**

---

## 📊 Informações que Coletamos

### 1. Informações que Você Fornece Voluntariamente

#### Configurações da API

Quando você configura o plugin, coletamos:

- **API Keys**: Suas chaves de API para provedores (Google Gemini, OpenAI, Claude)
  - ⚠️ **IMPORTANTE**: Suas API Keys são **criptografadas localmente** usando o JetBrains IDE Credentials Store
  - Nunca são enviadas para nossos servidores
  - Armazenadas apenas em sua máquina

- **Preferências de Configuração**:
  - Modelo de IA selecionado
  - Temperatura e parâmetros
  - Idiomas programação preferidos
  - Controles de ativação/desativação

#### Feedback e Relatórios

Quando você escolhe fornecer feedback:

- Mensagens de sugestão
- Relatórios de erro (voluntários)
- Comentários sobre usabilidade

### 2. Informações Coletadas Automaticamente

#### Dados de Uso (Opcional)

Se você consentir com telemetria (desabilitado por padrão):

- 🟢 **GREEN DATA** (Anônimo e não sensível):
  - Qual linguagem de programação está usando
  - Qual provedor de IA seleciona
  - Quais funcionalidades usa com mais frequência
  - Estatísticas de tempo de resposta da IA

- 🔴 **RED DATA** (Nunca coletamos):
  - Conteúdo do seu código
  - APIs keys (criptografadas localmente)
  - Dados sensíveis de seus projetos
  - Informações pessoais identificáveis

#### Dados Técnicos

Informações sobre sua IDE e ambiente:

- Versão do JetBrains IDE
- Sistema operacional e versão
- Versão do Java/Kotlin
- Versão do Plugin CLAW

**Como coletamos:**
- ✅ Token de sessão anônimo (ID aleatório, sem PII)
- ✅ Enviado apenas após você consentir
- ✅ Nunca vinculado a sua identidade

### 3. Informações de Terceiros (Provedores de IA)

Quando você usa provedores de IA:

#### Google Gemini
- Segue [Política de Privacidade do Google](https://policies.google.com/privacy)
- Seu código é enviado para Google para processamento
- Google pode usar dados para melhorar serviços (com opção de opt-out)

#### OpenAI
- Segue [Política de Privacidade da OpenAI](https://openai.com/privacy)
- Seu código é enviado para OpenAI para processamento
- OpenAI não treina modelos com dados da API

#### Claude (Anthropic)
- Segue [Política de Privacidade da Anthropic](https://www.anthropic.com/privacy)
- Dados são processados em conformidade com GDPR/CCPA
- Uso ético de dados garantido

#### Modelos Locais (Ollama/LM Studio)
- ✅ Nenhum dado é enviado
- Seu código permanece **100% local**
- Processamento privado garantido

---

## 🔄 Como Usamos Suas Informações

### Propósitos Legítimos

1. **Funcionalidade do Plugin**
   - Gerar sugestões de código
   - Processar suas solicitações
   - Melhorar precisão das sugestões

2. **Manutenção e Suporte**
   - Diagnosticar problemas técnicos
   - Resolvendo bugs
   - Melhorando performance

3. **Melhoria de Serviço**
   - Entender quais features são mais usadas
   - Identificar falhas/crashes
   - Planejar futuras versões

4. **Conformidade Legal**
   - Cumprir leis aplicáveis
   - Proteger direitos legais
   - Responder a solicitações legais

### O que NÃO Fazemos

- ❌ Não vendemos seus dados
- ❌ Não compartilhamos com third-parties não autorizados
- ❌ Não usamos para fins de marketing sem consentimento
- ❌ Não rastreamos você fora do plugin
- ❌ Não analisamos conteúdo do seu código sem permissão

---

## 👥 Compartilhamento de Dados

### Provedores de IA

Você controla totalmente o compartilhamento:

```
Seu Código
    ↓
[Sua Máquina - Encriptado]
    ↓
Você Escolhe Provedor:
├─ Google Gemini → Google (com sua chave)
├─ OpenAI → OpenAI (com sua chave)
├─ Claude → Anthropic (com sua chave)
└─ Ollama → Seu Computador (100% local)
```

**Você tem CONTROLE total** sobre qual provedor usar.

### Subcontratados

- **Plataforma Hospedagem**: GitHub (repositório)
- **Distribuição**: JetBrains Marketplace
- **Analytics** (opcional): Nenhum por padrão

### Requisitos Legais

Podemos divulgar informações se:
- Ordenado por tribunal
- Requerido por lei
- Proteção de direitos/segurança

---

## 🔒 Segurança de Dados

### Proteção de API Keys

```
API Key → JetBrains IDE Credentials Store
                ↓
        [Sistema Operacional]
        [Criptografia do Sistema]
        [Não acessível a outros aplicativos]
```

**Garantias de Segurança:**
- ✅ Criptografadas com padrão de segurança do IDE
- ✅ Armazenadas localmente (nunca nos servidores)
- ✅ Deletadas ao desinstalar plugin
- ✅ Nunca armazenadas em logs

### Boas Práticas de Segurança

1. **Use Variáveis Ambientais**
   ```bash
   export CLAW_API_KEY="sua-chave"
   ```

2. **Rotação de Chaves (90 dias)**
   - Gire API keys regularmente
   - Revogue chaves antigas
   - Monitore usos suspeitos

3. **Controle de Acesso**
   - Use scopes mínimos em APIs
   - Crie chaves separadas por projeto
   - Delete chaves não usadas

4. **Detecção de Vazamento**
   - Não compartilhe chaves
   - Nunca commit em git
   - Use `.gitignore`

---

## 📋 Seus Direitos

### Direitos de Privacidade

Você tem direito a:

**1. Direito de Acesso**
- Saber quais dados coletamos
- Solicitar cópia de seus dados

**2. Direito de Exclusão**
- "Direito ao esquecimento"
- Solicitar que deletemos seus dados
- Deletar localmente em qualquer momento

**3. Direito de Portabilidade**
- Receber dados em formato estruturado
- Transferir para outro serviço

**4. Direito de Objection**
- Optar por não telemetria
- Desativar coleção de dados

**5. Direito de Retificação**
- Corrigir dados imprecisos
- Atualizar informações

### GDPR (EU) e CCPA (CA)

Se você reside na UE ou Califórnia:

- ✅ GDPR compliant
- ✅ CCPA compliant
- ✅ Direito a consentimento informado
- ✅ Direito a dados pessoais

### Como Exercer Seus Direitos

**Email**: rafaellbatistadev@outlook.com.br  
**Assunto**: `[PRIVACY] Solicitação de Direitos`

Responderemos em **30 dias**.

---

## 🍪 Cookies e Tecnologias Similares

### Plugin (Desktop)

O plugin CLAW **não usa cookies** convencionais porque:
- Não há componente web
- Executa localmente
- Sem rastreamento de sessão cruzada

### Preferências Armazenadas Localmente

Armazenamos no sua máquina:
- Preferências do editor
- Histórico de configurações
- Cache de sugestões

**Todos os dados são locais e controlados por você.**

### Rastreamento de Terceiros

Quando você usa IA em nuvem, esses provedores podem usar:
- Cookies / session tokens
- Rastreamento de API
- Analytics de uso

**Consulte suas políticas:**
- Google: https://policies.google.com/privacy
- OpenAI: https://openai.com/privacy
- Anthropic: https://www.anthropic.com/privacy

---

## ⏰ Retenção de Dados

### Dados Locais

| Tipo de Dado | Retenção | Controle |
|--------------|----------|----------|
| Preferências | Indefinida | Manual (até desinstalar) |
| Cache de Sugestões | 7 dias | Automático |
| Logs de Erro | 30 dias | Automático |
| API Keys | Indefinida | Manual (você remove) |

### Dados Remotos (Analytics)

- 📊 **Se Habilitado**: 90 dias
- 🚫 **Se Desabilitado**: Nenhum dado enviado
- **Padrão**: Desabilitado

### Suas Solicitações

Se você reportar um bug:
- Armazenado até resolução
- Deletado após fechamento
- Você pode solicitar
 exclusão

---

## 📞 Contato

### Dúvidas Sobre Privacidade?

**Email**: rafaellbatistadev@outlook.com.br

**Assunto**: `[PRIVACY] Sua Pergunta`

### Estrutura da Resposta

Você receberá:
- ✅ Confirmação em 48 horas
- ✅ Resposta completa em 7 dias
- ✅ Suporte contínuo se necessário

### Outras Formas de Contato

- 💬 **GitHub Discussions**: [Link do Projeto]
- 🐛 **Issues**: Apenas para bugs técnicos
- 📱 **Social**: @RafaelBatistaDev

---

## 🏛️ Conformidade Legal

### Leis Aplicáveis

Este Política de Privacidade respeita:

- ✅ **GDPR** (General Data Protection Regulation) - UE
- ✅ **CCPA** (California Consumer Privacy Act) - EUA
- ✅ **LGPD** (Lei Geral de Proteção de Dados) - Brasil
- ✅ **PIPEDA** (Personal Information Protection and Electronic Documents Act) - Canadá

### Jurisdição

- **Lei Aplicável**: Lei Brasileira (onde cabível)
- **Foro**: Justiça do Estado de Pernambuco
- **Tratados Internacionais**: Respeitados

---

## 🔄 Alterações a Esta Política

### Notificações de Mudanças

Se alterarmos esta política:
- 📧 Você será notificado por email (se fornecer)
- 📢 Anúncio no GitHub Releases
- 📝 Changelog detalhado

### Versões Anteriores

Versões antigas desta política estão disponíveis em:
- GitHub History
- Arquivo
 Web (archive.org)

---

## 📚 Recursos Adicionais

### Para Entender Melhor Sua Privacidade

- [What is GDPR?](https://gdpr-info.eu/)
- [EFF Privacy Guide](https://ssd.eff.org/)
- [Mozilla Privacy Hub](https://www.mozilla.org/en-US/privacy/)
- [Your Digital Rights](https://www.eff.org/issues/privacy)

### Ferramentas de Privacidade Recomendadas

- **Password Manager**: Bitwarden, 1Password
- **VPN**: Mullvad, ProtonVPN
- **DNS Seguro**: Quad9, NextDNS
- **Email**: ProtonMail, Tutanota
- **2FA**: Authy, Bitwarden

---

## ✅ Checklist de Privacidade

Use este checklist para verificar sua privacidade:

- [ ] Visite Settings → CLAW - Configurações Globais
- [ ] Desabilite Telemetria (será desabilitado por padrão)
- [ ] Guarde sua API Key com segurança
- [ ] Rotacione API Keys a cada 90 dias
- [ ] Use modelos locais para máxima privacidade
- [ ] Revise logs de erro periodicamente
- [ ] Exclua cache conforme necessário

---

## 🎯 Responsabilidades Suas

Para proteger sua privacidade:

### ✅ Faça Isso

- ✅ Mantenha suas API Keys seguras
- ✅ Use senhas fortes
- ✅ Atualize plugin regularmente
- ✅ Reporte problemas de segurança
- ✅ Monitore atividades anormais

### ❌ Não Faça Isso

- ❌ Não compartilhe API Keys
- ❌ Não commit chaves no git
- ❌ Não use senhas fracas
- ❌ Não ignore atualizações
- ❌ Não execute versões antigas

---

## 📊 Transparência de Dados

### O Que Coletamos (Se Habilitado)

```json
{
  "session_id": "random-uuid-not-pii",
  "timestamp": "2026-04-08T13:00:00Z",
  "ide_version": "2024.1",
  "os_type": "Linux",
  "plugin_version": "1.0.3",
  "ai_provider": "gemini",
  "feature_used": "InlineCompletion",
  "response_time_ms": 245
}
```

**Observações:**
- Nenhuma informação pessoal (PII)
- Nenhum conteúdo do código
- Sem chaves de API
- Anonimizado com session_id aleatório

---

## 🚀 Futuro da Privacidade

### Roadmap de Privacidade

- [ ] End-to-End Encryption option
- [ ] Local-only mode melhorado
- [ ] Privacy dashboard integrado
- [ ] Auditoria independente
- [ ] Certificação de privacidade

### Seu Feedback Importa

Sugestões de privacidade:
1. Abra uma Issue: `[PRIVACY]`
2. Envie email: `rafaellbatistadev@outlook.com.br`
3. Discuta em Discussions

---

## 📄 Anexo: Termos Definidos

| Termo | Definição |
|-------|-----------|
| **PII** | Informação Pessoalmente Identificável |
| **Dados Sensíveis** | Informações confidenciais (API keys, senhas) |
| **Telemetria** | Coleta automática de dados de uso |
| **Criptografia** | Proteção matemática de dados |
| **Credentials Store** | Armazenamento seguro do JetBrains IDE |
| **GDPR** | Lei de privacidade da UE |
| **CCPA** | Lei de privacidade da Califórnia |
| **LGPD** | Lei de privacidade do Brasil |

---

## ⚖️ Isenção de Responsabilidade

### Limitações

- Esta política reflete práticas atuais
- Provedores de IA têm suas próprias políticas
- Segurança depende também de você
- Não garantimos 100% de privacidade

### Terceiros

Não somos responsáveis por:
- Políticas de Google, OpenAI, Anthropic
- Segurança do seu computador
- Proteção de suas API Keys
- Conformidade legal de terceiros

---

<div align="center">

## 🤝 Confiança e Transparência

Privacidade é direito fundamental.  
Estamos comprometidos em protê-la.

**Suas dúvidas? Entre em contato.**

---

**Versão:** 1.0  
**Data:** 8 de Abril de 2026  
**Próxima Revisão:** 8 de Outubro de 2026  
**Mantainer:** Rafael Batista  
**Email:** rafaellbatistadev@outlook.com.br

</div>
