import axios from 'axios';

const REST_API_BASE_URL = 'http://localhost:8080/api/appuntamenti';

export const listAppuntamenti = () => axios.get(REST_API_BASE_URL);

export const createAppuntamento = (appuntamento) => axios.post(REST_API_BASE_URL, appuntamento);

export const getAppuntamento = (id_app) => axios.get(REST_API_BASE_URL + '/' + id_app);

export const updateAppuntamento = (id_app, appuntamneto) => axios.put(REST_API_BASE_URL + '/' + id_app, appuntamneto);

export const deleteAppuntamento = (id_app) => axios.delete(REST_API_BASE_URL + '/' + id_app);

export const listAppuntamentiMedico = (id_medico) => axios.get(REST_API_BASE_URL + '/medico/' + id_medico);

export const listAppuntamentiPaziente = (id_paziente) => axios.get(REST_API_BASE_URL + '/paziente/' + id_paziente);