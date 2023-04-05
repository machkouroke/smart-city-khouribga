export function UserEditBlock() {
    return (
        <div>
            <div className="d-flex mb-2 mt-3">
                <input className="text-input" type="text" placeholder="Nom"/>
            </div>
            <div className="d-flex mb-2 mt-3">
                <input className="text-input" type="text" placeholder="Prénom"/>
            </div>
            <div className="d-flex mb-2 mt-3">
                <input className="text-input" type="mail" placeholder="mail"/>
            </div>
            <div className="d-flex mb-2 mt-3">
                <label htmlFor="cv" className="file-input">
                    <input id={"cv"}  type="file" placeholder="cv"/>
                </label>
            </div>
            <div className="submit-btn text-center pt-2">
                <button className="btn btn-primary btn-sm ">Modifier les informations</button>
            </div>
        </div>
    )
}