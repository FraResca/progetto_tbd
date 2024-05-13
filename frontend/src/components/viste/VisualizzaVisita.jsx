
import { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { StarIcon } from '@heroicons/react/20/solid'
import { RadioGroup } from '@headlessui/react'
import { createAppuntamento } from '../../services/AppuntamentiService'
import { getVisita } from '../../services/VisiteService'
import { listSlots } from '../../services/SlotService'




function classNames(...classes) {
    return classes.filter(Boolean).join(' ')
}

const VisualizzaVisita = () => {

    const [tipo_visita, setTipoVisita] = useState('')
    const [descrizione, setDescrizione] = useState('')
    const [prezzo, setPrezzo] = useState('')
    const [slots, setSlot] = useState('')
    const [id_medico, setMedico] = useState('')


    useEffect(() => {
        if (id_vis) {
            getVisita(id_vis).then((response) => {
                setTipoVisita(response.data.tipoVis);
                setDescrizione(response.data.descr);
                setPrezzo(response.data.prezzo);
                setMedico(response.data.medico);
            }).catch(error => {
                console.error(error);
            })
        }
        listSlot().then((response) => {
            setSlot(response.data);
        }) 
    }, [tipo_visita])

    function back2Menu() {
        navigator('/MenuComponent')
    }

    function prenota(dataOraSlot) {
        const pagato = false;
        const id_paziente = 1;
        const appuntamento = { pagato,id_paziente,id_medico,tipo_visita, dataOraSlot}
        console.log(appuntamento),
            
           
        createAppuntamento(appuntamento).then((response) => {
            console.log(response.data);
            navigator('/')
        }).catch(error => {
            console.error(error);
        })
            

    }

    return (
        <div className="bg-white">
            <div className="pt-6">
             
                {/* Product info */}
                <div className="mx-auto max-w-2xl px-4 pb-16 pt-10 sm:px-6 lg:grid lg:max-w-7xl lg:grid-cols-3 lg:grid-rows-[auto,auto,1fr] lg:gap-x-8 lg:px-8 lg:pb-24 lg:pt-16">
                    <div className="lg:col-span-2 lg:border-r lg:border-gray-200 lg:pr-8">
                        <h1 className="text-2xl font-bold tracking-tight text-gray-900 sm:text-3xl">{tipo_visita}</h1>
                    </div>

                    {/* Options */}
                    <div className="mt-4 lg:row-span-3 lg:mt-0">
                        <h2 className="sr-only">Product information</h2>
                        <p className="text-3xl tracking-tight text-gray-900">{prezzo}</p>


                        <form className="mt-10">
                            {/* Colors */}
                            <div>
                                <table className='table table-striped table-bordered'>
                                    <thead>
                                        <tr>
                                            <th>slot</th>
                                            <th>stato</th> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {
                                            slots.map(slot =>
                                                <tr key={slot.dataOraSlot}>
                                                    <td>{slot.dataOraSlot}</td>
                                                    <td>{slot.occupato}</td>
                                                    <td>
                                                        <button className='btn btn-danger' onClick={() => prenota(slot.dataOraSlot)}>Prenota</button>
                                                    </td>
                                                </tr>)
                                        }
                                    </tbody>
                                    <button className='btn btn-primary mb-2' onClick={back2Menu}>Torna al Menu</button>
                                </table>
                               
                            </div>

                            <button
                                type="submit"
                                className="mt-10 flex w-full items-center justify-center rounded-md border border-transparent bg-indigo-600 px-8 py-3 text-base font-medium text-white hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"
                                onClick={prenota}
                            >
                                prenota
                            </button>
                        </form>
                    </div>

                    <div className="py-10 lg:col-span-2 lg:col-start-1 lg:border-r lg:border-gray-200 lg:pb-16 lg:pr-8 lg:pt-6">
                        {/* Description and details */}
                        <div>
                            <h3 className="sr-only">Description</h3>

                            <div className="space-y-6">
                                <p className="text-base text-gray-900">{descrizione}</p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    )
}

export default VisualizzaVisita
