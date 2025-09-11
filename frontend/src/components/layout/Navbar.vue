<template>
    <header>
        <div class="flex justify-between items-center p-8 lg:px-12 relative z-20 mb-50 md:mb-0 lg:mb-0">
            <a href="#" :onclick="restartGif">
                <img class="w-[200px] rounded-xl hover:scale-120" :src="gifLink" alt="logo" />
            </a>

            <!-- Mobile Toggle Button -->
            <div class="md:hidden z-30">
                <button class="block focus:outline-none" @click="isMenuOpen = !isMenuOpen">
                    <span v-if="isMenuOpen" class="text-5xl md:text-gray-500 text-gray-500">
                        <Icon icon="material-symbols:close" />
                    </span>
                    <span v-else class="text-5xl md:text-gray-500 text-gray-500">
                        <Icon icon="material-symbols:menu" />
                    </span>
                </button>
            </div>

            <!-- Navbar Link -->
            <nav :class="[
                `fixed inset-0 z-20 flex flex-col items-center justify-center md:relative 
                md:bg-transparent md:flex md:justify-between md:flex-row ${isMenuOpen ? 'block' : 'hidden'} bg-background`,
                ``
            ]">
                <ul class="flex flex-col items-center space-y-5 md:flex-row md:space-x-5 md:space-y-0">
                    <li v-for="item in Menu" key="item.name">
                        <a :href="item.href" @click="scrollToSection(item.href)"
                            class="block transition ease-linear text-2xl md:text-lg lg:text-xl font-bold">
                            {{ item.name }}
                        </a>
                    </li>
                </ul>
                <button @click="toggleDarkMode"
                    :class="(isMenuOpen ? 'mt-20' : 'ml-20') + ' z-10 md:block hover:scale-120'">
                    <!-- Show moon icon if dark mode is off, otherwise show sun icon -->
                    <Icon v-if="!isDarkMode" icon="line-md:moon-filled" class="text-5xl text-primary" />
                    <Icon v-else icon="line-md:sunny-outline" class="text-5xl text-secondary" />
                </button>
            </nav>
        </div>
    </header>
</template>

<script setup>
import { ref } from 'vue';
import config from '@/config';

const isMenuOpen = ref(false);

const gifLink = ref('/logo/MC-playonce.gif');
const restartGif = () => {
    gifLink.value = '/logo/MC-playonce.gif?a=' + Math.random();
};

const Menu = ref([
    { name: 'Who am I ?', href: '#whoami' },
    { name: 'My Services', href: '#services' },
    { name: 'Contact', href: config.linkedInUrl, external: true },
]);

const scrollToSection = (href) => {
    isMenuOpen.value = false;
    const section = document.querySelector(href);
    if (section) {
        section.scrollIntoView({ behavior: 'smooth' });
    }
};

// Reactive property to track dark mode state
const isDarkMode = ref(localStorage.getItem('theme') === 'dark');

const toggleDarkMode = () => {

    const htmlElement = document.documentElement;

    if (isDarkMode.value) {
        // Whenever the user explicitly chooses light mode
        localStorage.setItem('theme', 'light');
        htmlElement.classList.remove('dark');
    } else {
        // Whenever the user explicitly chooses dark mode
        localStorage.setItem('theme', 'dark');
        htmlElement.classList.add('dark');
    }

    // Toggle the dark mode state
    isDarkMode.value = !isDarkMode.value;
};
</script>