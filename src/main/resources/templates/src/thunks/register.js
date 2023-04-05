import {createAsyncThunk} from '@reduxjs/toolkit'
import {register} from '../api/auth'

export const registerUser = createAsyncThunk(
    'auth/register',
    async ({name, surname, mail, password, cv, photo}, {rejectWithValue}) => {
        try {
            console.log("register thunk")
            const formData = new FormData()
            formData.append('name', name)
            formData.append('surname', surname)
            formData.append('mail', mail)
            formData.append('password', password)
            formData.append('cv', cv[0])
            formData.append('photo', photo[0])
            await register(formData)
        } catch (error) {
            // return custom error message from backend if present
            console.log(error)
            if (error.response && error.response.data.message) {
                return rejectWithValue(error.response.data.message)
            } else {
                return rejectWithValue(error.message)
            }
        }
    }
)