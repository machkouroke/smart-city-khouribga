import {createSlice} from "@reduxjs/toolkit"

const Active = createSlice(
    {
        name: 'active',
        initialState: {
            rightPanelActive: false,
        },
        reducers: {
            registerButton: (state) => {
                state.rightPanelActive = false;
            },
            loginButton: (state, action) => {
                state.rightPanelActive = true;
            }

        }
    }
)

export const {registerButton, loginButton} = Active.actions;

export default Active.reducer;