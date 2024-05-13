import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { getVisita } from '../../services/VisiteService'
import { getSlot } from '../../services/SlotService'

import { listAppuntamenti, deleteAppuntamento } from '../../services/AppuntamentiService'



const AppuntamentiHr = () => {

    const [appuntamenti, setAppuntamenti] = useState([])

    const navigator = useNavigate();

    useEffect(() => {
        getAllAppuntamenti();
    }, [])

    function getAllAppuntamenti() {
        listAppuntamenti().then((response) => {
            setAppuntamenti(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function back2Home() {
        navigator('/')
    }

    function addNewAppuntamento(){
        navigator('/add-appuntamento')
    }

    function removeAppuntamento(id_appuntamento) {
        deleteAppuntamento(id_appuntamento).then((response) => {
            getAllAppuntamenti();
        }).catch(error => {
            console.error(error);
        })
    }

    return (
        <div className='container'>
            <h2 className='text-center'>Lista di Tutti gli Appuntamenti</h2>
            <button className='btn btn-primary mb-2' onClick={addNewAppuntamento}>Aggiungi appuntamento</button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Id_app</th>
                        <th>Pagato</th>
                        <th>Paziente</th>
                        <th>Medico</th>
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
                                <td>{appuntamento.pagato ? 'Si' : 'No'}</td>
                                <td>{appuntamento.id_paziente}</td>
                                <td>{appuntamento.id_medico}</td>
                                <td>{appuntamento.id_visita}</td>
                                <td>{appuntamento.id_slot}</td>
                                <td>
                                    <button className='btn btn-danger' onClick={() => removeAppuntamento(appuntamento.id_app)}>Delete</button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
            <button className='btn btn-primary mb-2' onClick={back2Home}>Torna alla Home</button>
        </div>
    )
}

export default AppuntamentiHr