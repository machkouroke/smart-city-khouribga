import {createSlice} from "@reduxjs/toolkit"

const Offers = createSlice(
    {
        name: 'offers',
        initialState: {
            allOffers: [],
            offers: [],
        },
        reducers: {
            initOffers: (state, action) => {

                state.allOffers = action.payload;
                state.offers = action.payload;
            },

            resetOffers: (state) => {
                state.offers = state.allOffers;
            },

            search: (state, term) => {
                state.rightPanelActive = true;

            }

        }
    }
)

export const {registerButton, loginButton} = Active.actions;

export default Active.reducer;