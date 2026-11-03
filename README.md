# Prática 07 - TDD e Git

Projeto em Java 8, com Maven e JUnit 5.

## Grupo

- Bernardo Nunes Gomes
- Kauã Kellysson
- Lucas Medeiros
- Alvaro Vasconcelos

## Classes

- `Cliente`: dados do cliente e desconto.
- `FaturaCliente`: valor da fatura e cálculo do desconto.
- `ContaCliente`: saldo, depósito e saque.

Cada classe tem seus testes em `src/test/java`.

## Rodar os testes

Com Java 8 e Maven instalados, rode na pasta do projeto:

```sh
mvn clean test
```

São 69 testes passando com as três classes juntas.

A conta criada só com id começa sem cliente e com saldo zero.
Nesse caso, o `toString()` mostra `Sem cliente(7) saldo=R$0.00`, usando o id da conta.
Se tentar sacar mais que o saldo, aparece um aviso e o saldo não muda.

## Git

As alterações vão em uma branch e entram na main por Pull Request,
com aprovação de outro integrante antes do merge.

Para mudanças de comportamento, primeiro vem o teste (`RED:`), depois
o código (`GREEN:`). Se precisar refatorar, usamos `REFACTOR:`.
