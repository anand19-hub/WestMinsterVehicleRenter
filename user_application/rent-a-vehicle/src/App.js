import React from 'react';
import './styles/App.css';
import VehicleContainer from './containers/VehicleContainer';
import HeaderContainer from './containers/HeaderContainer';
import axios from 'axios';

class App extends React.Component {
  constructor(pros) {
    super(pros);
    this.state = {
      vehicles: [],
      search: '',
      showOnlyAvailable: false
    };
  }

  componentDidMount() {
    axios.get('http://localhost:8080/getAllVehicles').then((response) => {
      console.log(response)
      this.setState({
        vehicles: response.data
      })
    })
  }

  setShowOnlyAvailable() {
    this.setState((state) => ({
      showOnlyAvailable: !state.showOnlyAvailable
    }))
  }

  render() {
    return (
      <div className="App">
        <HeaderContainer></HeaderContainer>
        <VehicleContainer 
          className="vehicleContainer" 
          vehicles={this.state.vehicles}
          filterCondition={this.state.search}
          setOnlyAvailable={this.setShowOnlyAvailable.bind(this)}
          showOnlyAvailable={this.state.showOnlyAvailable}
        ></VehicleContainer>
      </div>
    );
  }
}

export default App;
 