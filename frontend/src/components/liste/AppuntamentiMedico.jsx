import React, { useEffect, useState } from 'react'
import { Grid } from '@mui/material'
import { listAppuntamentiMedico } from '../../services/AppuntamentiService'
import { useNavigate, useParams } from 'react-router-dom'
import { listRefertiByAppuntamento } from '../../services/RefertoService'

const AppuntamentiMedico = () => {

    const [appuntamenti, setAppuntamentiMedico] = useState([])

    const navigator = useNavigate();

    const { idMedico } = useParams();

    useEffect(() => {
        getAllAppuntamentiMedico(idMedico);
    }, [])

    function getAllAppuntamentiMedico(id_medico) {
        listAppuntamentiMedico(id_medico).then((response) => {
            setAppuntamentiMedico(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function visualizzaProfilo() {
        navigator(`/edit-medico/${idMedico}`)
    }

    function scriviRisultato(id_app){
        listRefertiByAppuntamento(id_app).then((response) => {
            if (response.data.length === 0){
                navigator(`/risultatoForm/${id_app}/${idMedico}`)
            } else {
                navigator(`/risultatoEdit/${id_app}/${idMedico}/${response.data[0].id_ris}`)
            }
        }).catch(error => {
            console.error(error);
        })
    }

    return (
        <div>
            <Grid container sx={{ justifyContent: "space-between" }}>
                <Grid item xs={2.5}>
                    <div className='h-auto shadow-lg bg-white p-5 sticky top-5'>
                        <h1 className='font-bold text-lg'>Filter</h1>

                        <div className='spacy-y-4 mt-10'>
                            <h1 className='font-semibold text-lg'>I TUOI APPUNTAMENTI</h1>
                            
                 
                            <button className='btn btn-info space-y-15 mt-2' onClick={() => visualizzaProfilo()}>visualizza profilo</button>
                        </div>

                    </div>
                </Grid>
                <Grid item xs={9}>
                    <table className='table table-striped table-bordered'>
                        <thead>
                            <tr>
                                    <th>Id_app</th>
                                    <th>Paziente</th>
                                    <th>Vedi Paziente</th>
                                    <th>Visita</th>
                                    <th>Slot</th>
                                    <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                                {
                                    appuntamenti.map(appuntamento =>
                                        <tr key={appuntamento.id_app}>
                                            <td>{appuntamento.id_app}</td>
                                            <td> {appuntamento.id_paziente} </td>    
                                            <td>    
                                                <button className='btn btn-info px-4' onClick={() => navigator(`/visualizzaPaziente/${appuntamento.id_paziente}/${idMedico}`)}>Informazioni</button>
                                            </td>
                                            <td>{appuntamento.id_visita}</td>
                                            <td>{appuntamento.id_slot}</td>
                                            <td>
                                                <button className='btn btn-info' onClick={() => scriviRisultato(appuntamento.id_app)}>Risultato</button>
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

export default AppuntamentiMedico