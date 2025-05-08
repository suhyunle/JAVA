import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import Login from '../../Login';
import LoginOK from '../../LoginOK'; // 정확히 LoginOK.jsx와 파일명 일치해야 합니다

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/loginok" element={<LoginOK />} />
      </Routes>
    </Router>
  );
}

export default App;
