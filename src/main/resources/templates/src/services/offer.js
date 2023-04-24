import {createApi, fetchBaseQuery} from '@reduxjs/toolkit/query/react'
import {BASE_URL} from "../config";

export const offerApi = createApi({
    reducerPath: 'offerApi',
    baseQuery: fetchBaseQuery({
        baseUrl: `${BASE_URL}/offers`,
        prepareHeaders: (headers, {getState}) => {
            const token = getState().authentication.userToken
            if (token) {
                headers.set('Authorization', `Bearer ${token}`)
            }
            return headers
        },
    }),
    endpoints: (builder) => ({
        getUserDetails: builder.query({
            query: () => ({
                url: '/get_status',
                method: 'GET',
            }),
        }),
    })
})

export const {useGetUserDetailsQuery} = offerApi