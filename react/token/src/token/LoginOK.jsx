import React, { useState } from "react";
import api from "../api/axios";
import { useNavigate } from "react-router-dom";

function LoginOk(props) {
    const navigate = useNavigate();

    // 통신 요청 버튼 클릭 시 처리하는 함수
    const btnHandler = async () => {
        console.log(">>>>>> btnHandler 실행");

        const accessToken = localStorage.getItem("accessToken");
        console.log(">>>>>> accessToken:", accessToken);

        if (accessToken) {
            try {
                const response = await api.get('api/v1/hello', {
                    headers: { Authorization: `Bearer ${accessToken}` }
                });
                console.log(">>>>>> response:", response);
                // 성공 시 추가 로직 (예: 페이지 이동)
                // navigate("/some-path");
            } catch (error) {
                console.error("API 요청 오류:", error);
                // 에러 발생 시 처리 (예: 로그인 페이지로 이동)
                // navigate("/login");
            }
        } else {
            console.log("로그인된 사용자가 아닙니다.");
            // 로그인 페이지로 이동 등
            navigate("/login");
        }
    };

    // 로그아웃 처리 함수
    const logoutHandler = () => {
        localStorage.removeItem("accessToken");
        console.log("로그아웃 완료");
        navigate("/login");  // 로그아웃 후 로그인 페이지로 이동
    };

    return (
        <div>
            <h2>Hi~ 토큰 검증을 통한 사용자 처리</h2>
            <button onClick={btnHandler}>통신 요청</button>
            <button onClick={logoutHandler}>로그아웃</button>
        </div>
    );
}

export default LoginOk;
