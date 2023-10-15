import { Navigate } from "react-router-dom";
import { useAuthStore } from "../../hooks";

export const PublicRoutes = ({ children }) => {

    const { isLogin } = useAuthStore();

    const token = localStorage.getItem("eth_token");

    return (!token)
        ? children
        : <Navigate to="/home" />;
};
