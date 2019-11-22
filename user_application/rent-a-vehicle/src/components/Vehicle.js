import React from 'react';
import { Card, CardHeader, CardContent } from '@material-ui/core';
import FormGroup from '@material-ui/core/FormGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Switch from '@material-ui/core/Switch';
import '../styles/Vehicle.css';

class Vehicle extends React.Component {
    render() {
        const  vehicle = this.props.vehicle;

        const rentVehicle = () => event => {
            console.log(event.target.value);
            
        };

        return (
            <Card className="vehicleCard">
                <CardHeader title={vehicle.type}/>
                {/* <CardMedia/> */}
                <CardContent className="description">
                    <p>{vehicle.make}</p>
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