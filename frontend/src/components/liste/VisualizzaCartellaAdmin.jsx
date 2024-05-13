import React, { useEffect, useState } from 'react'
import { listReferti, listRefertiByPaziente} from '../../services/RefertoService'
import { useNavigate, useParams } from 'react-router-dom'


const VisualizzaCartella = () => {

    const [referti, setReferti] = useState([])

    const { idPaziente } = useParams();

    const navigator = useNavigate();

    useEffect(() => {
        getAllReferti();
    }, [])

    function getAllReferti() {
        listRefertiByPaziente(idPaziente).then((response) => {
            setReferti(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function exit() {
        navigator('/')
    }

    function back2pazienti() {
        navigator(`/pazienti`)
    }

    return (
        <div className='container'>
            <h2 className='text-center'>Lista referti</h2>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Referto</th>
                        <th>Prescrizione</th>
                        <th>Appuntamento</th>

                    </tr>
                </thead>
                <tbody>
                    {
                        referti.map(referto =>
                            <tr key={referto.id_ris}>
                                <td>{referto.id_ris}</td>
                                <td>{referto.referto}</td>
                                <td>{referto.prescr}</td>
                                <td>{referto.id_appuntamento}</td> 
                            </tr>)
                    }
                </tbody>
            </table>
            <button className='btn btn-primary mb-2' onClick={back2pazienti}>Torna agli appuntamenti</button>
            <button className='btn btn-danger mb-2' onClick={exit}>Esci</button>
        </div>
    )
}

export default VisualizzaCartella