import { Button } from "@mantine/core";
import { IconPencilPlus } from "@tabler/icons-react";

export const BtnAdd = ({ texto, handleAction }) => {
    return (
        <Button
            color="indigo.7"
            onClick={(e) => handleAction(e)}
            variant="filled"
            radius="sm"
            leftIcon={<IconPencilPlus />}
        >
            {texto}
        </Button>
    );
};
