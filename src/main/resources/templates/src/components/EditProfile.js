import '../style/scss/styles.scss';
import {LeftSidebar} from "./LeftSidebar";
import {NavBar} from "./NavBar";
import React from "react";
import {UserEditBlock} from "./UserEditBlock";

export function EditProfile(props) {
    console.log(props.data);
    return (
        <React.Fragment>

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
        </React.Fragment>
    )
}

