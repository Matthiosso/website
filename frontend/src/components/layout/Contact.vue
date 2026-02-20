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
                    <p v-if="formMessage.message"
                        :class="formMessage.isError ? 'mt-2 text-red-500' : 'mt-2 text-secondary'">{{
                            formMessage.message }}</p>
                </div>
                <div class="flex justify-between">
                    <Button label="Send" type="submit" :isDisabled="isLoading" />
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
const formMessage = ref({
    message: '',
    isError: false
});
const email = ref('');
const subject = ref('');
const message = ref('');
const userAgent = ref('');
const gaClientId = ref('');
const isLoading = ref(false);

const getUserAgent = () => {
    if (typeof window !== 'undefined') {
        return window.navigator.userAgent;
    } else {
        console.error('Window object is not defined (e.g., during SSR)');
        return '';
    }
};

const getGaClientId = () => {
    const name = "_ga=";
    const decodedCookie = decodeURIComponent(document.cookie);
    const ca = decodedCookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            // Returns the full cookie value, e.g., GA1.1.40030803.167153367
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

const clearForm = () => {
    email.value = '';
    subject.value = '';
    message.value = '';
    isLoading.value = false;
};


const checkForm = () => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email.value)) {
        formMessage.value = {
            message: 'Invalid email address',
            isError: true
        };
        return;
    }

    if (subject.value.trim() === '' || message.value.trim() === '') {
        formMessage.value = {
            message: 'Subject and message cannot be empty',
            isError: true
        };
        return;
    }

    userAgent.value = getUserAgent();
    gaClientId.value = getGaClientId();
    isLoading.value = true;
    fetch(SendMailURL.value, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            subject: subject.value,
            message: message.value,
            userInfo: {
                userAgent: userAgent.value || '',
                gaClientId: gaClientId.value || '',
                userEmail: email.value || ''
            }
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            formMessage.value = {
                message: data || 'Message sent successfully!',
                isError: false
            };
            clearForm();
        })
        .catch((error) => {
            formMessage.value = {
                message: 'Failed to send message : ' + (error.message || 'Unknown error'),
                isError: true
            };
            console.error('Error:', error);
            isLoading.value = false;
        });
};

</script>

<style></style>
