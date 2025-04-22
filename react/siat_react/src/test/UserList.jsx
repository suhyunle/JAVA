import React from "react";
import User from "./User";

const users=[
    {name:"임정섭",info:"강사"},
    {name:"이수현",info:"사람"},
]
function UserList(props) {
    return (
        <div>
            {
                users.map((user) => {
                    return (
                        <User name="user.name" info="user.info"/>
                    );
                })
            }
        </div>
    );
}

export default UserList;