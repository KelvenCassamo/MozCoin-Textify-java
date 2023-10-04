# MozCoin Textify (Java)

A **MozCoin Textify Java** é uma alternativa em Java para a versão inicial da biblioteca em JavaScript, que permite converter valores numéricos em palavras no mesmo contexto da moeda moçambicana. Esta biblioteca é útil para gerar recibos, facturas ou qualquer aplicação que necessita de uma representação por extenso dos valores numericos.  

Diferentemente da versão JavaScript, a versão Java não depende de um arquivo de configuração `config.json`. Em vez disso, foi incluída uma classe `Config.java` na qual as configurações são armazenadas no momento da instanciação da classe `MozCoinTextify`. Isso irá ornar mais simples o processo de uso da biblioteca em Java, sem a necessidade de um arquivo de configuração separado.

## Uso da Biblioteca MozCoin Textify (em Java)
Para utilizar o **MozCoin Textify** em java, pode seguir as etapas abaixo:

### 1. Importar a Biblioteca

Primeiro devemos incluir a biblioteca MozCoin Textify.
````java
import mz.mozcoin.textify.*;
import mz.mozcoin.textify.interfaces.MozCoinTextifyInterface;
`````
### 2. Criar uma Instância da Classe MozCoinTextify

````java
MozCoinTextify mozCoinTextify = new MozCoinTextify();
````
Também pode configurar as opções adicionais na hora de criar a instância, como por exemplodefinir o idioma padrão:

````java
MozCoinTextify mozCoinTextify = new MozCoinTextify(new Config(), MozCoinTextify.PORTUGUESE);
//ou
Config config = new Config();

MozCoinTextify mozCoinTextify = new MozCoinTextify(config, MozCoinTextify.PORTUGUESE);

````
### 3. Configurar um listener para receber os Resultados
Na versão do JavaScript utilizamos o `Promise` para lidar com os resultados. Em java utilizaremos a interface `MozCoinTextifyInterface` que será praticamene o nosso ouvinte que nos ajudará a lidar com os resultados.

````java
mozCoinTextify.createListener(new MozCoinTextifyInterface() {
    @Override
    public void onSuccess(String valor) {
        System.out.println(valor);
    }

    @Override
    public void onError(String error, String valor) {
        System.err.println(error);
    }
});
````
A interface `MozCoinTextifyInterface` nos fornece dois métodos abstratos, o `onSuccess` e o `onError`.

### 4. Converter o Valor

A classe `MozCoinTextify` possui um método `converter(String valor)` que processará o valor de uma String numerica(válida) e depois chama a função onSuccess com o resultado da conversão ou onError em caso de problemas. Vejamos no exemplo abaixo:

`````java
String valor = "3,401.10";

mozCoinTextify.convert(valor);

``````
ou sem o separador de milhares
`````java
String valor = "3401.10";

mozCoinTextify.convert(valor);

``````

O método acima terá como saída `Três mil e quatrocentos e um meticais e dez centavos.`


### 5. Configurar Opções Adicionais (é opcional)

Ao inicializar a classe `MozCoinTextify`, automaticamente será criada uma instância da classe `Config` que será armazenada em um objecto `config`.
Podemos manipular da seguinte forma:

````java
mozCoinTextify.config.setAutoDot(true);
mozCoinTextify.config.setDefaultLanguage(MozCoinTextify.PORTUGUESE);

````
Também será válido:

````java
Config config = new Config();
config.setAutoDot(true);
config.setDefaultLanguage(MozCoinTextify.PORTUGUESE);
mozCoinTextify.applyConfig(config);
````
Lembre-se de que existem vários métodos na classe `Config`. Abaixo listarei alguns:

````java
config.setCurrencySymbol("MT");
config.setDecimalSeparator(".");
//Tambem será valido o separador "," 
config.setDecimalSeparator(",");

config.setUnit("Metical");
config.setSubunit("Centavo");

config.setAutoDot(true); // para adicionar um ponto no final da representação
config.setAutoDot(false); // Impede que seja adicionado um ponto no final da representação
````

### 4. Obter Valores de Configuração

Embora não haja a necessidade de usar, podemos obter os valores das configurações a qualquer momento, basta chamar os métodos getters. Por exemplo:
````java

String decimalSeparator = config.getDecimalSeparator();
String unit = config.getUnit();
String subunit = config.getSubunit();
````

ou

````java

String decimalSeparator = mozCoinTextify.config.getDecimalSeparator();
String unit = mozCoinTextify.config.getUnit();
String subunit = mozCoinTextify.config.getSubunit();
````



## Uma curta explicação sobre a classe Palavras
A classe `Palavras` contém uma matriz bidimensional que armazena as palavras que serão representadas por extenso. 
Essas palavras são usadas pela classe `MozCoinTextify` no processo da conversão.



## Contactos

Para qualquer dúvida pessoal ou caso queira conhecer-me, sinta-se à vontade para entrar em contato:

-   **Nome:** Kelven Cassamo Sulemane
-   **E-mail:** kelvencassamo9@gmail.com
-   **Chamadas:** (+258) 878920441
-   **Whatsapp:** [(+258) 844920441](https://api.whatsapp.com/send?phone=+258844920441)
-   **Link para o chat do Whatsapp:** https://api.whatsapp.com/send?phone=+258844920441
-   **GitHub:** https://github.com/KelvenCassamo




## Atualizações e Licença

A `MozCoin Textify` está em constante desenvolvimento para melhorar a precisão e adicionar novos recursos. Fique atento para futuras atualizações!

## Licença
Este projeto está licenciado sob a Licença MIT - pode consultar o arquivo [LICENSE.md](https://github.com/KelvenCassamo/MozCoin-Textify-java/blob/main/LICENSE) para detalhes.

Pode sentir-sw à vontade para contribuir, reportar problemas ou dar sugestões para melhorar o projeto!

