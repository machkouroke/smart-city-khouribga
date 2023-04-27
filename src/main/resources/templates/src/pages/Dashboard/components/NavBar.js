import React, {useState} from 'react';
import {useDispatch} from "react-redux";
import {logout} from "../../../slices/LoginPage/Auth"
import {useNavigate} from "react-router-dom";
import ScrollableModal from "../../../components/ScrollableModal/ScrollableModal";
import SearchComponents from "../../../components/SearchComponents/SearchComponents";


export function NavBar() {
    const dispatch = useDispatch();
    const navigator = useNavigate()
    const [open, setOpen] = useState(false);

    const handleClose = () => {
        setOpen(false);

    };


    const handleOpen = () => {

        setOpen(true);

    };

    const logoutUser = () => {
        dispatch(logout());
        navigator('/login', {replace: true})
    }

    return (
        <React.Fragment>
            <ScrollableModal
                onClose={handleClose}
                open={open}

            >
                <SearchComponents />
            </ScrollableModal>
            <nav className="navbar navbar-expand-lg navbar-light">
                <div className="container">
                    <div className="container-fluid row">
                        <div className="col-lg-3 col-12 nav-brand">
                            <div className="d-flex align-items-center">

                                <h6>SmartCityWork</h6>
                            </div>

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
                                                onClick={handleOpen}

                                            />
                                            <button type="submit">
                                                <i className="fas fa-search"></i>
                                            </button>
                                        </form>
                                    </div>
                                    <div className="col-lg-4 col-12">
                                        <ul className="navbar-nav">
                                            <li>
                                                <button onClick={logoutUser} className={"btn btn-danger"}>
                                                    Se déconnecter<i
                                                    className="ml-2 fas fa-sign-out-alt "
                                                ></i
                                                ></button>
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