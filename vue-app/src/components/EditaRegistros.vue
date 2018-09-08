<template>
<v-container>
  <v-form ref="form">
        <v-text-field v-model="registro.descricao" label="Descricao" required></v-text-field>
        <v-text-field v-model.number="registro.valor" label="Valor" required></v-text-field>
        <v-text-field v-model="registro.dataInicial" label="Data" required></v-text-field>

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
        dataInicial: false,
        registro: {}
    };
  },
  methods: {
    submit () {
        if (this.$refs.form.validate()) {
            console.log(this.registro); /* eslint-disable-line no-console */

          // Native form submission is not yet supported
          axios.post('/registros', this.registro)

          this.$router.push({ path: '/' })

        }
      },
      clear () {
        this.$refs.form.reset()
      }
  }
}
</script>

<style scoped>

</style>