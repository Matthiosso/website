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


// This code is to dynamically add the meta property for url preview
const imgUrl = new URL(img, import.meta.url).href
const title = 'Matthieu CLEMENT: My portfolio website'
const description = "Hey, I'm Matthieu CLEMENT, a french developer. Here's my portfolio website. Looking for a full stack developer or technical consultant ? I'm your man 👨‍💻"

useSeoMeta({
  // Basic SEO
  title: title,
  description: description,

  // Open Graph
  ogTitle: title,
  ogDescription: description,
  ogImage: {
    url: imgUrl,
    width: 1200,
    height: 600,
    alt: 'Logo',
    type: 'image/png'
  },
  ogType: 'website',
  ogSiteName: 'Matthieu CLEMENT',
  ogLocale: 'en_US',

  // Twitter
  twitterTitle: title,
  twitterDescription: description,
  twitterImage: {
    url: imgUrl,
    width: 1200,
    height: 600,
    alt: 'Logo',
    type: 'image/png'
  },
  twitterCard: 'summary_large_image',

})

</script>