<template>
    <section class="mt-20 lg:mt-0 w-full relative text-white flex justify-center">
        <ul ref="statsSection"
            class="relative z-1 p-6 mx-auto w-11/12 lg:mx-0 rounded-3xl border dark:bg-[#ffffff29] bg-primary shadow-lg md:divide-x grid grid-cols-2 md:grid-cols-3 gap-4 md:gap-8 lg:gap-12 border-secondary divide-secondary">
            <li class="text-center" v-for="element in numbers" :key="element.title">
                <h2 class="font-semibold flex justify-center text-xl sm:text-2xl md:text-4xl w-full">
                    +
                    <Countup v-if="hasIntersected" :endVal="element.number" />
                </h2>
                <p class="mt-2">{{ element.title }}</p>
            </li>
        </ul>
    </section>
</template>
<script setup>
import { ref, onMounted } from 'vue';

const numbers = ref([
    { title: 'Projects', number: 150 },
    { title: 'Teams worked with', number: 100 },
    { title: 'Years', number: 8 },
]);

const statsSection = ref(null);
const hasIntersected = ref(false);

onMounted(() => {
    const observer = new IntersectionObserver(([entry]) => {
        if (entry.isIntersecting) {
            hasIntersected.value = true;
            observer.disconnect(); // Stop observing once it has intersected
        }
    },
        { threshold: 0.5 } // Trigger when 50% of the section is visible
    );

    if (statsSection.value) {
        observer.observe(statsSection.value);
    }
});
</script>