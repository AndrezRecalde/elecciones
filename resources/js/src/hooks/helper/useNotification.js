import { notifications } from "@mantine/notifications";

export const useNotification = () => {

    const viewNotificationNotResults = (title, message) => {
        notifications.show({
            title: title,
            message: message,
            styles: (theme) => ({
                root: {
                    backgroundColor: theme.colors.indigo[7],
                    borderColor: theme.colors.indigo[6],

                    "&::before": { backgroundColor: theme.white },
                },

                title: { color: theme.white },
                description: { color: theme.white },
                closeButton: {
                    color: theme.white,
                    "&:hover": {
                        backgroundColor: theme.colors.indigo[7],
                    },
                },
            }),
        });
    }

  return { viewNotificationNotResults }
}
