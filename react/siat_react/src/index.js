
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Clock from './test/Clock'
import Avatar from './test/Avatar'
import Interlocking from './test/Interlocking'
import Statesample from './state/Statesample';


const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>
    <Clock />
    <Avatar />
  </React.StrictMode>
);


// const root= 


root.render(
  <Statesample/>
);


// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();  