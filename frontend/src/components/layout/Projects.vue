<template>
    <section id="projects" class="relative text-white mt-8 lg:mt-24">
        <SectionHeader title="Projects" />
        <div
            class="py-8 xl:px-16 px-4 sm:py-16 grid grid-cols-1 gap-6 pt-10 sm:grid-cols-2 md:gap-10 md:pt-12 lg:grid-cols-3">
            <article v-for="project in projects" :key="project.id" data-aos="fade-up"
                :data-aos-delay="project.id * 100"
                class="flex flex-col rounded-3xl border border-secondary bg-block p-6 text-left transition-transform duration-300 hover:scale-[1.02]">
                <div class="flex items-center gap-3">
                    <Icon :icon="project.icon" class="h-9 w-9 text-secondary" />
                    <h3 class="text-lg font-semibold light-stroke-text">{{ project.name }}</h3>
                </div>
                <p class="mt-3 flex-grow text-sm leading-[22px] tracking-[0.02rem]">{{ project.description }}</p>
                <p class="mt-3 text-xs font-semibold text-secondary">{{ project.impact }}</p>
                <div class="mt-4 flex flex-wrap items-center gap-2">
                    <Icon v-for="icon in project.stack" :key="icon" :icon="icon" class="h-7 w-7" />
                </div>
                <div class="mt-4 flex flex-wrap gap-3">
                    <a v-for="link in project.links" :key="link.url" :href="link.url" target="_blank"
                        rel="noopener noreferrer" data-umami-event="project_link"
                        :data-umami-event-project="project.name"
                        class="inline-flex items-center gap-1.5 rounded-full border border-secondary px-3 py-1.5 text-sm font-semibold hover:scale-105">
                        <Icon :icon="link.icon" class="text-lg" />
                        {{ link.label }}
                    </a>
                </div>
            </article>
        </div>
    </section>
</template>
<script setup>
import { ref } from 'vue';
import config from '@/config';
import SectionHeader from '@/components/UI/SectionHeader.vue';

const uid = (() => {
    let id = 0;
    return () => ++id;
})();

const projects = ref([
    {
        id: uid(),
        icon: 'majesticons:code-block-line',
        name: 'This portfolio',
        description:
            'A full-stack portfolio built end to end: Vue 3 + Vite + Tailwind front end, Spring Boot REST API, containerized with Docker and deployed on Kubernetes with automated CI/CD and semantic release.',
        impact: 'Ships to production automatically on every merge.',
        stack: ['devicon:vuejs', 'devicon:spring', 'devicon:java', 'devicon:docker', 'devicon:kubernetes'],
        links: [
            { label: 'Source', url: config.githubUrl, icon: 'mdi:github' },
        ],
    },
    {
        id: uid(),
        icon: 'majesticons:shield-line',
        name: 'Mission-critical systems',
        description:
            'Over 8 years at the French Ministry of Defense, designed and shipped high-availability backend systems for high-stakes operations, coordinating dozens of teams and hundreds of projects.',
        impact: '150+ projects delivered in demanding, secure environments.',
        stack: ['devicon:java', 'devicon:spring', 'devicon:postgresql', 'devicon:elasticsearch', 'devicon:docker'],
        links: [],
    },
    {
        id: uid(),
        icon: 'majesticons:presentation-chart-line',
        name: 'Data visualization & tooling',
        description:
            'Built internal data-visualization tools and dashboards (Kibana, Jupyter/Pandas) and computer-vision utilities in C++ (Qt/OpenCV) to turn raw operational data into actionable insight.',
        impact: 'Faster decisions from complex, high-volume data.',
        stack: ['devicon:kibana', 'devicon:jupyter-wordmark', 'devicon:python', 'devicon:qt', 'devicon:opencv'],
        links: [],
    },
]);
</script>
