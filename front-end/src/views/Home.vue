<template>
  <div class="home">
    <div class="text-right cartIcon">
      <div class="container">
        <b-icon
          v-b-tooltip.left="'Click to Checkout'"
          icon="cart3"
          font-scale="2"
          id="my-trigger-button-id"
          @click="checkoutSidebar()"
        ></b-icon>
        <b-badge variant="dark count-badge">{{ cartItemsQuantity }}</b-badge>
      </div>
    </div>
    <!-- cars  -->
    <div class="container mt-5 mb-5">
      <div class="d-flex flex-row-reverse">
        <select v-model="sortBy">
          <option disabled value="0">Sort By</option>
          <option value="-1">Acsending</option>
          <option value="1">Desending</option>
        </select>
        <p class="mr-3">Created Date:</p>
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
    <CarDetailsSidebar
      :selectdCar="selectdCar"
      @addToCart="addToCartFromSidebar"
    ></CarDetailsSidebar>
    <!--checkout sidebar here-->
    <CheckoutSidebar :cart="cart" @deleteItem="deleteItem"> </CheckoutSidebar>
  </div>
</template>

<script>
// @ is an alias to /src
import json from "../json/data.json";
import CarDetailsSidebar from "@/components/CarDetailsSidebar";
import CheckoutSidebar from "@/components/CheckoutSidebar";
export default {
  name: "Home",
  components: { CarDetailsSidebar, CheckoutSidebar },
  data: () => ({
    dummyImg: require("@/assets/img/dummycar.png"),
    cars: json,
    selectdCar: [],
    cart: [],
    selectedIndex: 0,
    sortBy: -1,
  }),
  methods: {
    OpenSidebar(index) {
      this.selectdCar = this.sorted[index];
      this.selectedIndex = index;
      this.$root.$emit("bv::toggle::collapse", "my-sidebar");
    },
    addToCart(index) {
      // debugger;
      var item = this.sorted[index];
      var findProduct = this.cart.find((o) => o.Name === item.Name);
      if (findProduct) {
        item.quantity++;
        item.totalPrice = item.quantity * item.Price;
        return;
      } else {
        this.cart.push(item);
        item.quantity = 1;
        item.totalPrice = item.quantity * item.Price;
      }
    },
    addToCartFromSidebar() {
      var item = this.selectdCar;
      var findProduct = this.cart.find((o) => o.Name === item.Name);
      if (findProduct) {
        item.quantity++;
        item.totalPrice = item.quantity * item.Price;
        return;
      } else {
        this.cart.push(item);
        item.quantity = 1;
        item.totalPrice = item.quantity * item.Price;
      }
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
    cartItemsQuantity() {
      return this.cart.reduce((acc, item) => acc + item.quantity, 0);
    },
  },
};
</script>
