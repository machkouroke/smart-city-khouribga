import '../style/scss/styles.scss';
const candy = "https://firebasestorage.googleapis.com/v0/b/cesam-website-374720.appspot.com/o/Pictures%2FUser%2Fcandyahogoudedji%40gmail.com.png?alt=media&token=6f132115-1634-4ec7-ab7d-91fbccbc1b2f";

export function LeftSidebar() {
    return (
        <div className="col-lg-3 col-12">
            {/*Left Sidebar*/}
            <section className="leftsidebar">
                <div className="d-flex user">
                    <img
                        className="rounded-circle"
                        src={candy}
                        alt="profile picture"
                    />
                    <div>
                        <h6>Machkour Oke</h6>
                        <span
                        >Elève ingénieur</span
                        >
                    </div>
                </div>
                <div className="navigation">
                    <button className="active"><i className="far fa-newspaper"></i><a className="text-dark"
                                                                                      href="index.html">Offres
                        d'emploi</a></button>
                    <button><i className="far fa-user"></i><a className="text-dark" href="">Modifier mon
                        profil</a></button>

                    <button><i className="far fa-bookmark"></i><a className="text-dark"
                                                                  href="applied_offer.html">Offres
                        postulé</a></button>
                </div>

                <div className="navbar-spacer"></div>
            </section>
        </div>
    )
}