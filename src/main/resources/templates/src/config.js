import process from "react-syntax-highlighter/.eslintrc";


const BASE_URL = process.env.REACT_APP_BASE_URL_LOCAL

const IS_PRODUCTION = process.env.REACT_APP_PRODUCTION === 'true'


export {BASE_URL, IS_PRODUCTION}