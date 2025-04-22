import React, { useState, useEffect } from "react";

const CAPACITY = 10; // 최대 수용 인원

function Statesample() {
  const [cnt, setCnt] = useState(0); // 현재 인원 수
  const [isFull, setIsFull] = useState(false); // 정원이 가득 찼는지 여부

  // cnt 값이 변경될 때마다 실행되는 useEffect
  useEffect(() => {
    console.log(`현재 인원: ${cnt}`);
    setIsFull(cnt >= CAPACITY); // 현재 인원이 최대 수용 인원 이상이면 정원이 가득 찬 것으로 처리
  }, [cnt]);

  // 입장 버튼 클릭 시 인원 수 증가
  const cntUpHandler = () => {
    if (cnt < CAPACITY) {
      setCnt(cnt + 1); // 현재 인원 수를 1 증가
    }
  };

  // 퇴장 버튼 클릭 시 인원 수 감소
  const cntDownHandler = () => {
    if (cnt > 0) {
      setCnt(cnt - 1); // 현재 인원 수를 1 감소
    }
  };

  return (
    <div style={{ textAlign: "center", padding: "20px" }}>
      <p>현재 인원: {cnt}</p> {/* 현재 인원 수 표시 */}

      {/* 버튼들 사이에 간격을 두고, 버튼을 가로로 정렬하기 위한 div */}
      <div style={{ display: "flex", gap: "20px", justifyContent: "center" }}>
        
        {/* 입장 버튼 */}
        <button
          onClick={cntUpHandler} // 입장 버튼 클릭 시 cntUpHandler 실행
          disabled={isFull} // 정원이 가득 차면 버튼 비활성화
          style={{
            padding: "10px 20px", // 버튼 크기 조정
            fontSize: "16px", // 글씨 크기
            backgroundColor: "#4CAF50", // 초록색 배경
            color: "white", // 글씨는 흰색
            border: "none", // 테두리 제거
            borderRadius: "5px", // 둥근 모서리
            cursor: isFull ? "not-allowed" : "pointer", // 정원이 가득 차면 마우스 커서를 비활성화 모양으로 변경
            opacity: isFull ? 0.6 : 1, // 정원이 가득 차면 버튼이 흐릿하게 보이도록 설정
            transition: "all 0.3s ease", // 부드러운 전환 효과
          }}
        >
          입장
        </button>

        {/* 퇴장 버튼 */}
        <button
          onClick={cntDownHandler} // 퇴장 버튼 클릭 시 cntDownHandler 실행
          style={{
            padding: "10px 20px", // 버튼 크기 조정
            fontSize: "16px", // 글씨 크기
            backgroundColor: "#f44336", // 빨간색 배경
            color: "white", // 글씨는 흰색
            border: "none", // 테두리 제거
            borderRadius: "5px", // 둥근 모서리
            cursor: "pointer", // 마우스 커서는 기본 모양
            transition: "all 0.3s ease", // 부드러운 전환 효과
          }}
        >
          퇴장
        </button>
      </div>

      {/* 정원이 가득 찼을 때 표시되는 경고 메시지 */}
      {isFull && <p style={{ color: "red", fontWeight: "bold" }}>정원이 가득찼습니다</p>}
    </div>
  );
}

export default Statesample;
