import Active from './LoginPage/Active.js';
import Auth from "./LoginPage/Auth";
import Register from "./LoginPage/Register";
import {authApi} from "../services/authService";
import {offerApi} from "../services/offer";

export default {
    registration: Register,
    active: Active,
    authentication: Auth,
    [authApi.reducerPath]: authApi.reducer,
    [offerApi.reducerPath]: offerApi.reducer,
}