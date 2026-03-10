<template>
  <div class="min-h-screen">
    <Navbar />
    <HeroSection />
    <Counter />
    <Services />
    <Contact />
    <Footer />
  </div>
</template>

<script setup>
import { defineAsyncComponent } from 'vue';


const Navbar = defineAsyncComponent(() => import('@/components/layout/Navbar.vue'));
const HeroSection = defineAsyncComponent(() => import('@/components/layout/HeroSection.vue'));
const Counter = defineAsyncComponent(() => import('@/components/layout/Counter.vue'));
const Services = defineAsyncComponent(() => import('@/components/layout/Services.vue'));
const Contact = defineAsyncComponent(() => import('@/components/layout/Contact.vue'));
const Footer = defineAsyncComponent(() => import('@/components/layout/Footer.vue'));

</script>