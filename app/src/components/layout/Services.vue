<template>
    <section id="services" class="relative text-white mt-32">
        <SectionHeader title="My Services" />
        <div
            class="mt-20 py-8 xl:px-16 px-4 sm:py-16 grid grid-cols-1 gap-6 pt-10 sm:grid-cols-2 md:gap-10 md:pt-12 lg:grid-cols-3">
            <article class="px-[12px] mb-[24px]" v-for="element in services" :key="element.id">
                <div class="mt-[30px] relative flex flex-col justify-center text-center rounder-[30px] border border-secondary dark:bg-[#ffffff29] bg-primary"
                    data-aos="fade-up" :data-aos-delay="element.id * 100">
                    <div class="mt-[-30px] flex justify-center relative">
                        <div class="mt-[-7px] p-[20px] relative bg-background rounded-[50%]">
                            <span
                                class="h-[60px] w-[60px] m-auto border-[1px] border-solid border-secondary absolute top-[8px] left-[8px] rounded-[50%] inline-block z-[5] ">
                                <Icon :icon="element.icon" alt="services"
                                    class="h-[35px] w-[35px] relative z-[1] text-secondary" />
                            </span>
                        </div>
                    </div>
                    <div class="p-[30px]">
                        <h3 class="uppercase font-semibold text-secondary text-base">
                            {{ element.name }}
                        </h3>
                        <p class="text-[14px] leading-[20px] text-white tracking-[0.03.rem]">
                            {{ element.description }}
                        </p>
                    </div>
                </div>
            </article>
        </div>
    </section>
</template>
<script setup>
import { ref } from 'vue';
import SectionHeader from '@/components/UI/SectionHeader.vue';

const services = ref([
    {
        id: 1,
        icon: 'majesticons:airplane-line',
        name: 'Web development',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
    },
    {
        id: 2,
        icon: 'majesticons:bookmark-minus-line',
        name: 'Web development',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
    },
    {
        id: 3,
        icon: 'majesticons:camera-line',
        name: 'Web development',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
    },
    {
        id: 4,
        icon: 'majesticons:checkbox-list-detail',
        name: 'Web development',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
    },
    {
        id: 5,
        icon: 'majesticons:covid-line',
        name: 'Web development',
        description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'
    },
])
</script>