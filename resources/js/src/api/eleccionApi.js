import axios from "axios";
import { getEnv } from "../helpers/getEnv";


const { VITE_APP_URL } = getEnv();

const eleccionApi = axios.create({
    baseURL: VITE_APP_URL
});

eleccionApi.interceptors.request.use(config => {
    config.headers = {
        ...config.headers,
        'Authorization' : 'Bearer ' + localStorage.getItem("eth_token"),
        "Accept": "application/json",
        //"Content-Type": "multipart/form-data"
    }
    return config;
});

export default eleccionApi;
