import { createStore } from 'redux';
import manageRentAVehicle from '../reducer/reducer';

export const store = createStore(manageRentAVehicle);

