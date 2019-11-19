import React from 'react';
import { Card, CardHeader, CardContent } from '@material-ui/core';

class Vehicle extends React.Component {
    render() {
        const vehicle = this.props.vehicle;
        return (
            <Card className="vehicleCard">
                <CardHeader title={vehicle.type}/>
                {/* <CardMedia/> */}
                <CardContent className="description">
                    <p>{vehicle.make}</p>
                </CardContent>
            </Card>
        );
    }
}

export default Vehicle;