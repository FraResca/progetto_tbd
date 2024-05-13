import React, {useEffect, useState} from 'react'
import { listMedici, deleteMedico } from '../../adminServices/MedicoService'
import { useNavigate } from 'react-router-dom'

/*
pagina in cui l admin visualizza tutti i medici e puo agire aggiungendo togliendoo modificando i profili
*/

const ListMedicoComponent = () => {

    const [medici, setMedici] = useState([])

    const navigator = useNavigate();
    
    useEffect(() => {
        getAllMedici();
    }, [getAllMedici])

    function getAllMedici(){
        listMedici().then((response) => {
            setMedici(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function addNewMedico(){
        navigator('/add-medico')
    }

    function updateMedico(id_medico){
        navigator(`/edit-medico/${id_medico}`)
    }

    function back2Menu(){
        navigator('/MenuComponent')
    }

    function removeMedico(id_medico){
        console.log(id_medico);
        deleteMedico(id_medico).then((response) => {
            getAllMedici();
        }).catch(error => {
            console.error(error);
        })
    }

    return (
        <div className='container'>
            <h2 className='text-center'>Lista di Medici</h2>
            <button className='btn btn-primary mb-2' onClick={addNewMedico}>Add Medico</button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>Cognome</th>
                        <th>Data di Nascita</th>
                        <th>Codice Fiscale</th>
                        <th>Stipendio</th>
                        <th>Specializzazione</th>
                        <th>Actions</th>
                        
                    </tr>
                </thead>
                <tbody>
                    {
                        medici.map(medico =>
                            <tr key={medico.id_utente}>
                                <td>{medico.id_utente}</td>
                                <td>{medico.nome}</td>
                                <td>{medico.cognome}</td>
                                <td>{medico.data_n}</td>
                                <td>{medico.cf}</td>
                                <td>{medico.stipendio}</td>
                                <td>{medico.specializ}</td>
                                <td>
                                    <button className='btn btn-info' onClick={() => updateMedico(medico.id_utente)}>Update</button>
                                    <button className='btn btn-danger' onClick={() => removeMedico(medico.id_utente)}>Delete</button>
                                </td>
                            </tr>)
                    }
                </tbody>
            </table>
            <button className='btn btn-primary mb-2' onClick={back2Menu}>Torna al Menu</button>
        </div>
    )
}

export default ListMedicoComponent