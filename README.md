# Hackathon Agibank
Sistema de Gestão de Equipamentos

Sistema corporativo para gestão de equipamentos, focado em rastrear a movimentação de bens entre colaboradores, garantir a devolução no desligamento e manter a integridade do inventário de ativos da empresa.

📋 Funcionalidades
Cadastro de Funcionários: Inclusão, edição e listagem de colaboradores com status ativo/em desligamento/desligado.

Cadastro de Equipamentos: Registro de equipamentos com tipo, modelo, SKU e status (disponível/alocado/manutenção/desativado).

Movimentação de Equipamentos: Controle de empréstimos, devoluções e histórico de movimentações por funcionário.

Desligamento de Funcionários: Processo de verificação de pendências de equipamentos.

Relatórios:

Equipamentos em posse de colaboradores.

Funcionários com pendências na devolução de equipamentos.

🛠️ Tecnologias Utilizadas
```text
Java 21

Spring Boot 3

MongoDB (Persistência de dados)

Gradle (Gerenciamento de dependências)

Lombok (Para redução de boilerplate no Java)

Postman (Para testes de API)
```

🧩 Estrutura do Projeto
```text
com.agibank.hackathon.ems
├── controller     # Controllers REST para APIs de Funcionário, Equipamento, Movimentação e Desligamento
├── entity         # Entidades: Funcionario, Equipamento, Movimentacao, Desligamento
├── service        # Lógicas de negócio
├── repository     # Repositórios de acesso ao MongoDB
├── exceptions     # Classes de exceções customizadas
└── mapper         # Conversão entre entidades e requests/responses
```

