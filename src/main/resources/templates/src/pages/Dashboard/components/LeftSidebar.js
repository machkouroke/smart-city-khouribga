import {Menu} from "./Menu";


export function LeftSidebar({activeNav, user}) {
    const navElement = [
        {
            route: "/",
            text: "Offres d'emploi",
        },
        {
            route: "/edit_profile",
            text: "Modifier mon profil",
        },
        {
            route: "/applied_offer",
            text: "Offres postulé",
        }
    ].map((element) => {
        return Object.assign(element, {active: element.route === activeNav})
    })
    return (
        <div className="col-lg-3 col-12">
            {/*Left Sidebar*/}
            <section className="leftsidebar">
                <div className="d-flex user">
                    <img
                        className="rounded-circle"
                        src={user.picLink}
                        alt="profile picture"
                    />
                    <div>
                        <h6>{user.name} {user.surname}</h6>
                        <span
                        >Elève ingénieur</span
                        >
                    </div>
                </div>
                <div className="navigation">
                    {
                        navElement.map((element) =>
                            <Menu route={element.route} active={element.active} text={element.text}/>)
                    }

                </div>

                <div className="navbar-spacer"></div>
            </section>
        </div>
    )
}