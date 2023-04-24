import axios from "axios";

import {BASE_URL} from "../config";

function login(mail, password) {
    const option = {
        headers: {
            "Content-Type": "application/json",
        }
    }
    const body = {
        mail: mail,
        password: password
    }
    const url = `${BASE_URL}/auth/login`
    return axios.post(url, body, option)
        .then(({data}) => {
            return data
        })
}

function logout(token) {
    const option = {
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${token}`
        }
    }

    const url = `${BASE_URL}/auth/logout`
    return axios.post(url, {}, option)
        .then(({data}) => {
            return data
        })
}

function register(user_data) {
    const url = `${BASE_URL}/Users`
    return axios.post(url, user_data)
        .then(({data}) => {
            return data
        })


}








export {login, logout, register,}