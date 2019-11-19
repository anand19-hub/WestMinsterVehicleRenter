import React, { Component } from 'react'

import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import IconButton from '@material-ui/core/IconButton';
import Typography from '@material-ui/core/Typography';
import MenuIcon from '@material-ui/icons/Menu';
import SearchIcon from '@material-ui/icons/Search';

import '../styles/HeaderContainer.css';

export class HeaderContainer extends Component {
    render() {
        return (
            <div>
                <AppBar position="static" >
                    <Toolbar className="headerBar">
                        <IconButton
                            edge="start"
                            color="inherit"
                            aria-label="open drawer">
                            <MenuIcon />
                        </IconButton>

                        <Typography variant="h6" noWrap>
                            West Minster 'Rent-A-Vehicle'
                        </Typography>

                        <div className="searchDiv">
                            <div className="searchIcon">
                                <SearchIcon />
                            </div>
                            <input type="text" className="searchInput" placeholder="Search…"/>
                        </div>
                    </Toolbar>
                </AppBar>
            </div>
        )
    }
}

export default HeaderContainer
