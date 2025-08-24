<template>
    <section data-aos="zoom-in" class="flex justify-center items-center min-h-screen dark:text-primary mt-20 lg:mt-0">
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
                <p class="text-lg max-w-xl mx-auto lg:mx-0 font-semibold italic">
                    Thriving beyond comfort zones defines my approach to engineering and life. My journey evolved
                    from full-stack development to strategic
                    defense operations, driven by curiosity to understand the human stories behind technical
                    requirements. Whether coordinating crisis teams, managing international partnerships, or
                    debugging complex systems, I excel where pressure meets precision.
                    <br />My adaptability isn't just a
                    skill—it's a philosophy. Just as I conquered my fear of heights through rock climbing, I embrace
                    challenges that drive growth. Now, preparing for fatherhood and relocation to the United States, I'm
                    seeking a company that values what I bring: technical expertise, strategic vision, and the
                    commitment to build bridges between what is and what could be.
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
            <aside class="container flex justify-center lg:justify-end mt-20 lg:mt-0 items-center flex-wrap">
                <figure
                    class="card relative m-[30px] md:w-[420px] md:h-[420px] md:before:w-[450px] md:before:h-[450px] w-[280px] h-[280px] before:w-[300px] before:h-[300px]">
                    <div
                        class="w-full h-full bg-cover rounded-full overflow-hidden dark:mask-radial-at-center dark:mask-radial-from-30% border-[10px] border-secondary">
                        <img src="@/assets/images/matthieu.png" alt="Matthieu Clement" class="max-w" loading="lazy" />
                    </div>
                </figure>
            </aside>
        </main>
    </section>
</template>
<script setup>
import Button from '@/components/UI/Button.vue';
import { ref } from 'vue';
import config from '@/config';
const HireMe = ref('Hire me');
const LinkedInUrl = ref(config.linkedInUrl);


function openLinkedIn() {
    window.open(config.linkedInUrl, '_blank');
}

</script>


<style scoped>
.container .card:before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    z-index: 1;
}
</style>