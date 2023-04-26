import React from "react";

export function SucessBox({message, className}) {
    return <div className={`alert alert-success text-center text-black-50 ${className}`} role={"alert"}>
        {message}
    </div>
}
export function ErrorBox({message, className}) {
    return <div className={`alert alert-danger text-center text-black-50 ${className}`} role={"alert"}>
        {message}
    </div>
}
export function InfoBox({message, className}) {
    return <div className={`alert alert-info text-center text-black-50 ${className}`} role={"alert"}>
        {message}
    </div>
}
