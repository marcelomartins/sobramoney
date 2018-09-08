<template>
<v-app>
 <v-layout row>
    <v-flex xs12 sm6 offset-sm3>
      <v-card>
        <v-toolbar color="indigo" dark style="margin-top: 10px;">
          <v-btn icon to="/">
            <v-icon>money</v-icon>
          </v-btn>
          <v-toolbar-title>Contas do Mês</v-toolbar-title>
          <v-spacer></v-spacer>

          <v-text-field single-line hide-details label="Filtrar"></v-text-field>

          <v-btn icon to="/edita">
            <v-icon>add</v-icon>
          </v-btn>
        </v-toolbar>

        <v-content>
              <router-view/>
        </v-content>

      </v-card>
    </v-flex>
  </v-layout>
</v-app>
</template>

<script>
import ListaRegistros from './components/ListaRegistros'

export default {
  name: 'App',
  components: {
    ListaRegistros
  },
  data () {
    return {
    }
  }
}
</script>

<style>
</style>
