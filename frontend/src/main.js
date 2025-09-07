import { createApp } from 'vue'
import App from './App.vue'
import { createHead } from '@unhead/vue/client'
import { Icon } from '@iconify/vue' // to find icons, visit https://icon-sets.iconify.design
import Countup from 'vue-countup-v3';
import AOS from 'aos'; // for nice css animations
import 'aos/dist/aos.css';
AOS.init({duration: 1000});

const app = createApp(App);
const head = createHead();
app.use(head);
app.component('Icon', Icon)
app.component('Countup', Countup)
app.mount('#app')
