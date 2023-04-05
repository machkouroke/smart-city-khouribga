import React, {useEffect} from "react";
import {useDispatch, useSelector} from "react-redux";
import {useNavigate} from "react-router-dom";
import {userLogin} from "../../../thunks/login";
import {useForm} from "react-hook-form";

export function Login() {
    const {loading, userToken, error, success} = useSelector((state) => {

        return {
            loading: state.authentication.loading,
            error: state.authentication.error,
            userToken: state.authentication.userToken,
            success: state.authentication.success
        };
    });
    const navigator = useNavigate()
    const dispatch = useDispatch()
    const {register, handleSubmit} = useForm()
    const submitForm = (data) => {
        dispatch(userLogin(data))
    }
    useEffect(() => {
        if (userToken && success) {
            navigator("/")
        }
    }, [navigator, userToken])
    return (
        <div className="form-container sign-in-container">
            <form onSubmit={handleSubmit(submitForm)}>
                <h1>Connexion</h1>

                <input type="mail" placeholder="Adresse mail" {...register("mail")}/>
                <input type="password" placeholder="Mot de passe" {...register("password")}/>
                <a href="#">Mot de passe oublié?</a>
                <button>Se connecter</button>
            </form>
        </div>
    )
}