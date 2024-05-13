import { createPaziente, getPaziente, updatePaziente } from '../../adminServices/PazienteService'
import { useNavigate, useParams } from 'react-router-dom'
import React, { useEffect, useState } from 'react'

export default function ProfiloUtente() {
    const [nome, setNome] = useState('')
    const [cognome, setCognome] = useState('')
    const [data_n, setDataNascita] = useState('')
    const [cf, setCodiceFiscale] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')

    const { id_paziente } = useParams();

    const [errors, setErrors] = useState({
        nome: '',
        cognome: '',
        data_n: '',
        cf: '',
        email:'',
        password: ''
    })

    const navigator = useNavigate();

    useEffect(() => {
        if (id_paziente) {
            getPaziente(id_paziente).then((response) => {
                setNome(response.data.nome);
                setCognome(response.data.cognome);
                setDataNascita(response.data.data_n);
                setCodiceFiscale(response.data.cf);
                setEmail(response.data.email);
                setPassword(response.data.password);
            }).catch(error => {
                console.error(error);
            })
        }
    }, [id_paziente])

    function saveOrUpdatePaziente(e) {
        e.preventDefault();
        if (validateForm()) {
            
            const paziente = { nome, cognome, data_n, cf, email, password }
            if (id_paziente) {
                updatePaziente(id_paziente, paziente).then((response) => {
                    navigator(`/appuntamentiPaziente/${id_paziente}`)
                }).catch(error => {
                    console.error(error);
                })
            }
            else {
                createPaziente(paziente).then((response) => {
                    navigator(`/appuntamentiPaziente/${id_paziente}`)
                }).catch(error => {
                    console.error(error);
                })
            }

        }
    }

    function validateForm() {
        let valid = true;
        const errorsCopy = { ...errors }

        if (nome.trim()) {
            errorsCopy.nome = '';
        }
        else {
            errorsCopy.nome = 'Inserire nome';
            valid = false;
        }

        if (cognome.trim()) {
            errorsCopy.cognome = '';
        }
        else {
            errorsCopy.cognome = 'Inserire cognome';
            valid = false;
        }

        if (data_n.trim()) {
            errorsCopy.data_n = '';
        }
        else {
            errorsCopy.data_n = 'Inserire data di nascita';
            valid = false;
        }

        if (cf.trim()) {
            errorsCopy.cf = '';
        } else {
            errorsCopy.cf = 'Inserire codice fiscale';
            valid = false;
        }

        if (email.trim()) {
            errorsCopy.email = '';
        } else {
            errorsCopy.email = 'Inserire email';
            valid = false;
        }

        if (password.trim()) {
            errorsCopy.password = '';
        } else {
            errorsCopy.password = 'Inserire password';
            valid = false;
        }

        setErrors(errorsCopy);

        return valid;
    }

    function pageTitle() {
        if (id_paziente) {
            return <h2 className='text-center'>Update Paziente</h2>
        }
        else {
            return <h2 className='text-center'>Add Paziente</h2>
        }
    }

    function tornaIndietro() {
        navigator(`/appuntamentiPaziente/${id_paziente}`)
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
                                <label htmlFor='firstname'>First Name:</label>
                                <input
                                    id='firstname'
                                    type='text'
                                    placeholder='Inserire nome'
                                    name='nome'
                                    value={nome}
                                    className={`form-control ${ errors.nome ? 'is-invalid': '' }`}
                                    onChange={(e) => setNome(e.target.value)}
                                    autoComplete='nome'
                                />
                                { errors.nome && <div className='invalid-feedback'> { errors.nome} </div> }
                            </div>

                            <div className='form-group mb-2'>
                                <label htmlFor='lastname'>Last Name:</label>
                                <input
                                    id='lastname'
                                    type='text'
                                    placeholder='Inserire cognome'
                                    name='cognome'
                                    value={cognome}
                                    className={`form-control ${ errors.cognome ? 'is-invalid': '' }`}
                                    onChange={(e) => setCognome(e.target.value)}
                                    autoComplete='cognome'
                                />
                                { errors.cognome && <div className='invalid-feedback'> { errors.cognome} </div> }
                            </div>

                            <div className='form-group mb-2'>
                                <label htmlFor='date'>Date of Birth:</label>
                                <input
                                    id='date'
                                    type='date'
                                    placeholder='Inserire data di nascita'
                                    name='data_n'
                                    value={data_n}
                                    className={`form-control ${ errors.data_n ? 'is-invalid': '' }`}
                                    onChange={(e) => setDataNascita(e.target.value)}
                                    autoComplete='data_n'
                                />
                                { errors.data_n && <div className='invalid-feedback'> { errors.data_n} </div> }
                            </div>

                            <div className='form-group mb-2'>
                                <label htmlFor='cf'>Codice Fiscale:</label>
                                <input
                                    id='cf'
                                    type='text'
                                    placeholder='Inserire codice fiscale'
                                    name='cf'
                                    value={cf}
                                    className={`form-control ${ errors.cf ? 'is-invalid': '' }`}
                                    onChange={(e) => setCodiceFiscale(e.target.value)}
                                    autoComplete='cf'
                                />
                                { errors.cf && <div className='invalid-feedback'> { errors.cf} </div> }
                            </div>

                            <div className='form-group mb-2'>
                                <label htmlFor='email'>Email:</label>
                                <input
                                    id='email'
                                    type='email'
                                    placeholder='Inserire email'
                                    name='email'
                                    value={email}
                                    className={`form-control ${ errors.email ? 'is-invalid': '' }`}
                                    onChange={(e) => setEmail(e.target.value)}
                                    autoComplete='email'
                                />
                                { errors.email && <div className='invalid-feedback'> { errors.email} </div> }
                            </div>

                            <div className='form-group mb-2'>
                                <label htmlFor='password'>Password:</label>
                                <input
                                    id='password'
                                    type='password'
                                    placeholder='Inserire password'
                                    name='password'
                                    value={password}
                                    className={`form-control ${ errors.password ? 'is-invalid': '' }`}
                                    onChange={(e) => setPassword(e.target.value)}
                                />
                                { errors.password && <div className='invalid-feedback'> { errors.password} </div> }
                            </div>

                            <button className='btn btn-danger' onClick={tornaIndietro} >Go Back</button>
                            <button className='btn btn-success' onClick={saveOrUpdatePaziente} >Submit</button>
                        </form>
    
                    </div>
                </div>
    
            </div>
    
        </div>
      )
}
