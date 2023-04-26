import {createApi, fetchBaseQuery} from '@reduxjs/toolkit/query/react'
import {BASE_URL} from "../config";


export const userApi = createApi({
    reducerPath: 'userApi',
    baseQuery: fetchBaseQuery({
        baseUrl: `${BASE_URL}/Users`,
        prepareHeaders: (headers, {getState}) => {
            const token = getState().authentication.userToken
            if (token) {
                headers.set('Authorization', `Bearer ${token}`)
            }
            return headers
        },
    }),
    endpoints: (builder) => ({
        updateUser: builder.mutation({
            query: ({user_id, data}) => ({
                url: `/${user_id}`,
                method: 'PATCH',

                body: data
            }),
        }),
        getAllUsers: builder.query({
            query: () => ({
                url: '?type=cesamien',
                method: 'GET',
            }),
            headers: {
                'Content-Type': 'application/json',
            },
        }),
    })
})

export const {
    useUpdateUserMutation,
    useGetAllUsersQuery,
} = userApi