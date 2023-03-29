import React from 'react';
import '../style/scss/styles.scss';
export function NavBar() {

    return (
        <React.Fragment>
            <nav className="navbar navbar-expand-lg navbar-light">
                <div className="container">
                    <div className="container-fluid row">
                        <div className="col-lg-3 col-12 nav-brand">
                            <h6>SmartCityWork</h6>
                            <button
                                className="navbar-toggler"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#navbarToggler"
                                aria-controls="navbarToggler"
                                aria-expanded="false"
                                aria-label="Toggle navigation"
                            >
                                <i className="fas fa-bars"></i>
                            </button>
                        </div>
                        <div className="col-lg-9 col-12">
                            <div
                                className="collapse navbar-collapse"
                                id="navbarToggler"
                            >
                                <div className="row w-100">
                                    <div className="col-lg-8 col-12">
                                        <form className="d-flex">
                                            <input
                                                type="search"
                                                placeholder="Recherche une offre spécifique"
                                                aria-label="Search"
                                            />
                                            <button type="submit">
                                                <i className="fas fa-search"></i>
                                            </button>
                                        </form>
                                    </div>
                                    <div className="col-lg-4 col-12">
                                        <ul className="navbar-nav">
                                            <li>
                                                <a href="#"
                                                >Se déconnecter<i
                                                    className="fas fa-sign-out-alt"
                                                ></i
                                                ></a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
            <div className="navbar-spacer"></div>
        </React.Fragment>
    )
}