<template>
    <section id="projects" class="relative text-white">
        <SectionHeader title="My Projects" small />
        <div class="xl:px-16 px-4 pb-8 pt-10 flex justify-center">
            <article class="px-[12px] w-full max-w-4xl" v-for="element in projects" :key="element.id">
                <div class="rounded-3xl relative flex flex-col md:flex-row overflow-hidden border border-secondary bg-block"
                    data-aos="fade-up">
                    <div class="md:w-1/2 flex items-center justify-center bg-background p-4">
                        <img v-if="element.image" :src="element.image" :alt="element.name"
                            class="w-full rounded-xl" loading="lazy" />
                        <Icon v-else :icon="element.icon" class="h-[120px] w-[120px] text-secondary" />
                    </div>
                    <div class="md:w-1/2 p-[30px] flex flex-col justify-center text-center md:text-left">
                        <h3 class="uppercase text-base light-stroke-text">
                            {{ element.name }}
                        </h3>
                        <p class="text-[14px] leading-[20px] text-white tracking-[0.03rem]">
                            {{ element.description }}
                        </p>
                        <div class="mt-2">
                            <template v-for="icon in element.icons" :key="icon">
                                <Icon :icon="icon" class="ml-1 mt-1 h-[35px] w-[35px] inline-block" />
                            </template>
                        </div>
                        <div class="mt-4">
                            <a :href="element.url" target="_blank" rel="noopener" data-umami-event="game_link"
                                class="font-semibold text-lg w-[10rem] h-[55px] text-secondary rounded-full border-2 border-secondary hover:scale-105 bg-white dark:bg-transparent inline-flex justify-center items-center">
                                <Icon icon="mdi:play" class="text-3xl" />
                                <span class="ml-1">Play</span>
                            </a>
                        </div>
                    </div>
                </div>
            </article>
        </div>
    </section>
</template>
<script setup>
import { ref } from 'vue';
import SectionHeader from '@/components/UI/SectionHeader.vue';
import frenchGameImage from '@/assets/images/frenchgame.webp';

const projects = ref([
    {
        id: 1,
        icon: 'mdi:gamepad-variant',
        image: frenchGameImage,
        name: 'French Game',
        description: 'A FR ↔ EN translation game with RPG progression (XP, combos, shop) and a kawaii dollhouse mini-game. Vanilla JS front, Node/Fastify API with SQLite cloud save, containerized and deployed on Kubernetes. Built with Claude Code.',
        icons: ['devicon:javascript', 'devicon:nodejs', 'devicon:fastify', 'devicon:sqlite', 'devicon:docker', 'devicon:kubernetes'],
        url: 'https://frenchgame.matthieuclement.com'
    },
])
</script>
