import '../style/scss/style.scss';

import {LeftSidebar} from "../components/LeftSidebar";
import {CreatePost} from "../components/CreatePost";
import {UserPost} from "../components/UserPost";
import {RightSideBar} from "../components/RightSideBar";
import {NavBar} from "../components/NavBar";
import React from "react";

const pierre = "https://firebasestorage.googleapis.com/v0/b/cesam-website-374720.appspot.com/o/Pictures%2FUser%2Fe.bertried%40gmail.com.png?alt=media&token=4732a887-bf98-4c3a-b865-20bda05d7add";

export function Main(props) {
    const offers = [
        {
            picture: pierre,
            title: "Développeur Frontend",
            postedAt: "5 mins ago",
            location: "Rabat",
            type: "Contrat à durée indéterminé",
            description: " Nous cherchons pour un stage PFE à partir du mois d'Avril, à faire participer un(e) jeune\n" +
                "                talentueux(se) lauréat(e) spécialisation web développement pour une période de 3mois sur Rabat pour\n" +
                "                la refonte de: www.empower.ma\n" +
                "                pour les intéressés habitant à Rabat merci d'adresser vos CV à contact@empower.ma",
            domain: "Informatique",
            contact: "contact@empower.ma",
            tag: [
                "Développeur Frontend",
                "Web Dev",
                "Web Dev",
                "Web Dev",
                "Web Dev",
            ]
        }
    ]
    return (
        <div className={"dashboard"}>

            <NavBar/>

            <div className="container">
                <div className="row">
                    <LeftSidebar activeNav={props.data === "all" ? "/" : "/applied_offer"
                    }/>
                    <div className="col-lg-6 col-12 timeline">
                        <CreatePost/>
                        {/* Boucle sur les posts */}
                        {
                            offers.map(
                                (offer) => <UserPost offer={offer}/>
                            )
                        }


                    </div>
                    <RightSideBar/>
                </div>
            </div>
        </div>
    )
}

