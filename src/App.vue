<template>
  <div id="app">
    <ThemeHeader />
    <router-view />
    <ThemeFooter />
  </div>
</template>
<script>
import ThemeFooter from "@/views/ThemeFooter";
import ThemeHeader from "@/views/ThemeHeader";
export default {
  name: "App",
  components: { ThemeFooter, ThemeHeader },
};
</script>

<style>
@import "assets/css/style.css";
</style>
