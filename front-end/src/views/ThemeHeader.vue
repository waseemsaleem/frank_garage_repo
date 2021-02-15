<template>
    <section class="firstSection ">
      <h1 class="text-center">Frank's Garage</h1>
    </section>
</template>

<script>
export default {
    name: 'ThemeHeader'
}
</script>
<style scoped>
.firstSection {
  background-image: url('../assets/img/background.png');
  background-repeat: no-repeat;
  background-size: cover;
  min-height: 100px;
  color: #fff;
}

.firstSection h1 {
  padding-top: 23px;
}


</style>