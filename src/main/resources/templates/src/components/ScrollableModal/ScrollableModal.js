import s from "./style.module.scss";
import {Box, IconButton} from "@material-ui/core";
import Modal from "@material-ui/core/Modal";
import CloseIcon from '@material-ui/icons/Close';

function ScrollableModal({children, ...props}) {
    const style = {
        overflow: "auto"
    }

    return (
        <Modal {...props} style={style}>


            <Box className={s.modalite}>
                <Box style={{
                    position: "relative"
                }}>
                    <IconButton  onClick={props.onClose}
                                 className={s.closeIcon}
                    >
                        <CloseIcon/>
                    </IconButton>
                </Box>
                {children}
            </Box>
        </Modal>
    );

}

export default ScrollableModal;