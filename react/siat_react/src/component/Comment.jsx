import React from "react";

const styles ={
    commentContainer :{
        margin :8,
        padding:8,
        dipaly:"flex",
        flexDirection :"row",
        border :"1px solid grey",
        borderRadius :16

    },
    commentContainer:{
        marginLeft:8,
        diplay :"flex",
        flexDirection :"column",
        justifyContent :"center"
    },
    nameTxt:{
        color:"black",
        fontSize: 15,
        fontWeight:"bold"

    },
    commentTxt:{
        color:"red",
        fontSize:16
    }

};

const comments=[
    {name :"임정섭", comment :"강사입니다."},
    {name :"박신형", comment : "학생 박신형입니다."},
    {name:"최여명", comment :" 졸립다 ~"}

];

function CommnetList (props){
    return(
        <div style ={styles.commentContainer}>
            <div>

            </div>
            <div style ="">
                <span style ={styles.nameTxt}>{props.name}</span>
                <span style ={styles.commentTxt}>{props.comment}</span>
            </div>
        </div>
    );
}



export default Comment;