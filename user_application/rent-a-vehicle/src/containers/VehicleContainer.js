import React, { Component } from 'react';
import Vehicle from '../components/Vehicle';
import '../styles/VehicleContainer.css';
import Container from '@material-ui/core/Container';
import FormGroup from '@material-ui/core/FormGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';

export class VehicleContainer extends Component {
    render() {
        const showAvaialbleOnly = this.props.showOnlyAvailable;
        const vehicles = showAvaialbleOnly ? this.props.vehicles.filter(vehicle => vehicle.available) : this.props.vehicles;
        
        return (
            <div className="body-container">
                <FormGroup row className="checkBoxForm">
                    <FormControlLabel
                        control={
                            <Checkbox 
                                checked={showAvaialbleOnly} 
                                onChange={this.props.setOnlyAvailable}
                                color="primary"
                            />
                        }
                        label="Show Only Available Vehicle"
                    />
                </FormGroup>

                <Container fixed className="vehicleContainer">
                    {vehicles.map(vehicle => 
                        <Vehicle 
                            key={vehicle.plateNumber} 
                            vehicle={vehicle}
                            showAvaialbleOnly={showAvaialbleOnly}
                        />
                    )}
                </Container>
            </div>
        )
    }
}

export default VehicleContainer;
