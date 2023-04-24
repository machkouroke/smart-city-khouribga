import "./style.scss"
const SimpleCircle = ({center, className}) => {

    const cssClass = `simple-circle ${center && "center"} ${className}`
    return (
        <div className={cssClass}>

        </div>
    );
};

export default SimpleCircle;