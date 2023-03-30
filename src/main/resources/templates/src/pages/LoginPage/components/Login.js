import React from "react";

export function Login() {
    return (
        <div className="form-container sign-in-container">
            <form action="#">
                <h1>Connexion</h1>
                <div className="social-container">
                    <a href="#" className="social"><i className="fab fa-facebook-f"></i></a>
                    <a href="#" className="social"><i className="fab fa-google-plus-g"></i></a>
                    <a href="#" className="social"><i className="fab fa-linkedin-in"></i></a>
                </div>
                <input type="email" placeholder="Email"/>
                <input type="password" placeholder="Password"/>
                <a href="#">Mot de passe oublié?</a>
                <button>Se connecter</button>
            </form>
        </div>
    )
}