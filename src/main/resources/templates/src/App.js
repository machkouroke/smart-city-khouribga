import './App.css';
import React from "react";
import {Main} from "./pages/Dashboard/pages/Main";

import {BrowserRouter, Routes, Route} from "react-router-dom";
import {EditProfile} from "./pages/Dashboard/pages/EditProfile";
import {LoginPage} from "./pages/LoginPage/pages/LoginPage";
import LoginRequiredRoute from "./security/LoginRequiredRoute";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={
                    <LoginRequiredRoute>
                        <Main data="all"/>
                    </LoginRequiredRoute>
                }/>


                <Route path="/applied_offer" element={
                    <LoginRequiredRoute>
                        <Main data="applied"/>
                    </LoginRequiredRoute>
                }/>
                <Route path="/edit_profile" element={
                    <LoginRequiredRoute>
                        <EditProfile/>
                    </LoginRequiredRoute>
                }/>
                <Route path="/login" element={<LoginPage/>}/>
                <Route path="*" element={<div><h1 className={"text-center"}>Page Not Found</h1></div>}/>
            </Routes>
        </BrowserRouter>


    );
}

export default App;
