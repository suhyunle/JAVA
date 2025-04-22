import React from "react";

const imgStyle ={
    image :{
        width :50,
        height:50,
        borderRadius:25
    }

};
function Avatar(props) {
    return (
        <img    src="https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png"
                style ={imgStyle.image}/> 
        
    );

}

export default Avatar;