# Calculadora API

Projeto de portfólio desenvolvido em **Java + Spring Boot**, com foco em consolidar boas práticas
de organização de código, injeção de dependências e design de APIs REST, enquanto aprendo os
conceitos na prática.

> Este projeto é independente da API de Média de Alunos (outro repositório) — cada uma representa
> uma etapa de aprendizado separada.

## Stack

- Java 17
- Spring Boot (Web / MVC)
- Maven (com Maven Wrapper)

## Organização do projeto

O projeto segue o critério de **organização por funcionalidade (package by feature)**, e não por
camada técnica. Isso significa que cada domínio (`calculo`, `tabuada`, `triarea`...) é
autocontido: agrupa seu próprio controller, service e DTOs, em vez de espalhar as classes em
pastas genéricas como `controller/`, `service/`, `dto/` na raiz.

```
com.andrey.calculadora
├── calculo
│   ├── dtos
│   │   ├── CalculoRequest
│   │   └── CalculoResponse
│   ├── enums
│   │   └── Operacao
│   ├── CalculoController
│   └── CalculoService
├── tabuada
│   ├── dtos
│   │   ├── TabuadaRequest
│   │   └── TabuadaResponse
│   ├── TabuadaController
│   └── TabuadaService
└── CalculadoraApplication
```

**Por que esse critério?** Conforme o número de funcionalidades cresce, fica mais fácil localizar
tudo que envolve uma regra de negócio específica, em vez de caçar arquivos relacionados espalhados
por pastas técnicas. É o padrão adotado na maioria dos projetos Spring de médio/grande porte.

> **Nota de evolução:** caso mais de um domínio passe a depender do mesmo enum/classe (por
> exemplo, se `Operacao` for usado tanto por `calculo` quanto por `tabuada`), esse código deve
> ser extraído para um pacote `common`/`shared` na raiz, para não acoplar um domínio a outro.

## Endpoints

### Calculo

`POST /calculo`

Executa uma operação matemática (soma, subtração, multiplicação ou divisão) entre dois valores.

**Request**
```json
{
  "valor1": 10.0,
  "valor2": 2.0,
  "operacao": "MULTIPLICAR"
}
```

**Response**
```json
{
  "resultado": 20.0
}
```

`operacao` aceita os valores do enum `Operacao`: `SOMAR`, `SUBTRAIR`, `MULTIPLICAR`, `DIVIDIR`.

### Tabuada

`POST /tabuada`

Retorna a tabuada de multiplicação de um número.

**Request**
```json
{
  "numero": 7
}
```

**Response**
```json
{
  "numero": 7,
  "resultados": [7, 14, 21, 28, 35, 42, 49, 56, 63, 70]
}
```

> Ajuste os campos acima caso o formato real do seu `TabuadaRequest`/`TabuadaResponse` seja
> diferente — descreva aqui exatamente os nomes usados no código.

## Como rodar

```bash
./mvnw spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.

## Decisões e aprendizados registrados

- **Injeção de dependências:** todo `Service` precisa da anotação `@Service` para ser registrado
  como bean no contexto do Spring; sem ela, a injeção via construtor no `Controller` falha com
  erro de "no qualifying bean".
- **Separação de responsabilidades:** a lógica de cálculo pura (retorna `double`) é mantida
  separada da montagem do DTO de resposta, permitindo reaproveitar a operação matemática em mais
  de um endpoint (ex: `TriArea` reaproveitando `CalculoService`).
- **Consistência de critério de pacotes:** optou-se por manter *um único* critério de organização
  (por funcionalidade) em todo o projeto, evitando misturar com organização por camada técnica.

## Em andamento

- `TriArea` (cálculo de área de triângulo, reaproveitando `CalculoService`) — em desenvolvimento.
