import { createAppuntamento, getAppuntamento, updateAppuntamento } from '../../services/AppuntamentiService'
import { useNavigate, useParams } from 'react-router-dom'
import React, { useEffect, useState } from 'react'


/**
*questa e la pagina in cui compaiono le informazioni dell utente viene acceduta sia dalutente che dagli admin
 */

export default function AppuntamentoForm() {

    const [pagato, setPagato] = useState(false)
    const [id_paziente, setPaziente] = useState('')
    const [id_medico, setMedico] = useState('')
    const [id_visita, setVisita] = useState('')
    const [id_slot, setSlot] = useState('')

    const {id_app} = useParams();

    const [errors, setErrors] = useState({
        pagato: '',
        id_paziente: '',
        id_medico: '',
        id_visita: '',
        id_slot: ''
    })

    const navigator = useNavigate();

    useEffect(() => {
        if (id_app) {
            getAppuntamento(id_app).then((response) => {
                setPagato(response.data.pagato)
                setPaziente(response.data.paziente)
                setMedico(response.data.medico)
                setVisita(response.data.visita)
                setSlot(response.data.slot)
            }).catch(error => {
                console.error(error);
            })
        }
    }, [id_app])

    function saveOrUpdateAppuntamento(e) {
        e.preventDefault();

        if (validateForm()) {
            const appuntamento = {
                pagato, id_paziente, id_medico, id_visita, id_slot}
            console.log(appuntamento)
            createAppuntamento(appuntamento).then((response) => {     
            }).catch(error => {
                console.error(error);
            })
            navigator(`/appuntamentiHr`)
        }
    }

    function validateForm() {
        let valid = true;
        const errorsCopy = { ...errors }

        if (id_paziente.trim()) {
            errorsCopy.id_paziente = '';
        }
        else {
            errorsCopy.id_paziente = 'Inserire paziente';
            valid = false;
        }

        if (id_medico.trim()) {
            errorsCopy.id_medico = '';
        }
        else {
            errorsCopy.id_medico = 'Inserire medico';
            valid = false;
        }

        if (id_visita.trim()) {
            errorsCopy.id_visita = '';
        }
        else {
            errorsCopy.id_visita = 'Inserire visita';
            valid = false;
        }

        if (id_slot.trim()) {
            errorsCopy.id_slot = '';
        }
        else {
            errorsCopy.id_slot = 'Inserire slot';
            valid = false;
        }

        setErrors(errorsCopy);

        return valid;
    }

    function pageTitle() {
        if (id_app) {
            return <h2 className='text-center'>Update Appuntamento</h2>
        }
        else {
            return <h2 className='text-center'>Add Appuntamento</h2>
        }
    }

    function tornaIndietro() {
        navigator(`/appuntamentiHr`)
    }

    return (
        <div className='container'>
            <br /> <br />
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    {
                        pageTitle()
                    }
                    <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                <label htmlFor='paziente'>Paziente:</label>
                                <input
                                    id='paziente'
                                    type='text'
                                    placeholder='Inserire paziente'
                                    name='paziente'
                                    value={id_paziente}
                                    className={`form-control ${ errors.id_paziente ? 'is-invalid': '' }`}
                                    onChange={(e) => setPaziente(e.target.value)}
                                    autoComplete='paziente'
                                />
                                { errors.id_paziente && <div className='invalid-feedback'> { errors.id_paziente} </div> }
                            </div>

                            <div className='form-group mb-2'>
                                <label htmlFor='medico'>Medico:</label>
                                <input
                                    id='medico'
                                    type='text'
                                    placeholder='Inserire medico'
                                    name='medico'
                                    value={id_medico}
                                    className={`form-control ${ errors.id_medico ? 'is-invalid': '' }`}
                                    onChange={(e) => setMedico(e.target.value)}
                                    autoComplete='medico'
                                />
                                { errors.id_medico && <div className='invalid-feedback'> { errors.id_medico} </div> }
                            </div>

                            <div className='form-group mb-2'>
                                <label htmlFor='visita'>Visita:</label>
                                <input
                                    id='visita'
                                    type='text'
                                    placeholder='Inserire visita'
                                    name='visita'
                                    value={id_visita}
                                    className={`form-control ${ errors.id_visita ? 'is-invalid': '' }`}
                                    onChange={(e) => setVisita(e.target.value)}
                                    autoComplete='visita'
                                />
                                { errors.id_visita && <div className='invalid-feedback'> { errors.id_visita} </div> }
                            </div>

                            <div className='form-group mb-2'>
                                <label htmlFor='slot'>Slot:</label>
                                <input
                                    id='slot'
                                    type='text'
                                    placeholder='Inserire slot'
                                    name='slot'
                                    value={id_slot}
                                    className={`form-control ${ errors.id_slot ? 'is-invalid': '' }`}
                                    onChange={(e) => setSlot(e.target.value)}
                                    autoComplete='slot'
                                />
                                { errors.id_slot && <div className='invalid-feedback'> { errors.id_slot} </div> }
                            </div>

                            <button className='btn btn-danger' onClick={tornaIndietro} >Go Back</button>
                            <button className='btn btn-success' onClick={saveOrUpdateAppuntamento} >Submit</button>
                        </form>
    
                    </div>
                </div>
    
            </div>
    
        </div>
    )
}
