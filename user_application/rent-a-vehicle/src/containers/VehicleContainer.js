import React, { Component } from 'react';
import VehicleCard from '../components/VehicleCard';
import '../styles/VehicleContainer.css';
import Container from '@material-ui/core/Container';
import FormGroup from '@material-ui/core/FormGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';

export class VehicleContainer extends Component {
    render() {
        const showAvaialbleOnly = this.props.showOnlyAvailable;
        const vehicles = showAvaialbleOnly ? this.props.vehicles.filter(vehicle => vehicle.available) : this.props.vehicles;
        const setShowConfirmationModal = this.props.setShowModal;
        return (
            <div className="body-container">
                <Container fixed className="vehicleContainer">
                    <div className="filterControllers">
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

                    </div>
                
                    <div className="vehicles">
                        {vehicles.map(vehicle => 
                            <VehicleCard 
                                key={vehicle.plateNumber} 
                                vehicle={vehicle}
                                showAvaialbleOnly={showAvaialbleOnly}
                                showConfirmationModal={setShowConfirmationModal}
                            />
                        )}
                    </div>
                </Container>

            </div>
        )
    }
}

export default VehicleContainer;
