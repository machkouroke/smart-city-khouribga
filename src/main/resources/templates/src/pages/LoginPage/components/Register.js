import React, {useEffect, useState} from "react";
import {useForm} from "react-hook-form";
import {useDispatch, useSelector} from "react-redux";
import {userLogin} from "../../../thunks/login";
import {useNavigate} from "react-router-dom";
import {registerUser} from "../../../thunks/register";

export function Register() {
    const {loading, userToken, error, success} = useSelector(
        (state) => {
            return {
                loading: state.registration.loading,
                userToken: state.registration.userToken,
                error: state.registration.error,
                success: state.registration.success
            }
        }
    )
    const [credentials, setCredentials] = useState()
    const dispatch = useDispatch()

    const navigator = useNavigate()
    const {register, handleSubmit} = useForm();
    useEffect(() => {
        // login user if registration was successful
        if (success) {
            dispatch(userLogin(credentials))
            navigator('/')
        }
        // redirect authenticated user to profile screen
        if (userToken) {
            navigator('/')
        }
    }, [navigator, userToken, success])
    const submitForm = (data) => {
        console.log(data)
        console.log("submit")
        dispatch(registerUser(data))
        setCredentials({
            mail: data.mail,
            password: data.password
        })
    }
    return (
        <div className="form-container sign-up-container  ">
            <form onSubmit={handleSubmit(submitForm)}>
                <h1>Inscription</h1>
                <div className={"w-100 d-flex "}>
                    <input type="text" className={"mr-1"} placeholder="Nom" {...register("name")}/>
                    <input type="text" placeholder="Prénom" {...register("surname")}
                    />
                </div>
                <input type="email" placeholder="Email" {...register("mail")}/>
                <div className={"w-100 d-flex "}>
                    <input type="file" className={"mr-1"} placeholder="Votre cv" {...register("cv")}/>
                    <input type="file" placeholder="Votre photo" {...register("photo")}/>
                </div>

                <input type="password" placeholder="Mot de passe" {...register("password")}/>
                <button>S'inscrire</button>
            </form>
        </div>
    )
}