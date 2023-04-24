import "./style.scss"
const Merge = ({center, className}) => {

    const cssClass = `merge ${center && "center"} ${className}`
    return (
        <div className={cssClass}>

        </div>
    );
};

export default Merge;