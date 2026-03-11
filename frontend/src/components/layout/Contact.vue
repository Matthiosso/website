<template>
    <div class="fixed bottom-6 right-6 z-50">
        <Transition name="contact-popup">
            <div v-show="isOpen"
                class="absolute bottom-18 right-0 w-[340px] sm:w-[380px] bg-white rounded-xl shadow-2xl overflow-hidden mb-2">
                <div class="bg-secondary px-4 py-3 flex justify-between items-center">
                    <h3 class="font-semibold text-lg text-white">Envoyer un message</h3>
                    <button @click="isOpen = false"
                        class="text-white hover:opacity-70 transition-opacity text-xl leading-none">
                        <Icon icon="mdi:close" class="text-2xl" />
                    </button>
                </div>

                <form class="p-4 space-y-3" @submit.prevent="submitForm">
                    <div>
                        <label for="popup-email"
                            class="block text-sm font-medium text-gray-700 mb-1">Votre email</label>
                        <input id="popup-email" type="email" v-model="fields.email.value"
                            class="w-full border border-gray-300 rounded-lg px-3 py-2 text-sm text-gray-900 focus:outline-none focus:ring-2 focus:ring-secondary focus:border-secondary" />
                        <small v-if="fields.email.error" class="text-red-500 text-xs">{{ fields.email.error }}</small>
                    </div>

                    <div>
                        <label for="popup-subject"
                            class="block text-sm font-medium text-gray-700 mb-1">Objet</label>
                        <input id="popup-subject" type="text" v-model="fields.subject.value"
                            class="w-full border border-gray-300 rounded-lg px-3 py-2 text-sm text-gray-900 focus:outline-none focus:ring-2 focus:ring-secondary focus:border-secondary" />
                        <small v-if="fields.subject.error" class="text-red-500 text-xs">{{ fields.subject.error
                            }}</small>
                    </div>

                    <div>
                        <label for="popup-message"
                            class="block text-sm font-medium text-gray-700 mb-1">Message</label>
                        <textarea id="popup-message" rows="5" v-model="fields.message.value"
                            class="w-full border border-gray-300 rounded-lg px-3 py-2 text-sm text-gray-900 focus:outline-none focus:ring-2 focus:ring-secondary focus:border-secondary resize-none"></textarea>
                        <small v-if="fields.message.error" class="text-red-500 text-xs">{{ fields.message.error
                            }}</small>
                    </div>

                    <div ref="captchaWidget" class="scale-[0.85] origin-left"></div>

                    <div v-if="isLoading" class="flex justify-end">
                        <Icon icon="line-md:loading-loop" class="text-2xl text-secondary animate-spin" />
                    </div>
                    <div v-else class="flex flex-col items-end gap-1">
                        <button type="submit" data-umami-event="submit_contact_form"
                            :data-umami-event-email="fields.email.value"
                            :data-umami-event-subject="fields.subject.value"
                            class="bg-secondary text-white px-5 py-2.5 rounded-lg font-semibold flex items-center gap-2 hover:opacity-90 transition-opacity">
                            Envoyer
                            <Icon icon="mdi:send" class="text-lg" />
                        </button>
                        <p v-if="formMessage.message"
                            :class="formMessage.isError ? 'text-red-500 text-xs' : 'text-green-600 text-xs'">
                            {{ formMessage.message }}
                        </p>
                    </div>
                </form>
            </div>
        </Transition>

        <button @click="isOpen = !isOpen"
            class="w-14 h-14 rounded-full bg-secondary text-white shadow-lg flex items-center justify-center hover:scale-110 transition-transform duration-200"
            data-umami-event="toggle_contact_popup">
            <Icon icon="mdi:email" class="text-2xl" />
        </button>
    </div>
</template>

<script setup>
import config from '@/config';
import { onMounted, onUnmounted, ref } from 'vue';

const isOpen = ref(false);
const captchaWidget = ref(null);

const handleOpenContact = () => {
    isOpen.value = true;
};

onMounted(async () => {
    window.addEventListener('open-contact', handleOpenContact);

    const { FriendlyCaptchaSDK } = await import('https://cdn.jsdelivr.net/npm/@friendlycaptcha/sdk@0.1.36/sdk.min.js');
    const sdk = new FriendlyCaptchaSDK();
    sdk.createWidget({
        element: captchaWidget.value,
        sitekey: config.friendlyCaptchaSitekey
    });
});

onUnmounted(() => {
    window.removeEventListener('open-contact', handleOpenContact);
});

const SendMailURL = ref(config.sendMailAPIUrl);
const formMessage = ref({
    message: '',
    isError: false
});
const fields = ref({
    email: { value: '', error: '' },
    subject: { value: '', error: '' },
    message: { value: '', error: '' },
    captcha: ''
});

const validateEmail = (value) => {
    if (value?.trim() === '') {
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
    if (value?.trim() === '') {
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
    if (value?.trim() === '') {
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
    }
    console.error('Window object is not defined (e.g., during SSR)');
    return '';
};

const clearForm = () => {
    fields.value.email.value = '';
    fields.value.email.error = '';
    fields.value.subject.value = '';
    fields.value.subject.error = '';
    fields.value.message.value = '';
    fields.value.message.error = '';
    fields.value.captcha = '';
    isLoading.value = false;
};

const validateCaptcha = (captchaInput) => {
    fields.value.captcha = captchaInput?.value;

    if (!fields.value.captcha || fields.value.captcha === '.UNFINISHED' || fields.value.captcha === '.ERROR') {
        formMessage.value = {
            message: 'Failed to send message : Impossible to valid captcha',
            isError: true
        };
        return false;
    }
    return true;
};

const validateForm = () => {
    const validityEmail = validateEmail(fields.value.email.value);
    const validitySubject = validateSubject(fields.value.subject.value);
    const validityMessage = validateMessage(fields.value.message.value);
    const validityCaptcha = validateCaptcha(captchaWidget.value?.querySelector('input[name="frc-captcha-response"]'));
    return validityEmail && validitySubject && validityMessage && validityCaptcha;
};

const submitForm = () => {
    formMessage.value.isError = false;
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
            subject: fields.value.subject.value,
            message: fields.value.message.value,
            userInfo: {
                userAgent: userAgent.value || '',
                userEmail: fields.value.email.value || '',
            },
            captchaResponse: fields.value.captcha || '',
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

<style scoped>
.contact-popup-enter-active,
.contact-popup-leave-active {
    transition: all 0.25s ease;
}

.contact-popup-enter-from,
.contact-popup-leave-to {
    opacity: 0;
    transform: translateY(12px) scale(0.95);
}
</style>
