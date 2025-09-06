<template>
    <section id="services" class="relative text-white mt-32">
        <SectionHeader title="My Services" />
        <div
            class="mt-20 py-8 xl:px-16 px-4 sm:py-16 grid grid-cols-1 gap-6 pt-10 sm:grid-cols-2 md:gap-10 md:pt-12 lg:grid-cols-3">
            <article class="px-[12px] mb-[24px]" v-for="element in services" :key="element.id">
                <div class="mt-[30px] relative flex flex-col justify-center text-center rounder-[30px] border border-secondary bg-block"
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
                        <h3 class="uppercase text-base light-stroke-text">
                            {{ element.name }}
                        </h3>
                        <p class="text-[14px] leading-[20px] text-white tracking-[0.03.rem]">
                            {{ element.description }}
                        </p>
                        <template v-for="icon in element.icons" :key="icon">
                            <Icon :icon="icon" class="ml-1 mt-1 h-[35px] w-[35px] inline-block" />
                        </template>
                    </div>
                </div>
            </article>
        </div>
    </section>
</template>
<script setup>
import { ref } from 'vue';
import SectionHeader from '@/components/UI/SectionHeader.vue';

const uid = (() => {
    let id = 0;
    return () => {
        id++;
        return id;
    }
})();


const services = ref([
    {
        id: uid(),
        icon: 'majesticons:server-line',
        name: 'Backend Web development',
        description: 'Spring Framework (Java), Django (Python)',
        icons: ['devicon:spring', 'devicon:java', 'simple-icons:django', 'devicon:python']
    },
    {
        id: uid(),
        icon: 'majesticons:box-line',
        name: 'DevOps',
        description: 'Docker, Mesos/Marathon, Kubernetes, CI/CD (Github/Gitlab)',
        icons: ['devicon:docker', 'logos:mesos', 'devicon:kubernetes', 'skill-icons:github-light', 'devicon:gitlab']
    },
    {
        id: uid(),
        icon: 'majesticons:calculator-line',
        name: 'Software Development',
        description: 'Qt/OpenCV (C++)',
        icons: ['devicon:qt', 'devicon:opencv', 'devicon:cplusplus']
    },
    {
        id: uid(),
        icon: 'majesticons:presentation-chart-line',
        name: 'Data Visualization',
        description: 'Kibana, Jupyter/Pandas (Python)',
        icons: ['devicon:kibana', 'devicon:jupyter', 'simple-icons:geopandas', 'devicon:python']
    },
    {
        id: uid(),
        icon: 'majesticons:data-line',
        name: 'Database',
        description: 'PostgreSQL, ElasticSearch',
        icons: ['devicon:postgresql', 'devicon:elasticsearch']
    },
    {
        id: uid(),
        icon: 'majesticons:eye-line',
        name: 'Frontend Web development',
        description: 'Vue.js, React.js, Tailwindcss, Vite',
        icons: ['devicon:vuejs', 'devicon:react', 'devicon:tailwindcss', 'devicon:vitejs']
    },
    {
        id: uid(),
        icon: 'majesticons:chats-2-line',
        name: 'Project Management',
        description: 'JIRA, Confluence',
        icons: ['devicon:jira', 'devicon:confluence']
    },
])
</script>