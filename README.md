# Pratica07-TDD

Bernardo Nunes Gomes
Kauã Kellysson
Lucas Medeiros
Alvaro Vasconcelos

## Parte FaturaCliente

Esta branch entrega somente `FaturaCliente` e `FaturaClienteTest`.
`Cliente` e `ContaCliente` ficam para os demais integrantes.

- Java 8, Maven e JUnit 5.
- Classes sem declaração de `package`, em `src/main/java`.
- Testes em `src/test/java`.
- Histórico com commits `RED:`, `GREEN:` e `REFACTOR:`.

### Integração com Cliente

A classe `Cliente` ainda precisa ser adicionada pelo grupo em
`src/main/java/Cliente.java`, com os métodos do diagrama. Os testes de fatura
usam `Cliente(int, String, int)`, `getDesconto()`, `setDesconto(int)` e
`toString()` no formato `Nome(id)(desconto%)`.

Depois da integração, executar:

```sh
mvn clean test
```

Antes de integrar `Cliente`, o projeto desta branch não compila sozinho.
A verificação isolada de `FaturaCliente` passou em Java 8 com 23 execuções de
teste e zero falhas, usando uma classe Cliente temporária apenas no ambiente
local. Essa classe de apoio não foi incluída na entrega; os testes devem ser
reexecutados com a implementação real do grupo antes do merge.

### Comportamentos definidos para FaturaCliente

- O construtor somente com id inicia com cliente nulo e valor zero.
- O construtor completo e `setCliente` rejeitam cliente nulo.
- `setValor` e o construtor completo rejeitam valor negativo, NaN e infinito.
- Sem cliente, `getValorComDesconto` lança `IllegalStateException`.
- O cálculo consulta o desconto atual, sem alterar o valor original e sem
  arredondar. A validação da faixa de desconto pertence a `Cliente`.
- `toString` segue o formato do diagrama e permite exibir uma fatura ainda
  sem cliente, mostrando `cliente=null`.

O enunciado não detalha esses casos de erro; essas convenções estão cobertas
pelos testes e podem ser alinhadas pelo grupo na revisão.

O Pull Request deve ser revisado por outro integrante antes de entrar na main.
