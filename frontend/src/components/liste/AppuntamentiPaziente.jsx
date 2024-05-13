
import React, { useEffect, useState } from 'react'
import { Grid } from '@mui/material'
import { listAppuntamentiPaziente, updateAppuntamento, deleteAppuntamento} from '../../services/AppuntamentiService'
import { useNavigate, useParams } from 'react-router-dom'

/*
questa � la homepage del utente base , al momento contiene un filtro per gli appuntamenti
la lista degli appuntamenti futuri e una serie di pulsanti che vanno alle altre pagine accessibili dal utente 
*/

const AppuntamentiPaziente = () => {

    const [appuntamenti, setAppuntamentiPaziente] = useState([])

    const navigator = useNavigate();

    const { idPaziente } = useParams();

    useEffect(() => {
        getAllAppuntamentiPaziente(idPaziente);
    }, [])

    function getAllAppuntamentiPaziente(idPaziente) {
        listAppuntamentiPaziente(idPaziente).then((response) => {
            setAppuntamentiPaziente(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function prenotaVisita() {
        navigator(`/menuVisite/${idPaziente}`)
    }

    function visualizzaReferti() {
        navigator(`/visualizzaCartella/${idPaziente}`)
    }

    function visualizzaProfilo() {
        navigator(`/edit-paziente/${idPaziente}`)
    }

    function cancellaAppuntamento(id_app) {
        deleteAppuntamento(id_app).then(() => {
            getAllAppuntamentiPaziente(idPaziente);
        })
    }

    function pagaAppuntamento(appuntamento) {
        appuntamento.pagato = true;
        updateAppuntamento(appuntamento.id_app, appuntamento).then(() => {
            getAllAppuntamentiPaziente(idPaziente);
        })
    }

    return (
        <div>
            <Grid container sx={{justifyContent: "space-between"} }>
                <Grid item xs={2.5}>
                    <div className='h-auto shadow-lg bg-white p-5 sticky top-5'>

                        <div className='spacy-y-4 mt-10'>
                            <button className='btn btn-info space-y-15 mt-2' onClick={() => prenotaVisita()}>Prenota</button>
                            <button className='btn btn-info space-y-15 mt-2' onClick={() => visualizzaReferti()}>Referti</button>
                            <button className='btn btn-info space-y-15 mt-2' onClick={() => visualizzaProfilo()}>Profilo</button>
                        </div>
                    </div>
                </Grid>
                    <Grid item xs={9}>
                        <h1 className='font-bold text-lg'>I tuoi appuntamenti</h1>
                        <table className='table table-striped table-bordered'>
                            <thead>
                                <tr>
                                        <th>Pagato</th>
                                        <th>Medico</th>
                                        <th>Vedi Medico</th>
                                        <th>Visita</th>
                                        <th>Slot</th>
                                        <th>Azioni</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    appuntamenti.map(appuntamento =>
                                        <tr key={appuntamento.id_app}>
                                            <td>{appuntamento.pagato ? 'Yes' : 'No'}</td>
                                            <td>{appuntamento.id_medico}</td>
                                            <td>
                                                <button className='btn btn-info' onClick={() => navigator(`/visualizzaMedico/${appuntamento.id_medico}/${idPaziente}`)}>Informazioni</button>
                                            </td>
                                            <td>{appuntamento.id_visita}</td>
                                            <td>{appuntamento.id_slot}</td>
                                            <td>
                                                <button className='btn btn-info' onClick={() => pagaAppuntamento(appuntamento)}>Paga</button>
                                                <button className='btn btn-danger' onClick={() => cancellaAppuntamento(appuntamento.id_app)}>Cancella</button>
                                            </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>
                </Grid>
            </Grid>
            
        

        </div>
    )
}

export default AppuntamentiPaziente