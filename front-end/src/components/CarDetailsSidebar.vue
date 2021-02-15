<template>
  <b-sidebar
    id="my-sidebar"
    title="Car Details"
    backdrop-variant="dark"
    backdrop
    shadow
  >
    <div id="car-detials-sidebar" class="carInfo">
      <img class="carImg" :src="selectdCar.img" v-if="selectdCar.img" />
      <img class="carImg" :src="dummyImg" v-else alt="car image" />
      <h1 class="mt-3 carName">{{ selectdCar.Name }}</h1>
      <div class="row">
        <div class="col-md-6">
          <div class=" d-flex">
            <p class="bold">Acceleration:</p>
            <p class=" ml-auto">{{ selectdCar.Acceleration }}</p>
          </div>
          <div class=" d-flex">
            <p class="bold">Horsepower:</p>
            <p class=" ml-auto">{{ selectdCar.Horsepower }}</p>
          </div>
          <div class=" d-flex">
            <p class="bold">Cylinders:</p>
            <p class=" ml-auto">{{ selectdCar.Cylinders }}</p>
          </div>
          <div class=" d-flex">
            <p class="bold">Displacement:</p>
            <p class=" ml-auto">{{ selectdCar.Displacement }}</p>
          </div>
          <div class=" d-flex">
            <p class="bold">Miles per Gallon:</p>
            <p class=" ml-auto">{{ selectdCar.Miles_per_Gallon }}</p>
          </div>
        </div>
        <div class="col-md-6">
          <div class="price d-flex">
            <p class="bold">Price:</p>
            <p class="price ml-auto">&euro;{{ selectdCar.Price }}</p>
          </div>
          <div class=" d-flex">
            <p class="bold">Licensed:</p>
            <p class="ml-auto text-success" v-if="selectdCar.Licensed">
              License is Available
            </p>
            <p class="ml-auto text-danger" v-else>License is not Available</p>
          </div>
          <div class=" d-flex">
            <p class="bold">Warehouse:</p>
            <p class=" ml-auto">{{ selectdCar.Warehouse }}</p>
          </div>
          <button
            class="btn btn-block btn-sm btn-outline-primary mt-4"
            @click.prevent="addToCart"
          >
            Add to Cart
          </button>
        </div>
      </div>
    </div>
  </b-sidebar>
</template>
<script>
export default {
  name: "CarDetailsSidebar",
  props: ["selectdCar"],
  data: () => ({
    dummyImg: require("@/assets/img/dummycar.png"),
  }),
  methods: {
    addToCart() {
      this.$emit("addToCart");
    },
  },
};
</script>
