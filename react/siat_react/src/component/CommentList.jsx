import React from "react";
import Comment from "./Comment"; // Comment 컴포넌트가 이미 잘 만들어졌다고 가정

const comments = [
    { name: "임정섭", comment: "강사입니다." },
    { name: "박신형", comment: "학생 박신형입니다." },
    { name: "최여명", comment: "졸립다 ~" }
];

function CommentList() {
    return (
        <div style={{ textAlign: "center" }}>
            {comments.map((c, index) => (
                <Comment key={index} name={c.name} comment={c.comment} />
            ))}
        </div>
    );
}

export default CommentList;
