<script setup>
import { reactive } from "vue"
let settingsInfo = reactive(["Alter Information", "History"])
</script>

<template>
    <div class="content">
        <h1 class="title">Settings</h1>
        <div class="info">
            <h1>Setting Options</h1>
            <div class="settings-info">
                <div v-for="key in settingsInfo" :key="key" class="settingsInfo-item">
                    <h2>{{ key }}</h2>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped>
.title {
    font-size: 3rem;
}

.content {
    width: 80%;
    height: auto;
    display: flex;
    flex-direction: column;
    gap: 5%;
    margin-right: 5%;
}

.info {
    display: flex;
    height: 100%;
    padding: 5%;
    flex-direction: column;
    gap: 5%;
    box-shadow: 0 0 10px var(--shadow-color);
    border-radius: 20px;
}

.settings-info {
    display: flex;
    flex-direction: column;
    flex-grow: 1;
    padding: 5%;
    gap: 20px;
    border-radius: 10px;
    background-color: #F7FAFC;
    box-shadow: 0 0 10px var(--shadow-color);
}

.settingsInfo-item {
    display: flex;
    flex-direction: column;
    gap: 10px;
}

.settingsInfo-item p {
    font-size: 1.5rem;
}
</style>