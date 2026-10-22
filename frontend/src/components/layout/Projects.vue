<template>
    <section id="projects" class="relative text-white mt-8 lg:mt-24">
        <SectionHeader title="My Projects" />
        <div class="py-8 xl:px-16 px-4 sm:py-16 flex justify-center pt-10 md:pt-12">
            <article class="px-[12px] mb-[24px] w-full max-w-md" v-for="element in projects" :key="element.id">
                <div class="mt-[30px] rounded-3xl relative flex flex-col justify-center text-center rounder-[30px] border border-secondary bg-block"
                    data-aos="fade-up">
                    <div class="mt-[-30px] flex justify-center relative">
                        <div class="mt-[-7px] p-[20px] relative rounded-[50%]">
                            <span
                                class="h-[60px] w-[60px] m-auto border-[1px] border-solid border-secondary absolute top-[8px] left-[8px] rounded-[50%] inline-block z-[5] bg-background">
                                <Icon :icon="element.icon" alt="projects"
                                    class="ml-1 mt-1 h-[50px] w-[50px] relative z-[1] text-secondary" />
                            </span>
                        </div>
                    </div>
                    <div class="p-[30px]">
                        <h3 class="uppercase text-base light-stroke-text">
                            {{ element.name }}
                        </h3>
                        <p class="text-[14px] leading-[20px] text-white tracking-[0.03rem]">
                            {{ element.description }}
                        </p>
                        <a :href="element.url" target="_blank" rel="noopener" data-umami-event="game_link"
                            class="mt-4 font-semibold text-lg w-[10rem] h-[55px] text-secondary rounded-full border-2 border-secondary hover:scale-105 bg-white dark:bg-transparent inline-flex justify-center items-center">
                            <Icon icon="mdi:play" class="text-3xl" />
                            <span class="ml-1">Play</span>
                        </a>
                    </div>
                </div>
            </article>
        </div>
    </section>
</template>
<script setup>
import { ref } from 'vue';
import SectionHeader from '@/components/UI/SectionHeader.vue';

const projects = ref([
    {
        id: 1,
        icon: 'mdi:gamepad-variant',
        name: 'French Game',
        description: 'A game I built myself. Come and play!',
        url: 'https://frenchgame.matthieuclement.com'
    },
])
</script>
