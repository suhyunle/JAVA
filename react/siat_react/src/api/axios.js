import axios from 'axios'; // 외부 axios 라이브러리 가져오기

const api = axios.create({
  baseURL: 'http://localhost:8088',
  headers: {
    'Content-Type': 'application/json',
  },
});

export default api;
