# quarkus--estudo-serverless
Projeto destinado ao estudo do Quarkus para execução em ferramentas serverless, como AWS Lambda e Knative, será desenvolvido a implementação para as duas ferramentas.

## Pré-requisitos
- Java 17
- Gradle 8.2.1
- Docker
- AWS SAM CLI


## Execução

### AWS Lambda
Para o lambda, será utilizado a biblioteca `quarkus-aws-lambda`, onde será criado um Handler para a função lambda.

#### Execução local

##### Configuração do banco de dados em Docker
Para execução local, deve ser criado um container com o banco de dados MySQL, para isso, deve ser executado o comando abaixo na pasta `./mysql docker`:
```shell
docker-compose up
```
com isso será criado um usuário de acesso para a aplicação.

##### AWS SAM CLI

Para execução local, deve primeiro realizar o build com o comando abaixo:
```shell
gradle clean build
```

Após o build, deve ser alterado o arquivo `sam.jvm.yaml`, que está dentro da pasta `./build/` que foi gerada com o build do projeto, esse ajuste é necessário para utilizar o Java 17 com o Lambda, conforme o exemplo abaixo:

```yaml
# ...configurações omitidas
Resources:
  QuarkusServerlessResetSenha:
    Type: AWS::Serverless::Function
    Properties:
      Handler: io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler::handleRequest
      Runtime: java11 # alterar para o valor java17
      CodeUri: function.zip
      MemorySize: 256
      Timeout: 15
      Policies: AWSLambdaBasicExecutionRole
```

Após a alteração, com o AWS SAM CLI, deve executar o comando abaixo para realizar o deploy da função lambda:
```shell
 sam local invoke --docker-network mysql-network --template build/sam.jvm.yaml --event src/main/resources/payload.json
```


## Referências
- [Quarkus AWS Lambda](https://quarkus.io/guides/amazon-lambda)
- [Docker](https://docs.docker.com/engine/install/)
- [AWS SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html)