import React from 'react';
import Button from '@material-ui/core/Button';
import DatePicker from '../components/DatePicker';
import '../styles/ConfirmModal.css';
import axios from 'axios';

export const ConfirmModal = ({handleCancel, show, vehicle}) => {
    const showHideClassName = show ? "modal display-block": "modal display-none";
    const [disableConfirm, setDisableConfirm] = React.useState(true);
    const [pickUpDate, setPickUpDate] = React.useState(new Date());
    const [dropOffDate, setDropOffDate] = React.useState(new Date());

    const handlePickUpDateChange = date => {
        setPickUpDate(date);
        date.getDate() < dropOffDate.getDate() ? setDisableConfirm(false): setDisableConfirm(true);
    };
    
    const handleDropOffDateChange = date => {
        setDropOffDate(date);
        pickUpDate.getDate() < date.getDate() ? setDisableConfirm(false): setDisableConfirm(true);
    };  

    const confirmBooking = () => {
        if(vehicle.plateNumber) {
          const plateNumber = vehicle.plateNumber;
          
          function convert(str) {
            var date = new Date(str),
              mnth = ("0" + (date.getMonth() + 1)).slice(-2),
              day = ("0" + date.getDate()).slice(-2);
            return [ day, mnth, date.getFullYear()].join("-");
          }
    
          const pickUp = convert(pickUpDate);
          const dropOff = convert(dropOffDate);
    
          console.log(plateNumber, pickUp, dropOff);
            
            axios.put(`http://localhost:8080/bookVehicle/${plateNumber}`).then(
                    () => {
                        console.log('plate number', plateNumber, 'is booked');
                    },
                    (error) => {console.log(error); }
                )
        }
      }

    return (
        <div className={showHideClassName}>
            <section className="modal-main">
                <DatePicker label="Pick Up Date" handleDateChange={handlePickUpDateChange.bind(this)} minDate={new Date()} setSelectedDate={pickUpDate}></DatePicker>
                <DatePicker label="Drop Off Date" handleDateChange={handleDropOffDateChange.bind(this)}  minDate={pickUpDate} setSelectedDate={dropOffDate}></DatePicker>
                <div className="message">
                    <span>(You must atleast book a vehicle for a day)</span>
                </div>
                <div className="btn">
                    <Button  color="secondary" onClick={handleCancel}>
                        Cancel
                    </Button>
                    <Button color="primary" onClick={confirmBooking} disabled={disableConfirm}>
                        Confirm
                    </Button>
                </div> 
            </section>
            
        </div>
    )
}