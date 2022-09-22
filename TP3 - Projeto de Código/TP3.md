# TP3 - Projeto de Código

Victor Rodrigues Silva - 16/0019516
Francisco Heronildo - 16/0006210

## Simplicidade

### Descrição

A simplicidade de código é a característica mais importante no desenvolvimento de software, um conceito chave dessa caracteristica é descrita no livro como "Simplicidade é uma virtude. Nunca escreva códigos mais complexos que o necessário".

A simplicidade de código é altamente importante no desenvolvimento de software, pois escrevendo de maneira simples, aquele código consegue comunicar melhor para o programador qual o propósito daquele código, facilitando assim a futura manutenção daquele sistema.

Um código simples é mais fácil de ler, compreender, escrever e ainda se torna mais coerente e consistente.

### Maus-cheiros

- Classes grandes
- Métodos longos
- longa lista de parâmetros

## Elegância

### Descrição

A elegância se relaciona com os aspectos estéticos do design de código e quase sempre relacionada com a simplicidade. e facilidade de leitura daquele código.

### Maus-cheiros

- Cirurgia com rifle
- classe preguiçosa

## Modularidade

### Descrição

O desenvolvimento de software como é conhecido hoje só existe graças a modularização de código. A decomposição do código em "pedaços", ou seja, em módulos menores tenta garantir a simplificação, facilitar o debbuging, testes e principalmente facilitar a reutilização de código. Algumas das características mais importantes da modularidade são o baixo acoplamento e a alta coesão.

O baixo acoplamento garante maior idependencia entre os módulos, enquanto a alta coesão garante que as funcionalidade estejam bem relacionadas entre si.

### Maus-cheiros

- Hierarquias de heranças paralelas
- Instruções switch
- Generalização expeculativa

## Extensibilidade

### Descrição

Um projeto de código bem realizado permite que funcionalidades novas sejam inseridas em locais adequados quando necessário, ou seja, quando necessário o código pode ser extendido ao adicionar modificações.

### Maus-cheiros

- Generalização expeculativa
- Hierarquias de herança paralelas
- Classes alternativas com interfaces diferentes

## Ausência de duplicidades

### Descrição

Um software bem desenvolvido não possui duplicidade em seu código. A duplicidade é o inimigo da elegância e da simplicidade.

### Maus-cheiros

- Código duplicado
- Extração de métodos

## Boa documentação

### Descrição

Um projeto de código bem documentado é fundamental para legibilidade do código, inferindo também na simplicidade e elegância do código. O leitor do código nunca deve ter que "adivinhar" o que certo trecho de código faz.

O código em si é a maneira mais completa e correta de descrever seu código, mas, isso não significa que ele possui a melhor descrição possível do que ele faz, por isso que a boa documentação, como por exemplo comentário de código são importantes, por que muitas das vezes, aquelas é a única documentação que o desenvolvedor terá acesso em uma manutenção.

O código auto documentado é altamente recomendado em um bom projeto de software, pois ele diminui a dependencia de documentação externa.

Mas além do código auto documentado, os documentos externos também tem um papel importantissimo no desenvolvimento de software, mas nem toda informação sobre o projeto pode ser armazenado no código, como exemplo manuais técnicos, diagramas e etc.

### Maus-cheiros

Uma boa documentação pode ajudar a reduzir o número de maus-cheiros de diversas maneiras como em casos com:

- Códigos duplicados
- Cadeias de mensagens
- Comentários extensos
- Campos temporários
- Longas listas de parâmetros
