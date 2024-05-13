import React, {useEffect, useState } from "react";
import { useNavigate, useParams } from 'react-router-dom'
import { listFreeSlots, updateSlot, getSlot } from '../../services/SlotService'
import { createAppuntamento } from "../../services/AppuntamentiService";

const ElencoSlot = () => {
    const [pagato, setPagato] = useState(false)
    const [slots, setSlots] = useState([])

    const {idPaziente, idMedico, idVis} = useParams();

    const navigator = useNavigate();

    useEffect(() => {
        getAllSlots();
    }, [])

    function getAllSlots() {
        listFreeSlots().then((response) => {
            setSlots(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function prenotazione(id_slot){
        const id_paziente = String(idPaziente)
        const id_medico = String(idMedico)
        const id_visita = String(idVis)
        
        const slot = getSlot(id_slot).then((response) => { 
        }).catch(error => {
            console.error(error);
        })
        slot.occupato = true

        id_slot = String(id_slot)
        
        const appuntamento = {
            pagato, id_paziente, id_medico, id_visita, id_slot
        }
        
        console.log(appuntamento);
        createAppuntamento(appuntamento).then((response) => {
            updateSlot(id_slot, slot).then((response) => {
                navigator(`/appuntamentiPaziente/${idPaziente}`);
            }).catch(error => {
                console.error(error);
            });
        }).catch(error => {
            console.error(error);
        })

    }

    return (
        <>
            <section className="pt-20 pb-12 lg:pt-[120px] lg:pb-[90px] dark:bg-dark">
                <div className="container mx-auto">
                    <div className="flex flex-wrap -mx-4">
                        <div className="w-full px-4">
                            <div className="mx-auto mb-[60px] max-w-[510px] text-center">
                                
                                <h2 className="text-dark mb-3 text-3xl leading-[1.208] font-bold sm:text-4xl md:text-[40px]">
                                    Scegli uno fra gli slot disponibili
                                </h2>
                                <h2 className="text-body-color text-base dark:text-dark-6">
                                    sulla base delle disponibilità della struttura e del medico
                                </h2>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Data</th>
                        <th>Ora</th>
                    </tr>
                </thead>
                <tbody>
                    {slots.map((slot) => (
                        <tr key={slot.id_slot}>
                            <td>{slot.id_slot}</td>
                            <td>{slot.dataSlot}</td>
                            <td>{slot.oraSlot}</td>
                            <td>
                                <button className="btn btn-primary" onClick={() => prenotazione(slot.id_slot)}>Prenota</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </>
    );

}

export default ElencoSlot;