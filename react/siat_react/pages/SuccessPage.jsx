import React, { useEffect } from 'react';
import api from './api'; // Adjust the import path based on your project structure

function SuccessPage(props) {
  useEffect(() => {
    console.log("debug >>>> useEffect");
    getList();
  }, []);

  const getList = async () => {
    try {
      console.log("debug >>>> getList endpoint / react / list");
      const response = await api.get("react/list");
      console.log("response", response);
      console.log(`response status: ${response.status}`);
      console.log("response data", response.data);
    } catch (error) {
      console.error("Error fetching data", error);
    }
  };

  return (
    <div align="center">
      000 로그인 성공하셨습니다....
      <table className="table">
        {/* Add table content here */}
      </table>
    </div>
  );
}

export default SuccessPage;
