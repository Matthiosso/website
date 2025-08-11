import { createApp } from 'vue'
import App from './App.vue'
import { Icon } from '@iconify/vue' // to find icons, visit https://icon-sets.iconify.design

createApp(App).component('Icon', Icon).mount('#app')
