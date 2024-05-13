import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'

export default function HrLogin(){

    const [password, setPassword] = useState('')

    const [errors, setErrors] = useState({
        password: ''
    })

    const navigator = useNavigate();

    function validateForm() {
        let valid = true;
        const errorsCopy = { ...errors }

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

    function loginHrEvaluation(password, e) {
        e.preventDefault();

        if (validateForm()) {
            if(password === 'hr') {
                navigator(`/AppuntamentiHr`)
            }
        }
    }

    return (
        <div className='container'>
            <br /> <br />
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'> { 'Login Human Resources' }
                    <div className='card-body'>
                        <form onSubmit={(e) => loginHrEvaluation(password, e)}>
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
                            <button className='btn btn-success' onClick={(e) => loginHrEvaluation(password, e)}>Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}