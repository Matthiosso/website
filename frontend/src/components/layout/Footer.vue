<script setup>
// can't be used directly on the template
const version = __APP_VERSION__
</script>
<template>
    <footer
        class="w-full bg-block text-gray-200 py-6 flex flex-col lg:flex-row justify-center items-center border-t border-secondary italic">
        Developed with Vue.js -- Built with Vite -- Deployed with Kubernetes -- Version : {{ version }}
    </footer>
</template>