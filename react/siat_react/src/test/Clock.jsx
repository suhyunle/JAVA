import React from "react";


const msg ="시간은 몰라요";

function Clock (props){
    return(
        <div>
            <h1> 현재시간 </h1>
            <h2> {new Date().toLocaleTimeString()} </h2>
        </div>
    );

}

export default Clock;
