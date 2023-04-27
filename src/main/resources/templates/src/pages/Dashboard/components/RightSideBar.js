import {useGetAllOffersQuery} from "../../../services/offer";
import {Loader} from "../../../components/Loader/Loader";
import {ErrorBox} from "../../../components/Box/Box";
import {UserPost} from "./UserPost";
import React from "react";
import logo from "../img/smartwork.svg";

const candy = "https://firebasestorage.googleapis.com/v0/b/cesam-website-374720.appspot.com/o/Pictures%2FUser%2Fcandyahogoudedji%40gmail.com.png?alt=media&token=6f132115-1634-4ec7-ab7d-91fbccbc1b2f";
const pierre = "https://firebasestorage.googleapis.com/v0/b/cesam-website-374720.appspot.com/o/Pictures%2FUser%2Fe.bertried%40gmail.com.png?alt=media&token=4732a887-bf98-4c3a-b865-20bda05d7add";

export function RightSideBar() {
    const {data: offers, isFetching, error} = useGetAllOffersQuery();
    const numberOfRandomOffer = 2;
    const content = function () {
        if (isFetching)
            return <Loader/>
        if (error) {
            console.log("error", error)
            return <ErrorBox message={error.error}/>
        }
        /* Select random offers  in offers.data */
        const randomOffers = [];
        /* Deep copy of offers.data */
        let offersToPush = offers.data.slice();

        for (let i = 0; i < numberOfRandomOffer; i++) {
            let index = Math.floor(Math.random() * offers.data.length)
            randomOffers.push(offersToPush.splice(index, 1)[0])

        }
        console.log(randomOffers)
        return randomOffers.map(
            (offer) => <div>
                <div className="d-flex user back-hover">
                    <img
                        className="rounded-circle"
                        src={offer.picture}
                        alt="profile picture"
                    />
                    <div>
                        <h6>{offer.title}</h6>
                        <span>{offer.type}</span>
                    </div>
                </div>
            </div>
        )
    }
    return (
        <div className="col-lg-3 col-12 rightsidebar">
            <div className="card">
                <h6>Offre suggéré</h6>
                {content()}
            </div>
            <div className="card">
                <div className="d-flex user">
                    <img
                        className="rounded-circle"
                        src={logo}
                        alt="profile picture"
                    />
                    <button className="submit-btn btn btn-sm text-white">Nous contacter</button>


                </div>
            </div>
        </div>

    )
}