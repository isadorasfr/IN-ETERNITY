# IN ETERNITY

Jogo de batalha por turnos desenvolvido em Java para praticar conceitos de Programação Orientada a Objetos.

## Sobre o projeto

IN ETERNITY é um jogo de batalha por turnos em que o jogador escolhe um personagem e enfrenta um adversário controlado pelo sistema.

O jogador escolhe suas ações durante cada rodada, enquanto o adversário é selecionado e realiza suas ações de forma aleatória.

## Personagens

O jogo possui três personagens:

- **Elesis** — Guerreiro
- **Arme** — Mago
- **Lire** — Arqueiro

Cada personagem possui um atributo próprio que influencia o dano de seus ataques e habilidades:

- **Guerreiro:** força
- **Mago:** inteligência
- **Arqueiro:** agilidade

## Como funciona

1. O jogador escolhe um personagem.
2. O sistema sorteia um adversário diferente do personagem escolhido.
3. A batalha começa com os dois personagens em 100 HP.
4. O jogador escolhe uma ação a cada rodada.
5. O adversário realiza uma ação aleatória.
6. A batalha continua até que um dos personagens fique com 0 HP.
7. O sistema informa o vencedor.

## Ações

O jogador possui três opções durante seu turno:

- **Ataque** — realiza o ataque normal do personagem.
- **Habilidade especial** — realiza um ataque com dano diferente do ataque normal.
- **Defender** — reduz pela metade o dano recebido no próximo ataque.

Após bloquear um ataque, a defesa é desativada.

O adversário também pode realizar as três ações, escolhidas aleatoriamente pelo sistema.

## Ataques e habilidades

### Elesis — Guerreiro

- **Ataque:** Lâmina Circular
- **Habilidade:** Onda Flamejante

### Arme — Mago

- **Ataque:** Bola de Fogo
- **Habilidade:** Prisão de Gelo

### Lire — Arqueiro

- **Ataque:** Flecha Tóxica
- **Habilidade:** Tempestade de Flechas

## Tecnologias

- Java
- `ArrayList`
- `Random`
- `Scanner`
- Visual Studio Code

## Conceitos praticados

- Programação Orientada a Objetos
- Encapsulamento
- Herança
- Abstração
- Polimorfismo
- Classes e métodos abstratos
- Sobrescrita de métodos (`@Override`)
- Tratamento de exceções (`try/catch`)

## Estrutura do projeto

```text
src/

├── batalha/
│   └── Batalha.java
│
├── personagens/
│   ├── Arqueiro.java
│   ├── Guerreiro.java
│   ├── Mago.java
│   └── Personagem.java
│
└── Main.java
```

## Como executar

1. Clone o repositório.
2. Abra o projeto em uma IDE ou editor com suporte a Java.
3. Execute a classe `Main`.
4. Escolha seu personagem pelo terminal.
5. Siga as instruções exibidas durante a batalha.

## Desenvolvido por

**Isadora Silva**