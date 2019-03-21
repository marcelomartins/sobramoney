<template>
  <v-menu
    :close-on-content-click="false"
    v-model="menu"
    :nudge-right="40"
    lazy
    transition="scale-transition"
    offset-y
    full-width
    max-width="290px"
    min-width="290px"
  >
    <v-text-field label="Data" slot="activator" v-model="valorData" persistent-hint readonly></v-text-field>

    <v-date-picker v-model="date" no-title @input="menu = false" locale="pt-BR"></v-date-picker>
  </v-menu>
</template>


<script>
export default {
  name: "AData",
  props: ["value"],
  data() {
    return {
      menu: false,
      date: this.parseDate(this.value),
      valorData: this.value
    };
  },

  watch: {
    date() {
      this.valorData = this.formatDate(this.date);
      this.$emit("input", this.valorData);
    }
  },

  methods: {
    formatDate(date) {
      if (!date) return null;

      const [year, month, day] = date.split("-");
      return `${day}/${month}/${year}`;
    },
    parseDate(date) {
      if (!date) return null;

      const [day, month, year] = date.split("/");
      return `${year}-${month.padStart(2, "0")}-${day.padStart(2, "0")}`;
    }
  }
};
</script>

<style scoped>
</style>