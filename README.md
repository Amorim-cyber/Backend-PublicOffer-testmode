# Backend-PublicOffer-testmode :left_luggage:

### Início

<hr>

Fala pessoal, esse é o início da elaboração de um sistema que irá gerenciar ordens de ofertas públicas de ativos financeiros.

A oferta pública é basicamente uma proposta de negócio, e existem vários tipos. Contudo não vou me estender a tecnicalidades, aqui neste projeto irei falar apenas da mais conhecida: o IPO.

Sendo bem breve IPO (*Initial Public Offering*)  é um tipo de oferta pública na qual as ações de uma empresa geralmente são vendidas a investidores institucionais, os quais, por sua vez, vendem essas ações ao público em geral, em bolsa de valores pela primeira vez.

Portanto, a motivação desse projeto é criar um controle de reservas para IPOs.

### Modelo de negócios

<hr>

Aqui no nosso projeto vamos entrar na pele de uma instituição financeira que comprou as ações de uma empresa fictícia chamada *Grupo XPTO Logística*. Ela irá fazer a sua oferta pública para o mercado.

Vamos supor que nossa instituição domine esse mercado.

Beleza, vamos simplificar ainda mais: Vamos supor também que nossa instituição tenha apenas três funcionários, o agente A do código 11111, o agente B do código 22222 e o executor de ordens C. 

A e B são responsáveis por assessorar financeiramente todos clientes enquanto o C fica responsável pelo operacional.

Caso algum cliente tenha interesse de participar desse IPO de Grupo XPTO, ele deve notificar A ou B, estes por sua vez irão mandar um pedido para C fazer a reserva. 

Ao efetuar a reserva, C notifica A ou B, que por sua vez avisa o cliente.

Este será o modelo que vamos tentar aplicar no projeto.

### TECHS UTILIZADAS

<hr>

* Java 8
* Spring
* IDE IntelliJ (ou outra opção se preferir)
* heroku para cloud (https://public-offer-back-test.herokuapp.com/)

### INSTRUÇÕES

<hr>

Para rodar o projeto localmente em sua maquina siga os seguintes passos:

1. Baixe os arquivos deste repositório

2. Utilize o intelliJ para abrir o diretório que contém os arquivos baixados

3. Inicie o servidor. Em caso de dúvida siga os seguintes subpassos:

   * Abra o arquivo OfertaBackApplication
   * Clique na seta verde indicada pelo circulo vermelho

   <img src="img\passo1.png" style="border: solid grey; border-radius:4px"></img>

4. Para realizar os teste dos comandos HTTP utilizei a documentação do Swagger, para acessa-la digite `http://localhost:8082/swagger-ui.html` no seu navegador. **IMPORTANTE: A página só irá funcionar quando o servidor estiver de pé. **

#### PRONTO

A página está pronta para uso.

<img src="img\fim.PNG" style="border: solid grey; border-radius:4px"></img>

#### OBS:

Você também pode testar a aplicação trocando o endereço local pelo endereço do servidor cloud digitando `https://public-offer-back-test.herokuapp.com/swagger-ui.html` no seu navegador.

Acessando `http://localhost:8082/h2-console` você pode acessar a database da aplicação. É necessário a JDBC URL para logar apenas. Essa informação é dada no log de inicialização. 

<img src="img\log.PNG" style="border: solid grey; border-radius:4px"></img>

#### EXEMPLO DE DADOS PARA TESTES

Vou deixar aqui os exemplos que utilizei no desenvolvimento.

```shell script
[
  {
    "id": 1,
    "agentId": 11111,
    "clientId": 30,
    "assetName": "IPO 1",
    "assetPrice": "R$ 30,00",
    "amount": "R$ 100,00",
    "status": "Feito",
    "description": null
  },
  {
    "id": 2,
    "agentId": 22222,
    "clientId": 34,
    "assetName": "IPO 2",
    "assetPrice": "R$ 40,00",
    "amount": "R$ 100,00",
    "status": "Feito",
    "description": null
  },
  {
    "id": 3,
    "agentId": 22222,
    "clientId": 341,
    "assetName": "IPO 1",
    "assetPrice": "R$ 40,00",
    "amount": "R$ 100,00",
    "status": "Feito",
    "description": null
  },
  {
    "id": 4,
    "agentId": 11111,
    "clientId": 76,
    "assetName": "IPO 1",
    "assetPrice": "R$ 40,00",
    "amount": "R$ 500,00",
    "status": null,
    "description": null
  }
]
```

### TRILHA

<hr>

Vou deixar aqui notas com mais detalhes de cada commit do projeto.

<div style="background-color: #E8E8E8; border-radius: 3px;">
   <p><strong>PRIMEIRO COMMIT</strong></p>
    <ul>
        <li><strong>PARTE 1:</strong> Criando o projeto no spring boot, foi posto um getMapping para teste de serviço e criação da entidade principal do projeto. Subindo o projeto para o heroku</li>
    </ul>
    <br>
</div>
<div style="background-color: #E8E8E8; border-radius: 3px;">
   <p><strong>CRIANDO UM METODO POST</strong></p>
    <ul>
        <li><strong>PARTE 2:</strong> Criamos um método POST em nosso controller, também foi criado um service e repositório para a entidade Request</li>
    </ul>
    <br>
</div>
<div style="background-color: #E8E8E8; border-radius: 3px;">
   <p><strong>APRIMORANDO O METODO POST</strong></p>
    <ul>
        <li><strong>PARTE 3:</strong> Criamos uma classe DTO para nossa entidade Request, adicionamos nas dependências o conversor mapstruct</li>
    </ul>
    <br>
</div>

<div style="background-color: #E8E8E8; border-radius: 3px;">
   <p><strong>CRIANDO UM METODO GET</strong></p>
    <ul>
        <li><strong>PARTE 4:</strong> Editamos os arquivos de controller e service para receber o metodo listAll que retorna o registro de todas as requests</li>
    </ul>
    <br>
</div>

<div style="background-color: #E8E8E8; border-radius: 3px;">
   <p><strong>ADICIONANDO OUTROS METODOS GET</strong></p>
    <ul>
        <li><strong>PARTE 5:</strong> Editamos os arquivos de controller, service e repository para receber o metodo findAllByAgentId que filtra os requests por id de agente e o metodo findAllByClientId que filtra os requests por id de cliente</li>
    </ul>
    <br>
</div>

<div style="background-color: #E8E8E8; border-radius: 3px;">
   <p><strong>CRIANDO UM METODO DELETE</strong></p>
    <ul>
        <li><strong>PARTE 6:</strong> Editamos os arquivos de controller e service para receber o metodo delete, que deleta um determinado request</li>
    </ul>
    <br>
</div>

<div style="background-color: #E8E8E8; border-radius: 3px;">
   <p><strong>CRIANDO UM METODO PUT</strong></p>
    <ul>
        <li><strong>PARTE 7:</strong> Editamos os arquivos de controller e service para receber o metodo updateById, que altualiza os dados de um determinado request</li>
    </ul>
    <br>
</div>

FIM DA TRILHA

### Forte abraço! :smile:

