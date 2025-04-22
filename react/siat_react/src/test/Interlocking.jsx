import React from "react";
import api from "../api/axios";  // 상대 경로 수정: '../api/axios'로 설정

function Interlocking(props) {
  const btnHandler = async () => {
    try {
      console.log(">>>> btn click");
      const response = await api.get('/react/select');
      console.log("debug>>>>", response);
      console.log("debug>>>>", response.data);
    } catch (error) {
      console.error("API 요청 실패:", error);
    }
  };

  return (
    <div>
      <button onClick={btnHandler}>click</button>
    </div>
  );
}

export default Interlocking;

