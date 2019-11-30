import React from 'react';
import { Card, CardHeader, CardContent } from '@material-ui/core';
import FormGroup from '@material-ui/core/FormGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Switch from '@material-ui/core/Switch';
import '../styles/Vehicle.css';
import axios from 'axios';

class Vehicle extends React.Component {
    render() {
        const  vehicle = this.props.vehicle;
        const rentVehicle = () => event => {
            console.log(event.target.value);
            // this.props.showConfirmationModal = true
            const plateNumber = event.target.value;
            if(window.confirm('Are you sure you want to book this vehicle?')) {
                axios.put(`http://localhost:8080/bookVehicle/${plateNumber}`).then(
                    () => {console.log('plate number', plateNumber, 'is booked'); },
                    (error) => {console.log(error); }
                )
            }
            
        };

        return (
            <Card className="vehicleCard">
                <CardHeader title={vehicle.type}/>
                {/* <CardMedia
                    component="img"
                    alt="image of a vehicle"
                    //height="140"
                    image="/no_photo.jpg"
                /> */}
                <CardContent className="description">
                    <p>{vehicle.make}</p>
                    <p> {vehicle.rentPerDay} </p>
                    <p>{vehicle.description}</p>
                    <FormGroup>
                        <FormControlLabel
                            control={
                            <Switch
                                onChange={rentVehicle()}
                                checked={!vehicle.available}
                                value={vehicle.plateNumber}
                                color="primary"
                                disabled={!vehicle.available}
                            />
                            }
                            label={vehicle.available ? 'Available': 'Booked'}
                        />
                    </FormGroup>
                </CardContent>
            </Card>

        );
    }
}

export default Vehicle;