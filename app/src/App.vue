<template>
  <div class="min-h-screen">
        <Navbar />
  </div>
</template>

<script setup>
import { defineAsyncComponent } from 'vue';
const Navbar = defineAsyncComponent(() => import('@/components/layout/Navbar.vue'));
</script>