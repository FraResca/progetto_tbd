import axios from 'axios';

const REST_API_BASE_URL = 'http://localhost:8080/api/slots';

export const listSlots = () => axios.get(REST_API_BASE_URL);

export const createSlots = (slots) => axios.post(REST_API_BASE_URL, slots);

export const getSlot = (id_slot) => axios.get(REST_API_BASE_URL + '/' + id_slot);

export const updateSlot = (id_slot, slot) => axios.put(REST_API_BASE_URL + '/' + id_slot, slot);

export const deleteSlot = (id_appuntamento) => axios.delete(REST_API_BASE_URL + '/' + id_appuntamento);

export const listFreeSlots = () => axios.get(REST_API_BASE_URL + '/free');

