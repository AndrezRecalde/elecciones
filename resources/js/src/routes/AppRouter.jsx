import { Route, Routes } from "react-router-dom";
import { PublicRoutes } from "./public/PublicRoutes";
import { PrivateRoutes } from "./private/PrivateRoutes";
import { PrivatePages } from "./private/PrivatePages";
import { AuthenticationPage } from "../pages";
import { useAuthStore } from "../hooks";
import { useEffect } from "react";

export const AppRouter = () => {
    const { checkAuthToken } = useAuthStore();

    useEffect(() => {
        checkAuthToken();
    }, []);


    return (
        <Routes>
            <Route
                path="auth/login/*"
                element={
                    <PublicRoutes>
                        <Routes>
                            <Route path="/*" element={<AuthenticationPage />} />
                        </Routes>
                    </PublicRoutes>
                }
            />

            <Route
                path="/*"
                element={
                    <PrivateRoutes>
                        <PrivatePages />
                    </PrivateRoutes>
                }
            />
        </Routes>
    );
};
