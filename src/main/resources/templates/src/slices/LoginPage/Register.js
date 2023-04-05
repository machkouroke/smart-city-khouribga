import {createSlice} from "@reduxjs/toolkit";
import {registerUser} from "../../thunks/register";

const userToken = localStorage.getItem('userToken')
    ? localStorage.getItem('userToken')
    : null

const Register = createSlice(
    {
        name: 'Register',
        initialState: {
            loading: false,
            userToken,
            error: null,
            sucess: false,
        },
        reducers: {},
        extraReducers: {
            // register user
            [registerUser.pending]: (state) => {
                state.loading = true
                state.error = null
            },
            [registerUser.fulfilled]: (state) => {
                state.loading = false
                state.success = true // registration successful
            },
            [registerUser.rejected]: (state, {payload}) => {
                state.loading = false
                state.error = payload
            },
        }

    }
)



export default Register.reducer;
