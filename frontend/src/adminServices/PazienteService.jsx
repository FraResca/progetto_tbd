import axios from 'axios';

const REST_API_BASE_URL = 'http://localhost:8080/api/pazienti';

export const listPazienti = () => axios.get(REST_API_BASE_URL);

export const createPaziente = (pazienteDto) => axios.post(REST_API_BASE_URL, pazienteDto);

export const getPaziente = (id_paziente) => axios.get(REST_API_BASE_URL + '/' + id_paziente);

export const updatePaziente = (id_paziente, paziente) => axios.put(REST_API_BASE_URL + '/' + id_paziente, paziente);

export const deletePaziente = (id_paziente) => axios.delete(REST_API_BASE_URL + '/' + id_paziente);

export const pazienteByEmail = (email) => axios.get(REST_API_BASE_URL + '/email/' + email);