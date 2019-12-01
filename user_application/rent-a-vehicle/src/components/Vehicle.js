import React from 'react';
import { Card, CardHeader, CardContent, CardMedia } from '@material-ui/core';
import FormGroup from '@material-ui/core/FormGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Switch from '@material-ui/core/Switch';
import AirlineSeatReclineNormalIcon from '@material-ui/icons/AirlineSeatReclineNormal';
import '../styles/Vehicle.css';
import axios from 'axios';

class Vehicle extends React.Component {
    render() {
        const  vehicle = this.props.vehicle;
        const cardImgSrc = vehicle.image ? `data:image/png;base64,${vehicle.image}` : require("../assets/images/no_photo.jpg");
        const rentVehicle = () => event => {
            console.log(event.target.value);
            // this.props.showConfirmationModal = true
            const plateNumber = event.target.value;
            if(window.confirm('Are you sure you want to book this vehicle?')) {
                axios.put(`http://localhost:8080/bookVehicle/${plateNumber}`
                ).then(
                    () => {console.log('plate number', plateNumber, 'is booked'); },
                    (error) => {console.log(error); }
                )
            }
            
        };

        return (
            <Card className="vehicleCard">
                <CardHeader title={vehicle.type}/>
                <CardMedia
                    component="img"
                    alt="image of a vehicle"
                    //height="140"
                    image={cardImgSrc}
                />
                <CardContent className="description">
                    <AirlineSeatReclineNormalIcon/>
                    <p>Make: {vehicle.make}</p>
                    <p>Rent Per Day:  {vehicle.rentPerDay} </p>
                    <p>Description: {vehicle.description}</p>
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