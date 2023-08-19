import { Button, Group } from "@mantine/core";

export const BtnSubmit = ({ title, icon: Icon, btnDisabled = false, fullWidth = false }) => {
    return (
        <Group position="center" mt="sm" mb="lg">
            <Button
                disabled={btnDisabled}
                fullWidth={fullWidth}
                variant="filled"
                color="indigo.7"
                type="submit"
                leftIcon={<Icon />}
                size="md"
            >
                {title}
            </Button>
        </Group>
    );
};
