import React from 'react';
import './styles/App.css';
import VehicleContainer from './containers/VehicleContainer';
import HeaderContainer from './containers/HeaderContainer';

class App extends React.Component {
  state = {
    vehicles: [
      {
        plateNumber: 18920,
        type: 'Car',
        make: 'Toyota'
      },
      {
        plateNumber: 78098,
        type: 'Car',
        make: 'BMW'
      }, 
      {
        plateNumber: 24290,
        type: 'Van',
        make: 'Some Brand'
      },
      {
        plateNumber: 67282,
        type: 'Motor Bike',
        make: 'Yamaha'
      },
      {
        plateNumber: 34292,
        type: 'Motor Bike',
        make: 'Bajaj'
      }
    ]
  };

  render() {
    return (
      <div className="App">
        <HeaderContainer></HeaderContainer>
        <VehicleContainer className="vehicleContainer" vehicles={this.state.vehicles}></VehicleContainer>
      </div>
    );
  }
}

export default App;
 