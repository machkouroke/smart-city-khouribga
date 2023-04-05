// authActions.js
import {createAsyncThunk} from "@reduxjs/toolkit";
import {login} from "../api/auth";

export const userLogin = createAsyncThunk(
    'auth/login',
    async ({mail, password}, {rejectWithValue}) => {
        try {
            // configure header's Content-Type as JSON

            const data = await login(mail, password)
            // store user's token in local storage
            localStorage.setItem('userToken', data["auth_token"])
            return data
        } catch (error) {
            // return custom error message from API if any
            if (error.response && error.response.data.message) {
                return rejectWithValue(error.response.data.message)
            } else {
                return rejectWithValue(error.message)
            }
        }
    }
)