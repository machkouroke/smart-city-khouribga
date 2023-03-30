import React from "react";
import {useDispatch} from "react-redux";
import {loginButton, registerButton} from "../../../slices/LoginPage/Active";

export function Overlay() {
    const dispatch = useDispatch();

    return (
        <div className="overlay-container">
            <div className="overlay">
                <div className="overlay-panel overlay-left">
                    <h1>SmartCityWork</h1>
                    <p>La première plateforme de recherche d'emploi à Khouribga</p>
                    <button className="ghost" id="signIn"   onClick={() => dispatch(registerButton())}
                    >Se connecter</button>
                </div>
                <div className="overlay-panel overlay-right">
                    <h1 className={'text-white'}>Bon retour parmis nous</h1>
                    <p>Vous n'aviez pas encore de compte?</p>
                    <button className="ghost" id="signUp" onClick={() => dispatch(loginButton())}
                    >Créer un compte</button>
                </div>
            </div>
        </div>
    )
}