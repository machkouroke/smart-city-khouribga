import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {configureStore} from '@reduxjs/toolkit'
import {Provider} from 'react-redux';
import reducers from './slices/index';
import LogRocket from 'logrocket';
import {authApi} from "./services/authService";
import {offerApi} from "./services/offer";

LogRocket.init('iectio/smart-city');
const store = configureStore({
    reducer: reducers,
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware()
            .concat(authApi.middleware)
            .concat(offerApi.middleware)
})
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <Provider store={store}>
        <App/>
    </Provider>
);


reportWebVitals();
