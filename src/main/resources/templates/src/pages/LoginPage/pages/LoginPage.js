import React, {useEffect, useState} from "react";
import "../style/scss/style.scss";
import {Login} from "../components/Login";
import {Register} from "../components/Register";
import {Overlay} from "../components/Overlay";
import {useDispatch, useSelector} from "react-redux";

export function LoginPage() {
    const rightPanelActive = useSelector(state => state.active.rightPanelActive);
    const [rightPanelActiveClass, setRightPanelActiveClass] = useState('');
    useEffect(
        () => {
            if (rightPanelActive) {
                setRightPanelActiveClass('right-panel-active');
            } else {
               setRightPanelActiveClass('');
            }
        }
        , [rightPanelActive, rightPanelActiveClass])

    return (
        <div className={`login`}>
            <div className={`container ${rightPanelActiveClass}`} id="container">
                <Register/>
                <Login/>
                <Overlay/>
            </div>


        </div>

    )
}