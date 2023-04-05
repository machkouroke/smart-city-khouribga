import {createSlice} from "@reduxjs/toolkit";
import {userLogin} from "../../thunks/login";

const userToken = localStorage.getItem('userToken')
    ? localStorage.getItem('userToken')
    : null


const initialState = {
    loading: false,
    userToken,
    error: null,
    success: false,
}
const Auth = createSlice(
    {
        name: 'auth',
        initialState,
        reducers: {
            logout: (state) => {
                localStorage.removeItem('userToken') // deletes token from storage
                state.loading = false
                state.userInfo = null
                state.userToken = null
                state.error = null
                state.success = false
            },

        },
        extraReducers: {
            // login user
            [userLogin.pending]: (state) => {
                state.loading = true
                state.error = null
            },
            [userLogin.fulfilled]: (state, {payload}) => {
                state.loading = false
                state.error = null
                state.success = true
                state.userToken = payload['auth_token']
            },
            [userLogin.rejected]: (state, {payload}) => {
                state.loading = false
                state.success = false
                state.error = payload
            },
        }
    }
)

export const {logout} = Auth.actions
export default Auth.reducer;