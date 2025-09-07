<template>
  <div class="min-h-screen">
    <Navbar />
    <HeroSection />
    <Counter />
    <Services />
  </div>
</template>

<script setup>
import { computed, defineAsyncComponent, ref } from 'vue';
import { useSeoMeta } from '@unhead/vue';
import img from '/logo/MC_1200x630.png';


const Navbar = defineAsyncComponent(() => import('@/components/layout/Navbar.vue'));
const HeroSection = defineAsyncComponent(() => import('@/components/layout/HeroSection.vue'));
const Counter = defineAsyncComponent(() => import('@/components/layout/Counter.vue'));
const Services = defineAsyncComponent(() => import('@/components/layout/Services.vue'));

// This code is to dynamically add the meta property for url preview
const metaInfos = ref({
  imgUrl: new URL(img, import.meta.url).href,
  title: 'Matthieu CLEMENT | My portfolio website',
  description: "Hey, I'm Matthieu CLEMENT, a french developer. Here's my portfolio website. Looking for a full stack developer or technical consultant ? I'm your man 👨‍💻"
})

useSeoMeta({
  // Basic SEO
  title: computed(() => metaInfos.value.title),
  description: computed(() => metaInfos.value.description),

  // Open Graph
  ogTitle: computed(() => metaInfos.value.title),
  ogDescription: computed(() => metaInfos.value.description),
  ogImage: {
    url: computed(() => metaInfos.value.imgUrl),
    width: 1200,
    height: 600,
    alt: 'Logo',
    type: 'image/png'
  },
  ogType: 'website',
  ogSiteName: 'Matthieu CLEMENT',
  ogLocale: 'en_US',

  // Twitter
  twitterTitle: computed(() => metaInfos.value.title),
  twitterDescription: computed(() => metaInfos.value.description),
  twitterImage: {
    url: computed(() => metaInfos.value.imgUrl),
    width: 1200,
    height: 600,
    alt: 'Logo',
    type: 'image/png'
  },
  twitterCard: 'summary_large_image',

})

</script>