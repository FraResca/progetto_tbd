import axios from 'axios';

const REST_API_BASE_URL = 'http://localhost:8080/api/visite';

export const listVisite = () => axios.get(REST_API_BASE_URL);

export const getVisita = (id_visita) => axios.get(REST_API_BASE_URL + '/' + id_visita);

export const createVisita = (visita) => axios.post(REST_API_BASE_URL, visita);

export const updateVisita = (id_visita, visita) => axios.put(REST_API_BASE_URL + '/' + id_visita, visita);

export const deleteVisita = (id_visita) => axios.delete(REST_API_BASE_URL + '/' + id_visita);
