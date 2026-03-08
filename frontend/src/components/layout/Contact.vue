<template>
    <section class="mt-32" id="contact">
        <SectionHeader title="Contact Me" />

        <div class="py-8 lg:py-16 px-4 mx-auto max-w-screen-md">
            <form class="space-y-8" @submit.prevent="submitForm">
                <div>
                    <Input id="email" label="Your email" type="email" placeholder="email@example.com"
                        v-model:value="fields.email.value" v-model:error="fields.email.error" />
                    <Input id="subject" label="Subject" type="text"
                        placeholder="Let me know what we should build together !" v-model:value="fields.subject.value"
                        v-model:error="fields.subject.error" />
                    <Input id="message" label="Message" type="textarea" row="6" placeholder="Write your message here"
                        v-model:value="fields.message.value" v-model:error="fields.message.error" />

                </div>
                <div v-if="isLoading">
                    <Icon icon="line-md:loading-loop" class="text-3xl mt-2 text-secondary animate-spin" />
                </div>
                <div class="flex flex-col" v-else>
                    <div class="flex-1"><Button label="Send" type="submit" data-umami-event="submit_contact_form"
                            :data-umami-event-email="fields.email.value"
                            :data-umami-event-subject="fields.subject.value" />
                    </div>
                    <div class="flex-1">
                        <p v-if="formMessage.message"
                            :class="formMessage.isError ? 'mt-2 text-red-500' : 'mt-2 text-secondary'">{{
                                formMessage.message }}</p>
                    </div>
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
const fields = ref({
    email: {
        value: '',
        error: ''
    },
    subject: {
        value: '',
        error: ''
    },
    message: {
        value: '',
        error: ''
    }
});
const validateEmail = (value) => {
    if (value.trim() === '') {
        fields.value.email.error = 'Email cannot be empty';
        return false;
    }
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(value)) {
        fields.value.email.error = 'Invalid email address';
        return false;
    }
    fields.value.email.error = '';
    return true;
};
const validateSubject = (value) => {
    if (value.trim() === '') {
        fields.value.subject.error = 'Subject cannot be empty';
        return false;
    }
    if (value.length > 70) {
        fields.value.subject.error = 'Subject cannot exceed 70 characters';
        return false;
    }
    fields.value.subject.error = '';
    return true;
};
const validateMessage = (value) => {
    if (value.trim() === '') {
        fields.value.message.error = 'Message cannot be empty';
        return false;
    }
    if (value.length > 1000) {
        fields.value.message.error = 'Message cannot exceed 1000 characters';
        return false;
    }
    fields.value.message.error = '';
    return true;
};
const userAgent = ref('');
const isLoading = ref(false);

const getUserAgent = () => {
    if (typeof window !== 'undefined') {
        return window.navigator.userAgent;
    } else {
        console.error('Window object is not defined (e.g., during SSR)');
        return '';
    }
};

const clearForm = () => {
    fields.value.email.value = '';
    fields.value.email.error = '';
    fields.value.subject.value = '';
    fields.value.subject.error = '';
    fields.value.message.value = '';
    fields.value.message.error = '';
    isLoading.value = false;
};

const validateForm = () => {
    const validityEmail = validateEmail(fields.value.email.value);
    const validitySubject = validateSubject(fields.value.subject.value);
    const validityMessage = validateMessage(fields.value.message.value);
    return validityEmail && validitySubject && validityMessage;
};

const submitForm = () => {
    if (!validateForm()) {
        return;
    }
    userAgent.value = getUserAgent();

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
                userEmail: email.value || ''
            }
        })
    }).then(response => {
        if (!response.ok) {
            formMessage.value.isError = true;
        }
        return response.text();
    }).then(data => {
        if (formMessage.value.isError) {
            formMessage.value.message = 'Failed to send message : ' + data;
            return;
        }
        formMessage.value = {
            message: data || 'Message sent successfully!',
            isError: false
        };
        clearForm();
    }).catch((error) => {
        let errorMessage = error.message || 'Unknown error';
        if (errorMessage.includes('Failed to fetch')) {
            errorMessage = 'Network error. The backend server may be unreachable or the request was blocked.';
        }
        formMessage.value = {
            message: 'Failed to send message : ' + errorMessage,
            isError: true
        };
        console.error('Error:', error);
    }).finally(() => {
        isLoading.value = false;
    });

};

</script>
