<template>
  <div class="min-h-screen">
    <Navbar />
    <HeroSection />
    <Counter />
    <Services />
  </div>
</template>

<script setup>
import { defineAsyncComponent, onMounted } from 'vue';
import img from '/logo/MC.png';


const Navbar = defineAsyncComponent(() => import('@/components/layout/Navbar.vue'));
const HeroSection = defineAsyncComponent(() => import('@/components/layout/HeroSection.vue'));
const Counter = defineAsyncComponent(() => import('@/components/layout/Counter.vue'));
const Services = defineAsyncComponent(() => import('@/components/layout/Services.vue'));


// This code is to dynamically add the meta property for url preview image because relative path is not allowed
console.log(import.meta);
const imgUrl = new URL(img, import.meta.url).href
const metaInfos = {
  'og:image': imgUrl,
  'twitter:image': imgUrl
}

onMounted(() => {
  for (const [property, content] of Object.entries(metaInfos)) {
    // Delete old tag if exists
    const existingMeta = document.querySelector(`meta[property="${property}"]`)
    if (existingMeta) {
      existingMeta.remove()
    }

    // Create new tag
    const meta = document.createElement('meta')
    meta.setAttribute('property', property)
    meta.setAttribute('content', content)
    document.head.appendChild(meta)
  }
})

</script>