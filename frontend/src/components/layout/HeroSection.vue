<template>
    <section id="whoami" data-aos="zoom-in" class="dark:text-primary relative p-2 py-10">
        <SectionHeader />

        <main class="flex flex-col-reverse lg:flex-row items-center justify-center">
            <div class="font-display text-center lg:text-left min-w-1">
                <h1
                    class="text-4xl md:text-5xl lg:text-6xl font-bold text-left cursor typewriter-animation lg:mx-0 max-w-xl">
                    👋 Hi, I'm <span class="stroke-text">Matthieu</span>
                </h1>
                <p class="mt-2 text-xl md:text-2xl font-semibold text-secondary">
                    Full-Stack Developer — Java/Spring · Vue.js · Kubernetes
                </p>
                <div class="mt-3 flex flex-wrap justify-center lg:justify-start gap-2">
                    <span
                        class="inline-flex items-center gap-1.5 rounded-full border border-secondary px-3 py-1 text-sm font-medium">
                        <span class="relative flex h-2.5 w-2.5">
                            <span
                                class="absolute inline-flex h-full w-full animate-ping rounded-full bg-green-400 opacity-75"></span>
                            <span class="relative inline-flex h-2.5 w-2.5 rounded-full bg-green-500"></span>
                        </span>
                        Open to opportunities · Remote-friendly
                    </span>
                    <span
                        class="inline-flex items-center gap-1.5 rounded-full border border-secondary px-3 py-1 text-sm font-medium">
                        🇫🇷 Based in France
                    </span>
                </div>
                <div class="space-y-4 text-lg leading-relaxed max-w-2xl mx-auto lg:mx-0 my-4">
                    <p>For <strong>8 years at the French Ministry of Defense</strong>, I've shipped
                        mission-critical systems, coordinated 150+ projects, and led teams through high-stakes
                        operations — building software that has to work when it matters most.</p>
                    <p>I build bridges: connecting systems through clean APIs, and connecting people through shared
                        purpose. I believe great software runs on trust, transparency, and teams bigger than any single
                        individual.</p>
                    <p class="font-semibold">Let's build something together.</p>
                </div>

                <div class="mt-6 flex flex-col items-center lg:flex-row lg:justify-start gap-2">
                    <Button :label="HireMe" :onClick="openContact" data-umami-event="hire_me" />
                    <button data-umami-event="download_resume" :onClick="downloadResume" class="font-semibold text-lg w-[10rem] h-[55px] text-secondary rounded-full border-2
    border-secondary hover:scale-105 bg-white dark:bg-transparent flex justify-center items-center">
                        <Icon icon="line-md:download-loop" class="text-3xl" />
                        <span class="ml-1">Resume</span>
                    </button>
                    <a :href="LinkedInUrl" data-umami-event="linkedin"
                        class="font-semibold text-lg w-[4rem] h-[55px] text-secondary rounded-full border-2 border-secondary hover:scale-105 bg-white dark:bg-transparent flex justify-center items-center">
                        <Icon icon="mdi:linkedin" class="text-3xl" />
                    </a>
                    <a :href="GithubUrl" data-umami-event="github"
                        class="font-semibold text-lg w-[4rem] h-[55px] text-secondary rounded-full border-2 border-secondary hover:scale-105 bg-white dark:bg-transparent flex justify-center items-center">
                        <Icon icon="mdi:github" class="text-3xl" />
                    </a>
                </div>
            </div>
            <div class="flex justify-center lg:justify-end lg:mt-0 items-center flex-wrap">
                <figure
                    class="relative m-[30px] md:w-[420px] md:h-[420px] md:before:w-[450px] md:before:h-[450px] w-[280px] h-[280px] before:w-[300px] before:h-[300px]">
                    <div
                        class="w-full h-full bg-cover rounded-full overflow-hidden dark:mask-radial-at-center dark:mask-radial-from-30% border-[10px] border-secondary">
                        <img src="@/assets/images/matthieu.png" alt="Matthieu Clement" class="max-w" loading="lazy" />
                    </div>
                </figure>
            </div>
        </main>
    </section>
</template>
<script setup>
import Button from '@/components/UI/Button.vue';
import { ref } from 'vue';
import config from '@/config';
import SectionHeader from '@/components/UI/SectionHeader.vue';
const HireMe = ref('Build with me');
const LinkedInUrl = ref(config.linkedInUrl);
const GithubUrl = ref(config.githubUrl);

const downloadResume = () => {
    window.open(config.downloadResumeAPIUrl, '_blank');
}

const openContact = () => {
    window.dispatchEvent(new Event('open-contact'));
}

</script>

<style scoped>
/* Cursor */
.cursor {
    position: relative;
    width: 24em;
    margin: 0 0 auto;
    border-right: 2px solid;
    text-align: left;
    white-space: nowrap;
    overflow: hidden;
    /* transform: translateY(-50%); */
}

/* Animation */
.typewriter-animation {
    animation:
        typewriter 3s steps(50) 1s 1 normal both,
        blinkingCursor 500ms steps(50) normal infinite;
}

@keyframes typewriter {
    from {
        width: 0;
    }

    to {
        width: 100%;
    }
}

@keyframes blinkingCursor {
    from {
        border-right-opacity: rgba(0, 0, 0, 0.75);
    }

    to {
        border-right-color: transparent;
    }
}

/* Respect users who prefer reduced motion */
@media (prefers-reduced-motion: reduce) {
    .typewriter-animation {
        animation: none;
        width: 100%;
        border-right-color: transparent;
    }
}
</style>