import React from "react";

function User(porps){
    return (

        <div>
            <span>{porps.name} </span>
            &nbsp;&nbsp;&nbsp;
            <span>{porps.info} </span>
        </div>

    );

}

export default User;