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
  // title & descriptions
  ogTitle: title,
  ogLocale: 'en_US',
  ogType: 'website',
  ogDescription: description,
  twitterTitle: title,
  twitterDescription: description,

  // og image
  ogImage: {
    url: imgUrl,
    width: 1200,
    height: 600,
    alt: 'Logo',
    type: 'image/png'
  },
  twitterImage: {
    url: imgUrl,
    width: 1200,
    height: 600,
    alt: 'Logo',
    type: 'image/png'
  },
  // twitter image (note: ogImage is used as a fallback so this is optional)
  twitterCard: 'summary_large_image', // or summary
})

</script>