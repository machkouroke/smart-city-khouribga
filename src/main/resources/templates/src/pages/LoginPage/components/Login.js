import React from "react";

export function Login() {
    return (
        <div className="form-container sign-in-container">
            <form action="#">
                <h1>Connexion</h1>

                <input type="email" placeholder="Adresse mail"/>
                <input type="password" placeholder="Mot de passe"/>
                <a href="#">Mot de passe oublié?</a>
                <button>Se connecter</button>
            </form>
        </div>
    )
}