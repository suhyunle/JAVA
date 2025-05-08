import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/axios"; // axios 인스턴스 가져오는 것 맞지?

function Login() {
  const [email, setEmail] = useState("");
  const [passwd, setPasswd] = useState("");
  const navigate = useNavigate();

  const loginHandler = async () => {
    if (!email || !passwd) {
      alert("이메일과 비밀번호를 모두 입력하세요.");
      return;
    }

    try {
      // 로그인 API 호출 (백엔드 URL 맞게 수정해야 함)
      const response = await api.post('/api/v1/login', {
        email,
        password: passwd,
      });

      console.log("로그인 성공:", response.data);

      // 받은 accessToken을 localStorage에 저장
      localStorage.setItem("accessToken", response.data.accessToken);

      alert("로그인 성공!");
      navigate("/home"); // 로그인 성공 시 페이지 이동 (경로는 수정 가능)
    } catch (error) {
      console.error("로그인 실패:", error);
      alert("로그인 실패. 다시 시도하세요.");
    }
  };

  return (
    <div>
      <h2>로그인</h2>

      <input
        type="text"
        placeholder="이메일을 입력하세요"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <br/>
      <input
        type="password"
        placeholder="비밀번호를 입력하세요"
        value={passwd}
        onChange={(e) => setPasswd(e.target.value)}
      />
      <br />
      <button onClick={loginHandler}>로그인</button>
    </div>
  );
}

export default Login;
