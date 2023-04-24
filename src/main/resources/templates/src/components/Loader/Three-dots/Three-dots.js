import "./style.scss"
const ThreeDots = ({center, className}) => {

    const cssClass = `three-dots ${center && "center"} ${className}`
    return (
        <div className={cssClass}>

        </div>
    );
};

export default ThreeDots;