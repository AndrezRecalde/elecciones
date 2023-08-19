import { Navigate } from "react-router-dom";
import { useAuthStore } from "../../hooks";

export const PublicRoutes = ({ children }) => {
    const { isLogin } = useAuthStore();
    return (!isLogin)
        ? children
        : <Navigate to="/home" />;
};
