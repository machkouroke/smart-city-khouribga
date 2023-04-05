import './App.css';
import React from "react";
import {Main} from "./pages/Dashboard/pages/Main";

import {BrowserRouter, Routes, Route} from "react-router-dom";
import {EditProfile} from "./pages/Dashboard/pages/EditProfile";
import {LoginPage} from "./pages/LoginPage/pages/LoginPage";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Main data="all"/>}/>


                <Route path="/applied_offer" element={<Main data="applied"/>}/>
                <Route path="/edit_profile" element={<EditProfile />}/>
                <Route path="/login" element={<LoginPage />}/>
                <Route path="*" element={<div><h1 className={"text-center"}>Page Not Found</h1></div>}/>
            </Routes>
        </BrowserRouter>


    );
}

export default App;
