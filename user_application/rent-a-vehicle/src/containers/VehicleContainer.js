import React, { Component } from 'react';
import Vehicle from '../components/Vehicle';
import '../styles/VehicleContainer.css';
import Container from '@material-ui/core/Container';

export class VehicleContainer extends Component {
    render() {
        const vehicles = this.props.vehicles;
        return (
            <div>
                <Container fixed className="vehicleContainer">
                    {vehicles.map(vehicle => <Vehicle key={vehicle.plateNumber} vehicle={vehicle}></Vehicle>)}
                </Container>
            </div>
        )
    }
}

export default VehicleContainer;
