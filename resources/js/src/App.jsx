import { BrowserRouter } from "react-router-dom";
import { store } from "./store/store";
import { AppRouter } from "./routes/AppRouter";
import { Provider } from "react-redux";
import { MantineProvider } from "@mantine/core";
import { Notifications } from "@mantine/notifications";

export const App = () => {
    return (
        <MantineProvider withNormalizeCSS withGlobalStyles>
            <Notifications position="bottom-center" />
            <Provider store={store}>
                <BrowserRouter>
                    <AppRouter />
                </BrowserRouter>
            </Provider>
        </MantineProvider>
    );
};
