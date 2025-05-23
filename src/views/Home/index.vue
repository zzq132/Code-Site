<script setup>

</script>

<template>
  <div class="container">
    <main class="main-page">
      <div class="content">
        <p>Code Site</p>
        <p>Learn Coding Effectively</p>
      </div>
      <RouterLink to="/learn" class="btn">Start</RouterLink>
      <div class="wave-wrapper">
        <div class="wave-inner">
          <svg class="wave" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
            <path fill="#0099ff" fill-opacity="1" d="M0,160L34.3,144C68.6,128,137,96,206,101.3C274.3,107,343,149,411,170.7C480,192,549,192,617,170.7C685.7,149,754,107,823,85.3C891.4,64,960,64,1029,101.3C1097.1,139,1166,213,1234,224C1302.9,235,1365,185,1405,178.5L1440,162.5
            L1440,320L1405.7,320C1371.4,320,1303,320,1234,320C1165.7,320,1097,320,1029,320C960,320,891,320,823,320C754.3,320,686,320,617,320C548.6,320,480,320,411,320C342.9,320,274,320,206,320C137.1,320,69,320,34,320L0,320Z"></path>
          </svg>
          <svg class="wave" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320">
            <path fill="#0099ff" fill-opacity="1" d="M0,162.5L34.3,144C68.6,128,137,96,206,101.3C274.3,107,343,149,411,170.7C480,192,549,192,617,170.7C685.7,149,754,107,823,85.3C891.4,64,960,64,1029,101.3C1097.1,139,1166,213,1234,224C1302.9,235,1371,181,1406,154.7L1440,128
            L1440,320L1405.7,320C1371.4,320,1303,320,1234,320C1165.7,320,1097,320,1029,320C960,320,891,320,823,320C754.3,320,686,320,617,320C548.6,320,480,320,411,320C342.9,320,274,320,206,320C137.1,320,69,320,34,320L0,320Z"></path>
          </svg>
        </div>
      </div>
    </main>
  </div>
</template>

<style scoped>
.container{
  height: 92vh;
}
.main-page{
  height: inherit;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}
.content{
  margin-top: auto;
}
.content p:nth-child(1){
  font-size: 15rem;
  font-weight: bolder;
  color: var(--theme-color);
}
.content p:nth-child(2){
  font-size: 4rem;
  font-weight: bold;
  text-align:center;
}
.btn{
  display: flex;
  align-items: center;
  justify-content: center;
  margin-top:50px;
  margin-bottom: auto;
  font-size: 3rem;
  font-weight: bold;
  color:white;
  width: 150px;
  height: 60px;
  border-radius: 20px;
  box-shadow: 0 10px 10px #dfdede;
  background-color: var(--theme-color);
}
.btn:hover{
  background-color: var(--theme-hover-color);
}
.wave-wrapper {
  width: 100%;
  height: 320px;
  overflow: hidden;
  position: relative;
}

.wave-inner{
  display: flex;
  width: 2880px;
  animation: wave 10s ease-in-out infinite alternate;
}

.wave {
  flex-shrink: 0;
  width: 1440px;
}

@keyframes wave {
  from{
    transform: translateX(0);
  }
  to{
    transform: translateX(-40%);
  }
}
</style>