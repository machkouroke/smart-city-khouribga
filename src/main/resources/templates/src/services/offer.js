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
        getAllOffers: builder.query({
            query: () => ({
                url: '',
                method: 'GET',
            }),
        }),

        toggleReaction: builder.mutation({
            query: ({job_id, relation_type}) => ({
                url: `/reaction`,
                method: 'POST',
                body: {
                    job_id,
                    relation_type
                }
            })
        })
    })
})

export const {
    useGetAllOffersQuery,
    useToggleReactionMutation,
} = offerApi