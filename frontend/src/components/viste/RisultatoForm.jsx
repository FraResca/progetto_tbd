import { createReferto, getReferto, updateReferto } from "../../services/RefertoService";
import { useNavigate, useParams } from 'react-router-dom'
import React, { useEffect, useState } from 'react'

export default function RisultatoForm() {

    const {idApp, idMedico, idRis} = useParams();

    const [referto, setReferto] = useState('')
    const [prescr, setPrescr] = useState('')
    const [id_appuntamento, setAppuntamento] = useState(idApp)

    const [errors, setErrors] = useState({
        referto: '',
        prescr: ''
    })

    const navigator = useNavigate();

    useEffect(() => {
        if (idRis) {
            getReferto(idRis).then((response) => {
                setReferto(response.data.referto)
                setPrescr(response.data.prescr)
                setAppuntamento(response.data.id_appuntamento)
            }
            ).catch(error => {
                console.error(error);
            })
        }
    }, [idRis])

    function saveRisultato(e) {
        e.preventDefault();

        if (validateForm()) {
            const risultato = { referto, prescr, id_appuntamento }
            
            if(idRis){
                updateReferto(idRis, risultato).then((response) => {
                }
                ).catch(error => {
                    console.error(error);
                })
            }
            else {
                createReferto(risultato).then((response) => {     
                }).catch(error => {
                    console.error(error);
                })
            }
            navigator(`/appuntamentiMedico/${idMedico}`)
        }
    }

    function validateForm() {
        let valid = true;
        const errorsCopy = {...errors}

        if (referto.trim()) {
            errorsCopy.referto = '';
        }
        else {
            errorsCopy.referto = 'Inserire referto';
            valid = false;
        }

        if (prescr.trim()) {
            errorsCopy.prescr = '';
        }
        else {
            errorsCopy.prescr = 'Inserire prescrizione';
            valid = false;
        }

        setErrors(errorsCopy);

        return valid;
    }

    function tornaIndietro() {
        navigator(`/appuntamentiMedico/${idMedico}`)
    }

    return (
        <div className='container'>
            <br /> <br />
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'> { "Risultato dell'appuntamento" }
                    <div className='card-body'>
                        <form>
                            <div className='form-group mb-2'>
                                <label htmlFor='referto'>Referto:</label>
                                <input type='text' placeholder="Inserisci referto" className='form-control' id='referto' value={referto} onChange={(e) => setReferto(e.target.value)} />
                            </div>
                            { errors.referto && <div className='text-danger'>{errors.referto}</div> }
                            <div className='form-group mb-2'>
                                <label htmlFor='prescr'>Prescrizione:</label>
                                <input type='text' placeholder="Inserisci prescrizione" className='form-control' id='prescr' value={prescr} onChange={(e) => setPrescr(e.target.value)} />
                            </div>
                            { errors.prescr && <div className='text-danger'>{errors.prescr}</div> }
                            <button className='btn btn-danger' onClick={tornaIndietro} >Go Back</button>
                            <button className='btn btn-success' onClick={saveRisultato} >Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}