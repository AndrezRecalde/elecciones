import { Navigate } from "react-router-dom";
import { useAuthStore } from "../../hooks";

export const PrivateRoutes = ({ children }) => {
    const { isLogin } = useAuthStore();

    return (isLogin)
        ? children
        : <Navigate to="/auth/login" />;
};
