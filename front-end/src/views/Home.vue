<template>
  <div class="home">
    <div class="text-right mt-4 container">
      <b-icon
        v-b-tooltip.left="'Click to Checkout'"
        icon="cart3"
        font-scale="2"
        id="my-trigger-button-id"
        @click="checkoutSidebar()"
      ></b-icon>
      <b-badge variant="dark count-badge"> {{ cart.length }} </b-badge>
    </div>
    <!-- warehouse cars  -->
    <div class="container mt-5 mb-5">
      <div class="d-flex flex-row-reverse">
        <select v-model="sortBy">
          <option disabled value="0">Sort By</option>
          <option value="-1">Acsending</option>
          <option value="1">Desending</option>
        </select>
      </div>
      <div class="vGrid mt-5">
        <div
          class="gridItem border p-2 singleCar"
          v-for="(car, index) in sorted"
          :key="index"
        >
          <img :src="car.img" v-if="car.img" />
          <img :src="dummyImg" v-else class="carImg" alt="car image" />
          <p class="licensed" v-if="car.Licensed">Licensed</p>
          <p class="nolicensed" v-else>No License</p>
          <h5 class="carName">{{ car.Name }}</h5>
          <p class="dateAdded">{{ car.Date_added }}</p>
          <div class="price d-flex mt-3">
            <button
              class="btn btn-block btn-sm btn-outline-success"
              @click="OpenSidebar(index)"
            >
              View More
            </button>
          </div>
          <div class="price d-flex mt-1">
            <button
              class="btn btn-block btn-sm btn-outline-primary"
              @click.prevent="addToCart(index)"
            >
              Add to Cart
            </button>
          </div>
        </div>
      </div>
    </div>

    <!-- sidebar here-->
    <b-sidebar
      id="my-sidebar"
      title="Car Details"
      backdrop-variant="dark"
      backdrop
      shadow
    >
      <div class="carInfo">
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
              @click.prevent="addToCartFromSidebar"
            >
              Add to Cart
            </button>
          </div>
        </div>
      </div>
    </b-sidebar>

    <!--checkout sidebar here-->
    <b-sidebar
      id="checkout-sidebar"
      title="Checkout"
      backdrop-variant="dark"
      backdrop
      shadow
      right
    >
      <div class="cart">
        <div
          class="carsInCart"
          v-for="(car, cartIndex) in cart"
          :key="cartIndex"
        >
          <div class="row border">
            <div class="col-md-4 p-2">
              <img class="carImg" :src="car.img" v-if="car.img" />
              <img class="carImg" :src="dummyImg" v-else alt="car image" />
            </div>
            <div class="col-md-6 p-2">
              <p class="cart-car-name">{{ car.Name }}</p>
              <p class="cart-car-price bold">&euro; {{ car.Price }}</p>
            </div>
            <div class="col-md-2">
              <button
                class="btn btn-outline-danger deleteItem"
                @click="deleteItem(cartIndex)"
              >
                x
              </button>
            </div>
          </div>
        </div>
      </div>

      <template #footer>
        <div class="d-flex bg-dark text-light align-items-center px-3 py-2">
          <strong class="mr-auto">Total</strong>
          <div class="row">
            <div class="col-md-12">
             &euro; {{TotalPrice}}
            </div>
          </div>
        </div>
      </template>
    </b-sidebar>
  </div>
</template>

<script>
// @ is an alias to /src
import json from "../json/data.json";
export default {
  name: "Home",
  data: () => ({
    dummyImg: require("@/assets/img/dummycar.png"),
    cars: json,
    selectdCar: [],
    cart: [],
    sortBy: -1,
  }),
  methods: {
    OpenSidebar(index) {
      this.selectdCar = this.sorted[index];
      this.$root.$emit("bv::toggle::collapse", "my-sidebar");
    },
    addToCart(index) {
      this.cart.push(this.sorted[index]);
    },
    addToCartFromSidebar() {
      this.cart.push(this.selectdCar);
    },
    checkoutSidebar() {
      this.$root.$emit("bv::toggle::collapse", "checkout-sidebar");
    },
    deleteItem(cartIndex) {
      this.cart.splice(cartIndex, 1);
    },
  },
  computed: {
    sorted() {
      return [...this.cars].sort((a, b) => {
        var results;
        a = new Date(a.Date_added);
        b = new Date(b.Date_added);
        results = a > b ? -1 : a < b ? 1 : 0;
        return results * this.sortBy;
      });
    },
    TotalPrice() {
     return  this.cart.reduce((acc, item) => acc + item.Price, 0);
    }
  },
};
</script>
