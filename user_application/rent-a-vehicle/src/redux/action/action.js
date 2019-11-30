export const SHOW_CONFIRMATION_MODAL = 'SHOW_CONFIRMATION_MODAL';
export const SET_VEHICLE_FILTERS = 'SET_VEHICLE_FILTERS';

export const FilterVehicles = {
    SHOW_ALL: 'SHOW_ALL',
    ONLY_AVAILABLE: 'ONLY_AVAILABLE',
    CAR_ONLY: 'CAR_ONLY',
    VAN_ONLY: 'VAN_ONLY',
    BIKE_ONLY: 'BIKE_ONLY'
}

export function setVehicleFilters(filter) {
    return {type: SET_VEHICLE_FILTERS, filter}
}

export function showConfirmationModal(confirm) {
    return {type: SHOW_CONFIRMATION_MODAL, confirm}
}