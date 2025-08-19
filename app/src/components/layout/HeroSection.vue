<template>
    <section class="flex justify-center items-center min-h-screen dark:text-primary mt-20 lg:mt-0">
        <header
            class="absolute w-1/2 aspect-[16/5] -skew-x-12 rounded-full bg-gradient-to-r from-[#00C6CC] via-[#785ae4] to-secondary opacity-30 dark:opacity-20 blur-[100px] left-10 top-0 hidden md:block">
        </header>
        <header
            class="absolute w-1/2 aspect-[16/5] -skew-x-12 rounded-full bg-gradient-to-r from-[#00C6CC] via-[#785ae4] to-secondary opacity-30 dark:opacity-20 blur-[100px] right-10 bottom-0 hidden md:block">
        </header>
        <main class="absolute grid lg:grid-cols-2 grid-cols-1 items-center p-2 lg:p-8">
            <header class="font-display text-center lg:text-left">
                <h1 class="mb-6 text-4xl md:text-5xl lg:text-6xl font-bold">
                    👋 Hi, I'm <span class="stroke-text">Matthieu</span>
                </h1>
                <p class="text-lg max-w-xl mx-auto lg:mx-0 font-semibold">
                    My portfolio site is coming soon.
                </p>
                <div class="mt-6 flex justify-center lg:justify-start">
                    <Button :label="HireMe" :onClick="openLinkedIn" />
                    <a href=""
                        class="font-semibold text-lg w-[10rem] h-[55px] text-secondary rounded-full ml-2 border-2 border-secondary hover:scale-105 bg-white dark:bg-transparent flex justify-center items-center">
                        <Icon icon="line-md:download-loop" class="text-3xl" />
                        <span class="ml-1">Resume</span>
                    </a>
                    <a :href="LinkedInUrl"
                        class="font-semibold text-lg w-[10rem] h-[55px] text-secondary rounded-full ml-2 border-2 border-secondary hover:scale-105 bg-white dark:bg-transparent flex justify-center items-center">
                        <Icon icon="mdi:linkedin" class="text-3xl" />
                    </a>
                </div>
            </header>
            <!-- <aside class="container flex justify-center lg:justify-end mt-20 lg:mt-0 items-center flex-wrap">
                <figure
                    class="card relative m-[30px] md:w-[420px] md:h-[420px] md:before:w-[450px] md:before:h-[450px] w-[280px] h-[350px] before:w-[300px] before:h-[300px] before:border-[25px] before:border-bg-gray-400 before:shadow-[7px_7px_21px_bg-gray-700,_-7px_-7px_21px_bg-gray-700]">
                    <div class="relative w-full h-full bg-cover transform translate-x-[10px] translate-y-[10px]">
                        <img src="@/assets/images/matthieu.png" alt="Matthieu Clement" class="max-w-1/2"
                            loading="lazy" />
                    </div>
                </figure>
            </aside> -->
        </main>

        <!-- <svg class="hidden">
            <filter id="wavy1">
                <feTurbulence x="0" y="0" base-frequency="0.2" num-octaves="5" seed="1" />
                <feDisplacementMap in="SourceGraphic" scale="30" />
            </filter>
        </svg> -->
    </section>
</template>
<script setup>
import Button from '@/components/UI/Button.vue';
import { ref } from 'vue';
import config from '@/config';
const HireMe = ref('Hire me');
const LinkedInUrl = ref(config.linkedInUrl);
console.log('LinkedIn URL:', config.linkedInUrl);


function openLinkedIn() {
    window.open(config.linkedInUrl, '_blank');
}

</script>

<style scoped>
/* .container .card:before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    z-index: 1;
    background: transparent
}

.container .card:nth-of-type(1)::before {
    filter: url(#wavy1);
} */
</style>