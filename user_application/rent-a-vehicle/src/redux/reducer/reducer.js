import {SET_VEHICLE_FILTERS, FilterVehicles, SHOW_CONFIRMATION_MODAL} from '../action/action';

const initialState = {
    vehicleFilter: FilterVehicles.SHOW_ALL,
    showConfirmationModal: false
}

export default function manageRentAVehicle(state = initialState, action) {
    switch(action.type) {
        case SET_VEHICLE_FILTERS:
            console.log(action);
            
            return {
                ...state,
                vehicleFilter: action.filter
            }
        case SHOW_CONFIRMATION_MODAL:
            return {
                ...state,
                showConfirmationModal: true
            }
        default:
            return state;
    }
}