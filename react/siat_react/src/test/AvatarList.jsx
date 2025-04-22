import React from "react";
import Avatar from "./Avatar";

const avatars =[
    {src:"https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png" ,
    msg : "수현"},
    {src : "https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png",
     msg: "씨앗"}
];

function AvatarList(){
    return(
        <div>
            {
                avatars.map((avatar)=>{
                    return(
                        <Avatar src ={avatar.src} alt ={avatar.msg}/>
                    );
                })
            }
            <Avatar />
            
        </div>

    );
}

export default AvatarList;

