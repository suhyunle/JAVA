import React, { useState } from "react";

function Counter(props) {
  const [cnt, setCnt] = useState(0);

  // 컴포넌트 내부에서 정의해야 cnt와 setCnt에 접근 가능
  const countHandler = () => {
    console.log("debug >>> btn click");
    setCnt(cnt + 1);
    console.log("debug >>> cnt value :", cnt);
  };

  return (
    <div>
      <p>사용자 클릭 횟수: {cnt}</p>
      <button onClick={countHandler}>상태관리</button>
    </div>
  );
}

export default Counter;
