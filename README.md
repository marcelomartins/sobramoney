# sobramoney

## Instação do Vue
* cd vue-app
* yarn global add @vue/cli
* yarn global add @vue/cli-service-global
* npm install

## Desenvolvimento
* cd vue-app
* yarn build --dest='../src/main/webapp/' --mode='development' --watch
* Em outra janela: grails run-app


## Teste
* yarn build --dest='../src/main/webapp/' (no diretório vue-app)
* grails run-app


## Gerar Pacote
* yarn build --dest='../src/main/webapp/' (no diretório vue-app)
* grails war
