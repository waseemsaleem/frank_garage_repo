<template>
  <b-sidebar
    id="checkout-sidebar"
    title="Checkout"
    backdrop-variant="dark"
    backdrop
    shadow
    right
  >
    <div class="cart">
      <div class="carsInCart" v-for="(car, cartIndex) in cart" :key="cartIndex">
        <div class="row border">
          <div class="col-md-4 p-2">
            <img class="carImg" :src="car.img" v-if="car.img" />
            <img class="carImg" :src="dummyImg" v-else alt="car image" />
          </div>
          <div class="col-md-5 p-2">
            <p class="cart-car-name">{{ car.Name }}</p>
            <p class="cart-car-price bold">&euro; {{ car.Price }}</p>
          </div>
          <div class="col-md-1 p-0">
            <p class="text-warn quantity">
              {{ car.quantity }}
            </p>
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
          <div class="col-md-12">&euro; {{ TotalPrice }}</div>
        </div>
      </div>
    </template>
  </b-sidebar>
</template>
<script>
export default {
  name: "CheckoutSidebar",
  props: ["cart"],
  data: () => ({
    dummyImg: require("@/assets/img/dummycar.png"),
  }),
  methods: {
    deleteItem(cartIndex) {
      this.$emit("deleteItem", cartIndex);
    },
  },
  computed: {
    TotalPrice() {
      return this.cart.reduce((acc, item) => acc + item.Price, 0);
    },
  },
};
</script>
