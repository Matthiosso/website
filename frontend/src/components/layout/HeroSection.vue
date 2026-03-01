<template>
    <section id="whoami" data-aos="zoom-in" class="dark:text-primary relative p-2 py-10 min-w-screen">
        <SectionHeader />

        <main class="flex flex-wrap items-center justify-center">
            <div class="font-display text-center lg:text-left min-w-1">
                <h1
                    class="text-4xl md:text-5xl lg:text-6xl font-bold text-left cursor typewriter-animation lg:mx-0 max-w-xl">
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
                    challenges that drive growth. Now, preparing for fatherhood and relocation to the United States,
                    I'm
                    seeking a company that values what I bring: technical expertise, strategic vision, and the
                    commitment to build bridges between what is and what could be.
                </p>

                <div class="mt-6 flex justify-center lg:justify-start">
                    <Button :label="HireMe" :onClick="openContact" />
                    <button :onClick="downloadResume"
                        class="font-semibold text-lg w-[10rem] h-[55px] text-secondary rounded-full ml-2 border-2
                        border-secondary hover:scale-105 bg-white dark:bg-transparent flex justify-center items-center">
                        <Icon icon="line-md:download-loop" class="text-3xl" />
                        <span class="ml-1">Resume</span>
                    </button>
                    <a :href="LinkedInUrl"
                        class="font-semibold text-lg w-[4rem] h-[55px] text-secondary rounded-full ml-2 border-2 border-secondary hover:scale-105 bg-white dark:bg-transparent flex justify-center items-center">
                        <Icon icon="mdi:linkedin" class="text-3xl" />
                    </a>
                    <a :href="GithubUrl"
                        class="font-semibold text-lg w-[4rem] h-[55px] text-secondary rounded-full ml-2 border-2 border-secondary hover:scale-105 bg-white dark:bg-transparent flex justify-center items-center">
                        <Icon icon="mdi:github" class="text-3xl" />
                    </a>
                </div>
            </div>
            <div class="flex justify-center lg:justify-end mt-20 lg:mt-0 items-center flex-wrap">
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
import { usePlausible } from 'v-plausible/vue';
const { trackEvent } = usePlausible()
const HireMe = ref('Work with me');
const LinkedInUrl = ref(config.linkedInUrl);
const GithubUrl = ref(config.githubUrl);


const downloadResume = () => {
    trackEvent('download_resume');
    window.open(config.downloadResumeAPIUrl, '_blank');
}

const openContact = () => {
    const contactSection = document.getElementById('contact');
    if (contactSection) {
        contactSection.scrollIntoView({ behavior: 'smooth' });
    }
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
    transform: translateY(-50%);
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
</style>