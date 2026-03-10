<template>
    <div class="relative z-10">
        <label :for="id" class="block mb-2 mt-4 text-sm font-medium text-gray-900 dark:text-gray-300">
            {{ label }}
        </label>
        <input v-if="type !== 'textarea'" :type="type" :id="id" :placeholder="placeholder" v-model="value"
            class="shadow-sm text-white text-sm rounded-lg block w-full p-2.5 focus:ring-secondary-500 focus:border-secondary-500 border border-secondary bg-block" />
        <textarea v-else :id="id" :placeholder="placeholder" :rows="rows" v-model="value"
            class="shadow-sm text-white text-sm rounded-lg block w-full p-2.5 focus:ring-secondary-500 focus:border-secondary-500 border border-secondary bg-block"></textarea>
        <small v-if="error" class="mt-2 text-red-500 text-sm">{{ error }}</small>
    </div>
</template>

<script setup>
defineProps({
    id: {
        type: String,
        required: true
    },
    label: {
        type: String,
        required: true
    },
    type: {
        type: String,
        default: 'text'
    },
    placeholder: {
        type: String,
        default: ''
    },
    rows: {
        type: Number,
        default: 4
    }, // Only for textarea
});

const value = defineModel('value');
const error = defineModel('error');
</script>

<style></style>
