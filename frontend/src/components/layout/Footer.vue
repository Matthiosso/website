<template>
    <footer
        class="w-full bg-block text-gray-200 py-6 flex flex-col lg:flex-row justify-center items-center border-t border-secondary italic">
        <div class="ml-2 text-center lg:text-left">
            <p>Frontend developed with Vue.js, built with Vite & deployed with Kubernetes
                (Version : {{ frontendVersion }})
            </p>
            <p>Backend developed with Spring Boot, built with Maven & deployed with Kubernetes
                (Version : {{ backendVersion }})
            </p>
        </div>
    </footer>
</template>

<script setup>
import config from '@/config';
import { ref } from 'vue';
import axios from 'axios';

const frontendVersion = ref(__APP_VERSION__);
let backendVersion = ref('Loading...');

axios.get(config.versionAPIUrl).then(response => {
    backendVersion.value = response.data;
}).catch(() => {
    backendVersion.value = 'Error fetching version';
});

</script>