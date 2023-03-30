const candy = "https://firebasestorage.googleapis.com/v0/b/cesam-website-374720.appspot.com/o/Pictures%2FUser%2Fcandyahogoudedji%40gmail.com.png?alt=media&token=6f132115-1634-4ec7-ab7d-91fbccbc1b2f";
const pierre = "https://firebasestorage.googleapis.com/v0/b/cesam-website-374720.appspot.com/o/Pictures%2FUser%2Fe.bertried%40gmail.com.png?alt=media&token=4732a887-bf98-4c3a-b865-20bda05d7add";

export function RightSideBar() {
    return (
        <div className="col-lg-3 col-12 rightsidebar">
            <div className="card">
                <h6>Offre suggéré</h6>
                <a href="templates/src/components#">
                    <div className="d-flex user back-hover">
                        <img
                            className="rounded-circle"
                            src={pierre}
                            alt="profile picture"
                        />
                        <div>
                            <h6>Acteur Porno</h6>
                            <span>Freelance</span>
                        </div>
                    </div>
                </a>
                {/*<a href="#">*/}
                {/*    <div className="d-flex user back-hover">*/}
                {/*        <img*/}
                {/*            className="rounded-circle"*/}
                {/*            src="smart-front/src/assets/img/person3.jpg"*/}
                {/*            alt="profile picture"*/}
                {/*        />*/}
                {/*        <div>*/}
                {/*            <h6>Acteur Porno</h6>*/}
                {/*            <span>Freelance</span>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                {/*</a>*/}
                {/*<a href="#">*/}
                {/*    <div className="d-flex user back-hover">*/}
                {/*        <img*/}
                {/*            className="rounded-circle"*/}
                {/*            src="smart-front/src/assets/img/person4.jpg"*/}
                {/*            alt="profile picture"*/}
                {/*        />*/}
                {/*        <div>*/}
                {/*            <h6>Acteur Porno</h6>*/}
                {/*            <span>Freelance</span>*/}
                {/*        </div>*/}
                {/*    </div>*/}
                {/*</a>*/}

            </div>
            <div className="card">
                <div className="d-flex user">
                    <img
                        className="rounded-circle"
                        src={candy}
                        alt="profile picture"
                    />
                    <button className="submit-btn btn btn-sm text-white">Nous contacter</button>


                </div>
            </div>
        </div>

    )
}