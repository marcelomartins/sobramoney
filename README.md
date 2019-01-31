# sobramoney

## Desenvolvimento
* cd vue-app
* npm install
* yarn build --dest='../src/main/webapp/' --mode='development' --watch
* Em outra janela: ./gradlew run


## Teste
* npm install
* yarn build --dest='../src/main/webapp/' (no diretório vue-app)
* ./gradlew run


## Gerar Pacote
* npm install
* yarn build --dest='../src/main/webapp/' (no diretório vue-app)
* ./gradlew war
