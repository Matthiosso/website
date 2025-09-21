<template>
    <section class="mt-32" id="contact">
        <SectionHeader title="Contact Me" />

        <div class="py-8 lg:py-16 px-4 mx-auto max-w-screen-md">
            <form class="space-y-8" @submit.prevent="checkForm">
                <div>
                    <Input id="email" label="Your email" type="email" placeholder="email@example.com"
                        v-model:value="email" />
                    <Input id="subject" label="Subject" type="text" placeholder="Let me know how I can help you"
                        v-model:value="subject" />
                    <Input id="message" label="Message" type="textarea" row="6" placeholder="Leave a comment..."
                        v-model:value="message" />
                    <p v-if="errorMessage" class="mt-2 text-secondary">{{ errorMessage }}</p>
                </div>
                <div class="flex justify-between">
                    <Button label="Send" type="submit" />
                </div>
            </form>
        </div>
    </section>

</template>

<script setup>
import SectionHeader from '@/components/UI/SectionHeader.vue';
import Input from '@/components/UI/Input.vue';
import Button from '@/components/UI/Button.vue';
import config from '@/config';
import { ref } from 'vue';

const SendMailURL = ref(config.sendMailAPIUrl);
const errorMessage = ref('');
const email = ref('');
const subject = ref('');
const message = ref('');

const checkForm = () => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email.value)) {
        errorMessage.value = 'Invalid email address';
    } else {
        errorMessage.value = '';
    }

    if (subject.value.trim() === '' || message.value.trim() === '') {
        errorMessage.value = 'Subject and message cannot be empty';
    } else {
        errorMessage.value = '';
    }

    //TODO: Implement actual sending of email through backend
    console.log(`Form submitted to ${SendMailURL.value}\nemail=${email.value}, subject=${subject.value}, value=${message.value}`);

};

</script>

<style></style>
