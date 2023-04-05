
export function CreatePost() {
    return (
        <div className="create-post d-flex flex-column card">
            <h6>Poster une offre d'emploi</h6>
            <div className="d-flex mb-2 mt-3">
                <input className="text-input" type="text" placeholder="Titre de votre offre"/>
            </div>
            <div className="d-flex mb-2 hide-show">
                <input className="text-input" type="text" placeholder="Domaine"/>
            </div>
            <div className="d-flex hide-show mb-2">
                <input className="text-input" type="text" placeholder="Nom de l'entreprise"/>
            </div>
            <div className="d-flex hide-show mb-2">
                <select className="text-input">
                    <option value="Stage">Stage</option>
                    <option value="Stage">CDI</option>
                </select>
            </div>
            <div className="d-flex hide-show mb-2">
                <textarea className="text-input" placeholder="Description" rows="1"></textarea>
            </div>
            <div className="submit-btn hide-show">
                <button className="btn btn-primary btn-sm ">Créer l'offre</button>
            </div>
        </div>

    )
}