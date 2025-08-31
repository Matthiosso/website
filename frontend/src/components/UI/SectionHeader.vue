<template>
    <!-- Color effects in background -->
    <header
        class="absolute w-1/2 aspect-[16/5] rounded-full -skew-x-12 bg-gradient-to-r from-[#00C6CC] via-[#785ae4] to-secondary opacity-30 dark:opacity-20 blur-[100px] left-10 top-0 hidden md:block">
    </header>
    <header
        class="absolute w-1/2 aspect-[16/5] rounded-full -skew-x-12 bg-gradient-to-r from-[#00C6CC] via-[#785ae4] to-secondary opacity-30 dark:opacity-20 blur-[100px] right-10 bottom-0 hidden md:block">
    </header>

    <!-- Title -->
    <h2 v-if="title" class="text-4xl md:text-5xl lg:tex-6xl font-bold text-center stroke-text" data-aos="fade-up">
        {{ title }}</h2>

</template>
<script setup>
defineProps({
    title: {
        type: String,
        default: ''
    }
});
</script>