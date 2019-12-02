import React from 'react';
import { Card, CardContent, CardMedia } from '@material-ui/core';
import FormGroup from '@material-ui/core/FormGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Switch from '@material-ui/core/Switch';
import Icon from '@mdi/react';
import { mdiCarSeat } from '@mdi/js';
import '../styles/Vehicle.css';

class VehicleCard extends React.Component {
    render() {
        const  vehicle = this.props.vehicle;
        const cardImgSrc = vehicle.image ? `data:image/png;base64,${vehicle.image}` : require("../assets/images/no_photo.jpg");

        return (
            <Card className="vehicleCard">
                <CardMedia
                    component="img"
                    alt="image of a vehicle"
                    height="180"
                    image={cardImgSrc}
                />
                <CardContent className="content">
                    <div className="model_seats">
                        <div className="modelName">
                            {vehicle.make}
                        </div>
                        <div className="seats">
                            <Icon path={mdiCarSeat} size={1}/>
                            <span>{vehicle.seats}</span>
                        </div>
                    </div>
                    <div className="description">
                        <p>{vehicle.description}</p>
                    </div>
                    <div className="contentFooter">
                        <p> Rs.{vehicle.rentPerDay}/Day </p>
                        <FormGroup>
                            <FormControlLabel
                                control={
                                    <Switch className="toggle"
                                        onChange={this.props.showConfirmationModal.bind(this)}
                                        checked={!vehicle.available}
                                        value={vehicle.plateNumber}
                                        color="secondary"
                                        disabled={!vehicle.available}
                                    />
                                }
                                label={vehicle.available ? 'Toggle to Book Now': 'Vehicle is already Booked'}
                            />
                        </FormGroup>
                    </div>
                </CardContent>
            </Card>

        );
    }
}

export default VehicleCard;