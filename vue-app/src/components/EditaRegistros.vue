<template>
<v-container>
  <v-form ref="form">
        <v-text-field v-model="registro.descricao" label="Descricao" required></v-text-field>
        <v-text-field v-model.number="registro.valor" label="Valor" required></v-text-field>
        <!-- v-text-field v-model="registro.dataInicial" label="Data" required></v-text-field-->
      <v-menu :close-on-content-click="false"
              v-model="menu1"
              :nudge-right="40"
              lazy
              transition="scale-transition"
              offset-y
              full-width
              max-width="290px"
              min-width="290px">

          <v-text-field label="Data" slot="activator"
                          v-model="registro.dataInicial"
                          persistent-hint
                          readonly></v-text-field>

          <v-date-picker v-model="date" no-title @input="menu1 = false" locale="pt-BR"></v-date-picker>
      </v-menu>

      <v-btn @click="submit">Salvar</v-btn>
    <v-btn @click="clear">Limpar</v-btn>
  
  </v-form>

</v-container>
</template>

<script>
import axios from "axios";
//import router from 'vue-router'


export default {
  name: 'EditaRegistros',
  data() {
    return {
        valid: false,
        menu1: false,
        date: null,
        dataInicial: false,
        registro: {}
    };
  },

   watch: {
    date () {
        this.registro.dataInicial = this.formatDate(this.date)
    }
},


  methods: {
    submit () {
        if (this.$refs.form.validate()) {
            console.log(this.registro); /* eslint-disable-line no-console */

            var router = this.$router;

            axios.post('/registros', this.registro)
                .then(function () {
                    router.push({ path: '/' })
                });


        }
      },
      clear () {
        this.$refs.form.reset()
      },

      formatDate (date) {
          if (!date) return null

          const [year, month, day] = date.split('-')
          return `${day}/${month}/${year}`
      },
      parseDate (date) {
          if (!date) return null

          const [day, month, year] = date.split('/')
          return `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}`
      }


  }
}
</script>

<style scoped>

</style>