import '../style/scss/style.scss';
import {LeftSidebar} from "../components/LeftSidebar";
import {NavBar} from "../components/NavBar";
import React from "react";
import {UserEditBlock} from "../components/UserEditBlock";

export function EditProfile(props) {
    console.log(props.data);
    return (
        <div className={"dashboard"}>

            <NavBar/>

            <div className="container">
                <div className="row">
                    <LeftSidebar activeNav={"/edit_profile"}
                    />
                    <div className="col-lg-6 col-12 timeline">

                        {/* Boucle sur les posts */}
                        <UserEditBlock />

                    </div>

                </div>
            </div>
        </div>
    )
}

