<template>
  <v-container>
    <v-form ref="form">
      <v-text-field v-model="registro.descricao" label="Descricao" required></v-text-field>
      <v-text-field v-model.number="registro.valor" label="Valor X" required></v-text-field>
      <a-data v-model="registro.dataInicial"></a-data>

      <v-btn @click="submit">Salvar</v-btn>
      <v-btn @click="clear">Limpar</v-btn>
    </v-form>
  </v-container>
</template>

<script>
import axios from "axios";
//import router from 'vue-router'
import AData from "./AData.vue";

export default {
  name: "EditaRegistros",
  components: {
    AData
  },
  data() {
    return {
      valid: false,
      registro: {}
    };
  },

  watch: {
    registro() {
      console.log(this.registro); /* eslint-disable-line no-console */
    }
  },

  methods: {
    submit() {
      if (this.$refs.form.validate()) {
        console.log(this.registro); /* eslint-disable-line no-console */

        var router = this.$router;

        axios.post("/registros", this.registro).then(function() {
          router.push({ path: "/" });
        });
      }
    },
    clear() {
      this.$refs.form.reset();
    }
  }
};
</script>

<style scoped>
</style>