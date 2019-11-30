import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Popper from '@material-ui/core/Popper';
import Fade from '@material-ui/core/Fade';

const useStyles = makeStyles(theme => ({
    paper: {
      border: '1px solid',
      padding: theme.spacing(1),
      backgroundColor: theme.palette.background.paper,
    },
  }));


class ConfirmBooking extends React.Component {

    render() {
        const classes = useStyles();
        const [anchorEl] = React.useState(null); // setAnchorEl
        const open = Boolean(anchorEl);
        const id = open ? 'transitions-popper' : undefined;

        return (
            <Popper id={id} open={open} anchorEl={anchorEl} transition>
                {({ TransitionProps }) => (
                <Fade {...TransitionProps} timeout={350}>
                    <div className={classes.paper}>The content of the Popper.</div>
                </Fade>
                )}
            </Popper>
        )
    }
}

export default ConfirmBooking;
