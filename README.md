# Backend-PublicOffer-testmode :left_luggage:

#### Inicio

Fala pessoal, esse é o início da elaboração de um sistema que irá gerenciar ordens de ofertas públicas de ativos financeiros.

A oferta pública é basicamente uma proposta de negócio, e existem vários tipos. Contudo não vou me extender a tecnicalidades, aqui neste projeto irei falar apenas da mais conhecida: o IPO.

Sendo bem breve IPO (*Initial Public Offering*)  é um tipo de oferta pública na qual as ações de uma empresa geralmente são vendidas a investidores institucionais, os quais, por sua vez, vendem essas ações ao público em geral, em bolsa de valores pela primeira vez.

Portanto, a motivação desse projeto é criar um controle de reservas para IPOs.

#### Modelo de negócios

Aqui no nosso projeto vamos entrar na pele de uma institução financeira que comprou as ações de uma empresa fictícia chamada *Grupo XPTO Logistica*. Ela irá fazer a sua oferta pública para o mercado.

Vamos supor que nossa instituição domine esse mercado.

Beleza, vamos simplificar ainda mais: Vamos supor também que nossa instituição tenha apenas três funcionários, o agente A do código 11111, o agente B do código 22222 e o executador de ordens C. 

A e B são responsáveis por assessorar financeiramente todos clientes enquanto o C fica responsável pelo operacional.

Caso algum cliente tenha interesse de participar desse IPO de Grupo XPTO, ele deve notificar A ou B, estes por sua vez irão mandar um pedido para C fazer a reserva. 

Ao efetuar a reserva, C notifica A ou B, que por sua vez avisa o cliente.

Este será o modelo que vamos tentar aplicar no projeto.

#### INSTRUÇÕES

**Link heroku:** https://public-offer-back-test.herokuapp.com/ 

#### TECHS UTILIZADAS

* Java 8
* Spring
* IDE IntelliJ (ou outra opção se preferir)
* heroku para cloud

#### TRILHA

Vai ser aqui que vou contar com mais detalhes os commits do projeto.

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

