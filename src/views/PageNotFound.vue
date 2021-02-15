<template>
    <div class="container mt-5 text-center">
        <img src="@/assets/logo.png" alt="Vue.js">
        <h1>Page Not Found</h1>
        <div class="d-flex justify-content-center align-items-center mt-3">
            <h3>Go Back to </h3> <router-link to="/" tag="button" class="btn btn-sm btn-outline-primary btn-inline ml-3">Home</router-link>
        </div>
    </div>
</template>
<script>
export default {
    name: 'PageNotFound'
}
</script>