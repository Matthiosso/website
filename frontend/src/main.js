import { createApp } from 'vue'
import App from './App.vue'
import { Icon } from '@iconify/vue' // to find icons, visit https://icon-sets.iconify.design
import Countup from 'vue-countup-v3';
import AOS from 'aos';
import 'aos/dist/aos.css';
AOS.init({duration: 1000});

createApp(App).component('Icon', Icon).component('Countup', Countup).mount('#app')
