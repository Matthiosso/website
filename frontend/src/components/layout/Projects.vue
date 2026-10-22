<template>
    <section id="projects" class="relative text-white -mt-8">
        <SectionHeader title="My Projects" small />
        <div class="xl:px-16 px-4 pb-16 pt-10 flex justify-center">
            <article class="px-[12px] w-full max-w-4xl" v-for="element in projects" :key="element.id">
                <div class="rounded-3xl relative flex flex-col md:flex-row overflow-hidden border border-secondary bg-block"
                    data-aos="fade-up">
                    <div class="md:w-1/2 relative min-h-[260px] flex items-center justify-center bg-background">
                        <img v-if="element.image" :src="element.image" :alt="element.name"
                            class="absolute inset-0 w-full h-full object-cover object-[85%_50%]" loading="lazy" />
                        <Icon v-else :icon="element.icon" class="h-[120px] w-[120px] text-secondary" />
                    </div>
                    <div class="md:w-1/2 p-[30px] flex flex-col justify-center text-center md:text-left">
                        <h3 class="uppercase text-base light-stroke-text">
                            {{ element.name }}
                        </h3>
                        <p class="text-[14px] leading-[20px] text-white tracking-[0.03rem]">
                            {{ element.description }}
                        </p>
                        <p class="mt-2 text-[14px] leading-[20px] text-white tracking-[0.03rem]">
                            {{ element.tech }}
                        </p>
                        <div class="mt-2">
                            <template v-for="tool in element.icons" :key="tool.icon">
                                <Icon :icon="tool.icon" :title="tool.label" :aria-label="tool.label"
                                    class="ml-1 mt-1 h-[35px] w-[35px] inline-block" />
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
        description: 'A FR ↔ EN translation game with RPG progression (XP, combos, shop) and a kawaii dollhouse mini-game.',
        tech: 'Vanilla JS front, Node.js/Fastify API with SQLite cloud save, containerized and deployed on Kubernetes. Built with AI-assisted development (Claude Code).',
        icons: [
            { icon: 'devicon:javascript', label: 'JavaScript' },
            { icon: 'devicon:nodejs', label: 'Node.js' },
            { icon: 'devicon:fastify', label: 'Fastify' },
            { icon: 'devicon:sqlite', label: 'SQLite' },
            { icon: 'devicon:docker', label: 'Docker' },
            { icon: 'devicon:kubernetes', label: 'Kubernetes' },
        ],
        url: 'https://frenchgame.matthieuclement.com'
    },
])
</script>
