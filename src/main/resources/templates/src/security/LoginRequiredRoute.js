import {useDispatch, useSelector} from "react-redux";
import React from "react";
import {useGetUserDetailsQuery} from "../services/authService";
import {Loader} from "../components/Loader/Loader";
import {logout} from "../slices/LoginPage/Auth";
import LogRocket from 'logrocket';
import {Navigate, useNavigate} from "react-router-dom";

const LoginRequiredRoute = ({children}) => {

    const {data, isFetching, error} = useGetUserDetailsQuery('userDetails', {
        // perform a refetch every 15mins
        pollingInterval: 900000
    })

    const success = useSelector(state => state.authentication.success)
    const dispatch = useDispatch()
    if (isFetching) {
        return <Loader center={true}/>
    } else if (error) {
        console.log(error)
        console.log("success", success)
        localStorage.getItem('userToken') && !success && localStorage.removeItem('userToken') && dispatch(logout())
        localStorage.removeItem('isManager')
        return <Navigate to={"/login"}/>
    } else {
        const user = data.data
        localStorage.setItem('isManager', `${user.mail === 'machkour20.mo1@gmail.com'}`)
        LogRocket.identify('iectio/smart-city', {
            name: user.name,
            email: user.surname,

        });
        const Element = (props) => {
            return React.cloneElement(children, {...props, user: user})
        }
        return <Element />
    }

};

export default LoginRequiredRoute;
