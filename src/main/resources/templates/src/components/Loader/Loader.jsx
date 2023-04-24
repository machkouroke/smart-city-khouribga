import SimpleCircle from "./Simple-circle/Simple-circle";
import LdsRing from "./Lds-ring/Lds-ring";
import Merge from "./Merge/Merge";
import ThreeDots from "./Three-dots/Three-dots";

export const Loader = ({center, color, kind, className}) => {
    const s = className || '';

    switch (kind) {
        case 'circle':
            return <SimpleCircle center={!!center} color={color} className={s}/>
        case 'lds-ring':
            return <LdsRing center={!!center} color={color} className={s}/>
        case 'merge':
            return <Merge center={!!center} color={color} className={s}/>
        case 'three-dots':
            return <ThreeDots center={!!center} color={color} className={s}/>
        default:
            return <LdsRing center={!!center} color={color} className={s}/>
    }

};