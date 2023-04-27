import React from "react";
import s from "./style.module.scss"

function SearchComponents(props) {


    return (
        <div>
            <div className="post card">
                <div >
                    <form className="d-flex w-100">
                        <input
                            type="search"
                            placeholder="Recherche une offre spécifique"
                            aria-label="Search"
                            className={"form-control"}

                        />
                        <button type="submit" className={s.searchButton}>
                            <i className="fas fa-search"></i>
                        </button>
                    </form>
                </div>
            </div>
        </div>
    );

}

export default SearchComponents;