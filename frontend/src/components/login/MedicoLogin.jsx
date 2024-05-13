import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { medicoByEmail } from '../../adminServices/MedicoService'

export default function MedicoLogin(){

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')

    const [errors, setErrors] = useState({
        email: '',
        password: ''
    })

    const navigator = useNavigate();

    function validateForm() {
        let valid = true;
        const errorsCopy = { ...errors }

        if (email === '') {
            errorsCopy.email = 'Campo obbligatorio';
            valid = false;
        }

        if (password === '') {
            errorsCopy.password = 'Campo obbligatorio';
            valid = false;
        }

        setErrors(errorsCopy);

        return valid;
    }

    function tornaIndietro() {
        navigator(`/`)
    }

    function loginMedicoEvaluation(email, password, e) {
        e.preventDefault();

        if (validateForm()) {
            medicoByEmail(email).then((response) => {
                if (response.data.password === password) {
                    navigator(`/appuntamentiMedico/1`)
                }
            }).catch(error => {
                console.error(error);
            })
        }
    }

    return (
        <div className='container'>
            <br /> <br />
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'> { 'Login Medico' }
                    <div className='card-body'>
                        <form onSubmit={(e) => loginMedicoEvaluation(email, password, e)}>
                            <div className='form-group mb-2'>
                                <label htmlFor='email'>Email:</label>
                                <input
                                    id='email'
                                    type='text'
                                    className='form-control'
                                    value={email}
                                    onChange={(e) => setEmail(e.target.value)}
                                />
                                { errors.email && <div className='invalid-feedback'>{ errors.email }</div> }
                            </div>
                            <div className='form-group mb-2'>
                                <label htmlFor='password'>Password:</label>
                                <input
                                    id='password'
                                    type='password'
                                    className='form-control'
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                />
                                { errors.password && <div className='invalid-feedback'>{ errors.password }</div> }
                            </div>
                            <button className='btn btn-danger' onClick={tornaIndietro} >Go Back</button>
                            <button className='btn btn-success' onClick={(e) => loginMedicoEvaluation(email, password, e)} >Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}