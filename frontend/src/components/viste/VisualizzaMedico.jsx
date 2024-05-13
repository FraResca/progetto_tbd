import React from 'react'

import { useNavigate, useParams } from 'react-router-dom'
import { useEffect, useState } from 'react'
import { createMedico, getMedico, updateMedico } from '../../adminServices/MedicoService'

const VisualizzaMedico = () => {

    const [nome, setNome] = useState('')
    const [cognome, setCognome] = useState('')
    const [data_n, setDataNascita] = useState('')
    const [cf, setCodiceFiscale] = useState('')
    const [email, setEmail] = useState('')
    const [stipendio, setStipendio] = useState('')
    const [specializ, setSpecializ] = useState('')

    const navigator = useNavigate();

    const {idMedico } = useParams();
    const {idPaziente} = useParams();

    useEffect(() => {
        if (idMedico) {
            getMedico(idMedico).then((response) => {
                setNome(response.data.nome);
                setCognome(response.data.cognome);
                setDataNascita(response.data.data_n);
                setCodiceFiscale(response.data.cf);
                setEmail(response.data.email);
                setStipendio(response.data.stipendio);
                setSpecializ(response.data.specializ);
            }).catch(error => {
                console.error(error);
            })
        }
    }, [idMedico])

    return (
        <div className="bg-white">
            <div className="pt-6">
                <div className="mx-auto max-w-2xl px-4 pb-16 pt-10 sm:px-6 lg:grid lg:max-w-7xl lg:grid-cols-3 lg:grid-rows-[auto,auto,1fr] lg:gap-x-8 lg:px-8 lg:pb-24 lg:pt-16">
                    <div className="lg:col-span-2 lg:pr-8">
                        <h1 className="text-2xl font-bold tracking-tight text-gray-900 sm:text-3xl" data-testid='nome'> {nome} {cognome}</h1>
                    </div>

                    <div className="py-10 lg:col-span-2 lg:col-start-1  lg:pb-16 lg:pr-8 lg:pt-6">
                        

                        <div className="mt-10">
                            <h3 className="text-sm font-medium text-gray-900">Specializzazione</h3>
                            <div className="mt-4">
                                <ul role="list" className="list-disc space-y-2 pl-4 text-sm">                              
                                    <li className="text-gray-400">
                                        <span className="text-gray-600">{specializ}</span>
                                    </li>
                                </ul>
                            </div>

                            <h3 className="text-sm font-medium text-gray-900">Data di nascita</h3>
                            <div className="mt-4">
                                <ul role="list" className="list-disc space-y-2 pl-4 text-sm">                              
                                    <li className="text-gray-400">
                                        <span className="text-gray-600">{data_n}</span>
                                    </li>
                                </ul>
                            </div>

                            <h3 className="text-sm font-medium text-gray-900">Email</h3>
                            <div className="mt-4">
                                <ul role="list" className="list-disc space-y-2 pl-4 text-sm">                              
                                    <li className="text-gray-400">
                                        <span className="text-gray-600">{email}</span>
                                    </li>
                                </ul>
                            </div>
                            
                        </div>
                        <button className="btn btn-primary" onClick={() => navigator(`/appuntamentiPaziente/${idPaziente}`)}>Torna agli appuntamenti</button>    
                    </div>
                    
                </div>
                
            </div>
            
        </div>
    )
}
export default VisualizzaMedico