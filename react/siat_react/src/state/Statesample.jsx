import React, { useState, useEffect } from "react";

const CAPACITY = 10;

function Statesample() {
  const [cnt, setCnt] = useState(0);
  const [isFull, setIsFull] = useState(false);

  useEffect(() => {
    console.log(`현재 인원: ${cnt}`);
    setIsFull(cnt >= CAPACITY);
  }, [cnt]);

  const cntUpHandler = () => {
    if (cnt < CAPACITY) {
      setCnt(cnt + 1);
    }
  };

  const cntDownHandler = () => {
    if (cnt > 0) {
      setCnt(cnt - 1);
    }
  };

  return (
    <div>
      <p>현재 인원: {cnt}</p>
      <button onClick={cntUpHandler} disabled={isFull}>
        입장
      </button>
      <button onClick={cntDownHandler}>
        퇴장
      </button>
      {isFull && <p style={{ color: "red" }}>정원이 가득찼습니다</p>}
    </div>
  );
}

export default Statesample;
