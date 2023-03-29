import logo from './logo.svg';
import './App.css';
import React from "react";
import {NavBar} from "./components/NavBar";
import {Main} from "./components/Main";

function App() {
    return (
        <React.Fragment>
            <NavBar/>
            <Main/>
        </React.Fragment>

    );
}

export default App;
