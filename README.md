# <a href="https://imgbb.com/"><img src="https://i.ibb.co/wNCRx9z/image-2025-01-04-T23-13-02-901-Z.png" alt="image-2025-01-04-T23-13-02-901-Z" border="0" width =150 heigth = 100></a> Desenvolva + : E-commerce

#### Desenvolvido na linguagem Java por:
- [Alan Cleber](https://github.com/superalanjoe)
- [Aline Wornath](https://github.com/AlineWornath)
- [Marcos Shirafuchi](https://github.com/marcosfshirafuchi)

## Principais Tecnologias

- <img width="70px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original-wordmark.svg" title = "Java" /> <b>Java 21 :</b> Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
- <img width="70px" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" title = "IntelliJIDEA" /> <b>IntelliJIDEA :</b> Utilizei o IntelliJIDEA como a IDEA para fazer os programas em Java;



## Ada Commerce - E-Commerce 

### A Ada tech pretendo realizar a venda de produtos através de um E-Commerce e, para isso, nos contratou com a finalidade de desenvolvermos todo o fluxo necessário. Nesse E-Commerce temos algumas necessidades que serão descritas abaixo.
- Cadastrar, listar, atualizar os clientes da base. Não é necessário a ação de excluir clientes, pois esses devem permanecer na base como histórico.
- Cadastrar, listar, atualizar os produtos da base. Não é necessário a ação de excluir produtos, pois esses devem permanecer na base como histórico.
- Criar uma venda para um cliente. Nessa venda deve ser possível: Adicionar item (produto) com quantidade e preço, remover item (produto), alterar quantidade do item (produto), realizar o pagamento e a entrega.

### Regras importantes que foram levantadas junto ao nosso cliente.
- Todo cliente cadastrado precisa ter o documento de identificação.
- Um pedido sempre deve ter a data em que foi criado.
- Um pedido sempre deve iniciar com o status igual a aberto.
- Pedidos com status igual a aberto podem receber itens (produto), alterar quantidade e remover item.
- Os produtos adicionados ao pedido devem ter um valor de venda informado, pois esse valor pode ser diferente do valor do produto.
- Para que o cliente possa realizar a ação de finalizar o pedido, o pedido deve ter ao menos um item e o valor deve ser maior que zero. Também deve-se alterar o status do pagamento para: "Aguardando pagamento" e notificar o cliente via e-mail.
- A ação de pagar deve acontecer apenas sobre vendas que estejam com o status igual a "Aguardando pagamento" e, após o pagamento acontecer com sucesso, deve-se alterar o status do pagamento para "Pago" e, também, notificar o cliente.
- Após o pagamento realizado o pedido pode ser entregue ao cliente e o status alterado para "Finalizado". Não esqueça de notificar o cliente sobre a entrega.  

### Regras importantes que foram levantadas junto ao nosso cliente.
- Lembra-se de utilizar os conceitos aprendidos em sala de aula. Os princípios de orientação a objetos e também de SOLID.
- Nesse momento podemos trabalhar com uma base de dados em memória, afim de simplificar o exercício. Porém, se desejar, faça a persistência em arquivos. Item bônus, não obrigatório.

### Entrega.
- Entregar o link do repositório do projeto no GitHub.

## Diagrama de classes
<p align = center>
<a href="https://ibb.co/27CnYcLh"><img src="https://i.ibb.co/Gv8x3C1p/Diagrama-de-classe-do-E-commerce-vers-o-05.png" alt="Diagrama-de-classe-do-E-commerce-vers-o-05" border="0"></a>
</p>

## Sites que geram CPFs, CNPJs, CEPs e numeros para testar

### Gerador de CPF

https://www.4devs.com.br/gerador_de_cpf

### Gerador de CNPJ

https://www.4devs.com.br/gerador_de_cnpj

### Gerador de CEP

https://geradornv.com.br/gerador-cep/

### Buscar/Validar CEP

https://geradornv.com.br/buscar-validar-cep/

### Validador de número de telefone

https://www.telvalidator.com/?lang=pt

### Gerador de Número de Telefone

https://geradornv.com.br/gerador-telefone/

