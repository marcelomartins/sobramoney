<template>

    <v-list>

      <template v-for="(item) in registros">


        <v-list-tile :key="item.id" avatar>
          <v-list-tile-action>
            <v-btn icon  @click="item.soma = !item.soma">
              <v-icon v-if="item.soma" color="grey">
                  done
              </v-icon>
            </v-btn>
          </v-list-tile-action>

          <v-list-tile-action>
            {{item.dia }}
          </v-list-tile-action>
        
          <v-list-tile-content>
            <v-list-tile-title>{{ item.descricao }}</v-list-tile-title>
          </v-list-tile-content>

          <v-list-tile-action>{{item.valor | currencydecimal }}</v-list-tile-action>

          <v-list-tile-action>
            <v-btn icon  @click="item.pago = !item.pago">
              <v-icon v-if="item.pago" color="green darken-2">
                  attach_money
              </v-icon>
              <v-icon v-else color="grey lighten-1">
                  money_off
              </v-icon>
            </v-btn>
          </v-list-tile-action>
        </v-list-tile>
      </template>



      <v-list-tile avatar>
        <v-list-tile-action>&nbsp;</v-list-tile-action>
        <v-list-tile-action>&nbsp;</v-list-tile-action>
        <v-list-tile-content>
          <v-list-tile-title style="font-weight: bold">Total:</v-list-tile-title>
        </v-list-tile-content>
        <v-list-tile-action>{{ somaTotal | currencydecimal  }}</v-list-tile-action>
        <v-list-tile-action>&nbsp;</v-list-tile-action>
      </v-list-tile>


      <v-list-tile avatar>
        <v-list-tile-action>&nbsp;</v-list-tile-action>
        <v-list-tile-action>&nbsp;</v-list-tile-action>
        <v-list-tile-content>
          <v-list-tile-title style="font-weight: bold">Total a pagar:</v-list-tile-title>
        </v-list-tile-content>
        <v-list-tile-action>{{ somaTotalAPagar | currencydecimal  }}</v-list-tile-action>
        <v-list-tile-action>&nbsp;</v-list-tile-action>
      </v-list-tile>



    </v-list>

</template>

<script>
import axios from "axios";

export default {
  name: 'ListaRegistros',
  data() {
    return {
      registros: []
    };
  },
  computed: {
    somaTotal: function () {
      return this.registros.reduce( function( sum, registro ) {
          if (registro.soma) {
            return sum + registro.valor;
          }
          return sum;
        }, 0 );
    },
    somaTotalAPagar: function() {
      return this.registros.reduce( function( sum, registro ) {
          if (!registro.pago) {
            return sum + registro.valor;
          }
          return sum;
        }, 0 );

    }
  },
  mounted() {
    axios
      .get("/registros.json")
      .then(response => {
        console.log(response.data); /* eslint-disable-line no-console */
        this.registros = response.data;
      })
      .catch(error => {
        console.log(error); /* eslint-disable-line no-console */
        this.errored = true;
      })
      .finally(() => (this.loading = false));
  }, 
  filters: {
    currencydecimal (value) {
      return value.toLocaleString('pt-BR', {minimumFractionDigits: 2});
    }
  },
  methods: {
  
  }
}
</script>

<style scoped>

</style>