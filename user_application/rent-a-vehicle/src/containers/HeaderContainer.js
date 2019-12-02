import React, { Component } from 'react'

import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';

import '../styles/HeaderContainer.css';

export class HeaderContainer extends Component {
    render() {
        return (
            <div>
                <AppBar position="sticky" >
                    <Toolbar className="headerBar">
                        <Typography variant="h6" noWrap>
                            West Minster 'Rent-A-Vehicle'
                        </Typography>
                    </Toolbar>
                </AppBar>
            </div>
        )
    }
}

export default HeaderContainer
