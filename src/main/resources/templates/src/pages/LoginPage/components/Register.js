import React from "react";

export function Register() {
    return (
        <div className="form-container sign-up-container p-1 ">
            <form action="#">
                <h1>Inscription</h1>
                <div className={"w-100 d-flex "}>
                    <input type="text" className={"mr-1"} placeholder="Nom"/>
                    <input type="text" placeholder="Prénom"/>
                </div>
                <input type="email" placeholder="Email"/>
                <div className={"w-100 d-flex "}>
                    <input type="file" className={"mr-1"} placeholder="Votre cv"/>
                    <input type="file" placeholder="Votre phot"/>
                </div>

                <input type="password" placeholder="Mot de passe"/>
                <button>S'inscrire</button>
            </form>
        </div>
    )
}