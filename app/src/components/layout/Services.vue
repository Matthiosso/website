<template>
    <section id="services" class="relative text-white mt-32">
        <SectionHeader title="My Services" />
        <div
            class="mt-20 py-8 xl:px-16 px-4 sm:py-16 grid grid-cols-1 gap-6 pt-10 sm:grid-cols-2 md:gap-10 md:pt-12 lg:grid-cols-3">
            <article class="px-[12px] mb-[24px]" v-for="element in services" :key="element.id">
                <div class="mt-[30px] relative flex flex-col justify-center text-center rounder-[30px] border border-secondary dark:bg-[#ffffff29] bg-primary"
                    data-aos="fade-up" :data-aos-delay="element.id * 100">
                    <div class="mt-[-30px] flex justify-center relative">
                        <div class="mt-[-7px] p-[20px] relative rounded-[50%]">
                            <span
                                class="h-[60px] w-[60px] m-auto border-[1px] border-solid border-secondary absolute top-[8px] left-[8px] rounded-[50%] inline-block z-[5] bg-background">
                                <Icon :icon="element.icon" alt="services"
                                    class="ml-1 mt-1 h-[50px] w-[50px] relative z-[1] text-secondary" />
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
        icon: 'majesticons:eye-line',
        name: 'Frontend Web development',
        description: 'Vue.js, React.js, Tailwindcss, Vite'
    },
    {
        id: 2,
        icon: 'majesticons:server-line',
        name: 'Backend Web development',
        description: 'Spring Framework (Java), Django (Python)'
    },
    {
        id: 3,
        icon: 'majesticons:calculator-line',
        name: 'Software Development',
        description: 'Qt/OpenCV (C++)'
    },
    {
        id: 4,
        icon: 'majesticons:presentation-chart-line',
        name: 'Data Visualization',
        description: 'Kibana, Jupyter/Pandas (Python)'
    },
    {
        id: 5,
        icon: 'majesticons:box-line',
        name: 'DevOps',
        description: 'Docker, Mesos/Marathon, Kubernetes'
    },
    {
        id: 6,
        icon: 'majesticons:data-line',
        name: 'Database',
        description: 'PostgreSQL, ElasticSearch'
    },
    {
        id: 7,
        icon: 'majesticons:chats-2-line',
        name: 'Project Management',
        description: 'JIRA, Confluence'
    },
])
</script>