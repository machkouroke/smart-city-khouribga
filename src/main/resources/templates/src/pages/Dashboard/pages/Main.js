import '../style/scss/style.scss';

import {LeftSidebar} from "../components/LeftSidebar";
import {CreatePost} from "../components/CreatePost";
import {UserPost} from "../components/UserPost";
import {RightSideBar} from "../components/RightSideBar";
import {NavBar} from "../components/NavBar";
import React from "react";
import {useGetAllOffersQuery} from "../../../services/offer";
import {Loader} from "../../../components/Loader/Loader";
import Roles from "../../../security/Roles";
import {ErrorBox} from "../../../components/Box/Box";
import {useGetPostulatedOffersQuery} from "../../../services/users";


export function Main({data, user}) {
    const useQuery = data === "all" ? useGetAllOffersQuery : useGetPostulatedOffersQuery;

    const {data: offers, isFetching, error} = useQuery();
    console.log(data)

    const content = function () {
        if (isFetching)
            return <Loader/>
        if (error) {
            console.log("error", error)
            return <ErrorBox message={error.error}/>
        }
        console.log(offers)
        return offers.data.map(
            (offer) => <UserPost offer={offer}/>
        )
    }

    return (
        <div className={"dashboard"}>

            <NavBar/>

            <div className="container">
                <div className="row">
                    <LeftSidebar activeNav={data === "all" ? "/" : "/applied_offer"} user={user}/>
                    <div className="col-lg-6 col-12 timeline">
                        {data === 'all' && user.role === Roles.Recruiter && <CreatePost/>}
                        {content()}
                    </div>
                    <RightSideBar/>
                </div>
            </div>
        </div>
    )
}

