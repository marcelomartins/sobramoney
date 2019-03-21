<template>
  <v-menu
    :close-on-content-click="false"
    v-model="menu1"
    :nudge-right="40"
    lazy
    transition="scale-transition"
    offset-y
    full-width
    max-width="290px"
    min-width="290px"
  >
    <v-text-field label="Data" slot="activator" v-model="valorData" persistent-hint readonly></v-text-field>

    <v-date-picker v-model="date" no-title @input="menu1 = false" locale="pt-BR"></v-date-picker>
  </v-menu>
</template>


<script>
export default {
  name: "AData",
  props: ["value"],
  data() {
    return {
      menu1: false,
      date: null,
      valorData: ""
    };
  },

  watch: {
    date() {
      this.valorData = this.formatDate(this.date);
      this.$emit("input", this.date);
    }
  },

  methods: {
    formatDate(date) {
      if (!date) return null;

      const [year, month, day] = date.split("-");
      return `${day}/${month}/${year}`;
    }
  }
};
</script>

<style scoped>
</style>