<template>
  <div class="min-h-screen">
    <Navbar />
    <HeroSection />
    <Counter />
    <Services />
  </div>
</template>

<script setup>
import { defineAsyncComponent } from 'vue';
import { useSeoMeta } from '@unhead/vue';
import img from '/logo/MC_1200x630.png';


const Navbar = defineAsyncComponent(() => import('@/components/layout/Navbar.vue'));
const HeroSection = defineAsyncComponent(() => import('@/components/layout/HeroSection.vue'));
const Counter = defineAsyncComponent(() => import('@/components/layout/Counter.vue'));
const Services = defineAsyncComponent(() => import('@/components/layout/Services.vue'));


// This code is to dynamically add the meta property for url preview image because relative path is not allowed
const imgUrl = new URL(img, import.meta.url).href
useSeoMeta({
  ogImage: imgUrl,
  twitterImage: imgUrl,
})

</script>