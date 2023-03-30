const pierre = "https://firebasestorage.googleapis.com/v0/b/cesam-website-374720.appspot.com/o/Pictures%2FUser%2Fe.bertried%40gmail.com.png?alt=media&token=4732a887-bf98-4c3a-b865-20bda05d7add";

export function UserPost() {
    return (
        <div className="post card">
            {/*Post User*/}
            <div className="d-flex user">
                <img
                    className="rounded-circle"
                    src={pierre}
                    alt="profile picture"
                />
                <div>
                    <h6 className="text-center">Développeur Frontend</h6>
                    <span className="text-center">5 mins ago</span>
                    <span className="text-center">Contrat à durée indéterminé</span>

                </div>
                <a href="templates/src/components#">
                    <i className="fas fa-ellipsis-h"></i>
                </a>
            </div>

            <p>
                <h4 className="about">À propos de l'offre</h4>
                <span className="black">
                     Nous cherchons pour un stage PFE à partir du mois d'Avril, à faire participer un(e) jeune
                talentueux(se) lauréat(e) spécialisation web développement pour une période de 3mois sur Rabat pour
                la refonte de: www.empower.ma
                pour les intéressés habitant à Rabat merci d'adresser vos CV à contact@empower.ma
                </span>

            </p>


            {/*Post Actions */}
            <div className="d-flex post-actions">
                <button className="w-100 text-center"><i className="far fa-tiktok"></i>Postuler</button>

                <button className="w-100 text-center"><i className="far fa-thumbs-up"></i>120k Likes
                </button>
            </div>

        </div>
    )
}   