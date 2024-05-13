import axios from 'axios';

const REST_API_BASE_URL = 'http://localhost:8080/api/medici';

//utilizzato in admin per visualizzare tutti i medici
export const listMedici = () => axios.get(REST_API_BASE_URL);
//utilizzato in admin per creare nuovi medici
export const createMedico = (medico) => axios.post(REST_API_BASE_URL, medico);
//utilizzato in admin e in viste per visualizzare il singolo medico 
export const getMedico = (id_medico) => axios.get(REST_API_BASE_URL + '/' + id_medico);
//utilizzato in admin e viste per modificare il singolo medico
export const updateMedico = (id_medico, medico) => axios.put(REST_API_BASE_URL + '/' + id_medico, medico);
//utilizato in admin per eliminare il singolo medico 
export const deleteMedico = (id_medico) => axios.delete(REST_API_BASE_URL + '/' + id_medico);

export const medicoByEmail = (email) => axios.get(REST_API_BASE_URL + '/email/' + email);