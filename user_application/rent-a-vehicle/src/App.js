import React from 'react';
import './styles/App.css';
import VehicleContainer from './containers/VehicleContainer';
import HeaderContainer from './containers/HeaderContainer';
import {ConfirmModal} from './modals/ConfirmModal';
import axios from 'axios';

class App extends React.Component {
  constructor(pros) {
    super(pros);
    this.state = {
      vehicles: [],
      search: '',
      showOnlyAvailable: false,
      showConfirmationModal: false,
      selectedVehicle: {}
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

  getSelectedVehicle(plate) {
    axios.get('http://localhost:8080/getAVehicle/' + plate).then((response) => {
      this.setState({
        selectedVehicle: response.data
      })
    });
  }

  setShowOnlyAvailable() {
    this.setState((state) => ({
      showOnlyAvailable: !state.showOnlyAvailable
    }))
  }

  setShowConfirmationModal(vehicle)  {
    this.setState({
      showConfirmationModal: true,
    })
    this.getSelectedVehicle(vehicle.target.value)
  }

  closeModal()  {
    this.setState({
      showConfirmationModal: false
    })
  }

  render() {
    return (
      <div className="App">
        <HeaderContainer>
        </HeaderContainer>

        <VehicleContainer 
          className="vehicleContainer" 
          vehicles={this.state.vehicles}
          filterCondition={this.state.search}
          setOnlyAvailable={this.setShowOnlyAvailable.bind(this)}
          showOnlyAvailable={this.state.showOnlyAvailable}
          setShowModal={this.setShowConfirmationModal.bind(this)}
          >  
        </VehicleContainer>

        <ConfirmModal
          handleCancel={this.closeModal.bind(this)}
          show={this.state.showConfirmationModal}
          vehicle={this.state.selectedVehicle}
          >
        </ConfirmModal>
      </div>
    );
  }
}

export default App;
 