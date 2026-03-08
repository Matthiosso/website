<template>
    <section id="whoami" data-aos="zoom-in" class="dark:text-primary relative p-2 py-10 min-w-screen">
        <SectionHeader />

        <main class="flex flex-wrap items-center justify-center">
            <div class="font-display text-center lg:text-left min-w-1">
                <h1
                    class="text-4xl md:text-5xl lg:text-6xl font-bold text-left cursor typewriter-animation lg:mx-0 max-w-xl">
                    👋 Hi, I'm <span class="stroke-text">Matthieu</span>
                </h1>
                <div class="space-y-4 text-lg leading-relaxed max-w-2xl mx-auto lg:mx-0">
                    <p>I love building bridges. Connecting systems using APIs. Connecting people using shared passion.
                        Connecting machine ability to human needs.</p>
                    <p>For 8 years at the French Ministry of Defense, I've shipped mission-critical systems, coordinated
                        hundreds of projects, and led teams through high-stakes operations, focusing on making the world
                        a safer place.</p>
                    <p>I believe efficient systems run on trust, transparency, and acknowledging our human biases. I am
                        just one piece of a larger mechanism. Together we go far beyond what we can reach on our own.
                    </p>
                    <p>In times of AI transformation where our reference points are shifting, we need people willing to
                        find and share clarity. That's my motto: study and share. Make the team bigger than the
                        individual, by giving each person space to bring their brick to the building.</p>
                    <p>Let's start building together!</p>
                </div>

                <div class="mt-6 flex flex-col items-center lg:flex-row lg:justify-start gap-2">
                    <Button :label="HireMe" :onClick="openContact" />
                    <button data-umami-event="download_resume" :onClick="downloadResume" class="font-semibold text-lg w-[10rem] h-[55px] text-secondary rounded-full border-2
    border-secondary hover:scale-105 bg-white dark:bg-transparent flex justify-center items-center">
                        <Icon icon="line-md:download-loop" class="text-3xl" />
                        <span class="ml-1">Resume</span>
                    </button>
                    <a :href="LinkedInUrl"
                        class="font-semibold text-lg w-[4rem] h-[55px] text-secondary rounded-full border-2 border-secondary hover:scale-105 bg-white dark:bg-transparent flex justify-center items-center">
                        <Icon icon="mdi:linkedin" class="text-3xl" />
                    </a>
                    <a :href="GithubUrl"
                        class="font-semibold text-lg w-[4rem] h-[55px] text-secondary rounded-full border-2 border-secondary hover:scale-105 bg-white dark:bg-transparent flex justify-center items-center">
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
const HireMe = ref('Build with me');
const LinkedInUrl = ref(config.linkedInUrl);
const GithubUrl = ref(config.githubUrl);

const downloadResume = () => {
    window.open(config.downloadResumeAPIUrl, '_blank');
}

const openContact = () => {
    const contactSection = document.getElementById('contact');
    if (contactSection) {
        contactSection.scrollIntoView({ behavior: 'smooth' });
    }
}

document.fonts.ready.then(() => {
    const el = document.querySelector('p') // change selector as needed
    const font = getComputedStyle(el).fontFamily
    console.log('Resolved font:', font)
    console.log('Cabin loaded:', document.fonts.check(`12px ${font}`))
});

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