<script setup>
import { reactive } from "vue"
let accountInfo = reactive({ "Name": "Zzz", "PhoneNumber": "18888888888888", "E-mail": "xxxxxxx@qq.com", "Level": 1 })
</script>

<template>
    <div class="content">
        <h1 class="title">Account</h1>
        <div class="info">
            <h1>Account Information</h1>
            <div class="account-info">
                <div v-for="(value, key) in accountInfo" :key="key" class="accountInfo-item">
                    <h2>{{ key }}</h2>
                    <p>{{ value }}</p>
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

.account-info {
    display: flex;
    flex-direction: column;
    flex-grow: 1;
    padding: 5%;
    gap: 20px;
    border-radius: 10px;
    background-color: #F7FAFC;
    box-shadow: 0 0 10px var(--shadow-color);
}

.accountInfo-item {
    display: flex;
    flex-direction: column;
    gap: 10px;
}

.accountInfo-item p {
    font-size: 1.5rem;
}
</style>