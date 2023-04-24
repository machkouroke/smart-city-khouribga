import {useDispatch, useSelector} from "react-redux";
import {Route} from "react-router-dom";
import React from "react";
import {useGetUserDetailsQuery} from "../services/authService";
import {Loader} from "../components/Loader/Loader";
import {logout} from "../slices/LoginPage/Auth";
import LogRocket from 'logrocket';
import {useNavigate} from "react-router-dom";

const LoginRequiredRoute = ({component, ...rest}) => {

    const {data, isFetching, error} = useGetUserDetailsQuery('userDetails', {
        // perform a refetch every 15mins
        pollingInterval: 900000
    })
    const navigate = useNavigate();
    const success = useSelector(state => state.authentication.success)
    const dispatch = useDispatch()
    if (isFetching) {
        return <Loader center={true}/>
    } else if (error) {
        console.log(error)
        console.log("success", success)
        localStorage.getItem('userToken') && !success && localStorage.removeItem('userToken') && dispatch(logout())
        localStorage.removeItem('isManager')
        return navigate('/login')
    } else {
        const user = data.data
        localStorage.setItem('isManager', `${user.mail === 'machkour20.mo1@gmail.com'}`)
        LogRocket.identify('iectio/smart-city', {
            name: user.name,
            email: user.surname,

        });
        const createComponent = (props) => {
            return React.createElement(component, {
                ...props,
                user
            })
        }
        return (
            <Route {...rest} element={createComponent()}/>
        );
    }

};

export default LoginRequiredRoute;
