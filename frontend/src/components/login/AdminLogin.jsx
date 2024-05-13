import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'

export default function AdminLogin(){

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

    useEffect(() => {
        if (Object.keys(errors).length === 0 && formSubmitted) {
            navigator(`/MenuComponent`);
        }
    }, [errors]);

    function loginAdminEvaluation(password, e) {
        e.preventDefault();

        if (validateForm()) {
            if(password === 'admin') {
                navigator(`/MenuComponent`)
            }
        }
    }

    return (
        <div className='container'>
            <br /> <br />
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'> { 'Login Admin' }
                    <div className='card-body'>
                        <form onSubmit={(e) => loginAdminEvaluation(password, e)}>
                            <div className='form-group mb-2'>
                                <label htmlFor='password'>Password:</label>
                                <input
                                    id='password'
                                    type='password'
                                    className='form-control'
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                />
                                { errors.password && <div className='invalid-feedback'> { errors.password} </div> }
                            </div>
                            <button className='btn btn-danger' onClick={tornaIndietro} >Go Back</button>
                            <button className='btn btn-success' onClick={(e) => loginAdminEvaluation(password, e)}>Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}