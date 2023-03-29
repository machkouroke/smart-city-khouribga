import {useNavigate} from "react-router-dom";
export function Menu({route, active, text}) {

    const navigation = useNavigate();
    const onClick = () => {
        navigation(route);
    }
    return (
        <button className={active && "active"} onClick={onClick}>
            <i className="far fa-newspaper"></i>{text}</button>
    )
}