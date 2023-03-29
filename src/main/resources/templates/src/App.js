import './App.css';
import React from "react";
import {Main} from "./components/Main";

import {BrowserRouter, Routes, Route} from "react-router-dom";
import {EditProfile} from "./components/EditProfile";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Main data="all"/>}/>
                <Route path="/applied_offer" element={<Main data="applied"/>}/>
                <Route path="/edit_profile" element={<EditProfile />}/>
                <Route path="*" element={<div><h1>Page Not Found</h1></div>}/>
            </Routes>
        </BrowserRouter>


    );
}

export default App;
