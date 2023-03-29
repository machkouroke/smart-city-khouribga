import '../style/scss/styles.scss';
import {LeftSidebar} from "./LeftSidebar";
import {CreatePost} from "./CreatePost";
import {UserPost} from "./UserPost";
import {RightSideBar} from "./RightSideBar";
import {NavBar} from "./NavBar";
import React from "react";

export function Main(props) {
    console.log(props.data);
    return (
        <React.Fragment>

            <NavBar/>

            <div className="container">
                <div className="row">
                    <LeftSidebar activeNav={props.data === "all" ? "/" : "/applied_offer"
                    }/>
                    <div className="col-lg-6 col-12 timeline">
                        <CreatePost/>
                        {/* Boucle sur les posts */}
                        <UserPost/>

                    </div>
                    <RightSideBar/>
                </div>
            </div>
        </React.Fragment>
    )
}

