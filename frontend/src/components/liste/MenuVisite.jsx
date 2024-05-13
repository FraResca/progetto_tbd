import React, {useEffect, useState } from "react";
import { useNavigate, useParams } from 'react-router-dom'
import { listVisite } from '../../services/VisiteService'
import { listMedici } from '../../adminServices/MedicoService'

const MenuVisite = () => {
    
    const [visite, setVisite] = useState([])

    const [medici, setMedici] = useState({});

    const {idPaziente} = useParams();

    const navigator = useNavigate();

    useEffect(() => {
        getAllVisite();
        getAllMedici();
    }, [])

    function getAllMedici(){
        listMedici().then((response) => {
            const mediciById = response.data.reduce((acc, medico) => {
                acc[medico.id_utente] = medico;
                return acc;
            }, {});
            setMedici(mediciById);
            console.log(mediciById);
        }).catch(error => {
            console.error(error);
        })
    }

    function getAllVisite() {
        listVisite().then((response) => {
            setVisite(response.data);
            console.log(response.data);
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
                                    Prenota qui le tue visite
                                </h2>
                                <h2 className="text-body-color text-base dark:text-dark-6">
                                    tutte le visite vengono svolte da personale specializzato pronto a venire in contro ad ogni esigenza del cliente
                                </h2>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr>
                        <th>Tipo</th>
                        <th>Descrizione</th>
                        <th>Prezzo</th>
                        <th>Medico</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {visite.map((visita) => (
                        <tr key={visita.id_vis}>
                            <td>{visita.tipoVis}</td>
                            <td>{visita.descr}</td>
                            <td>{visita.prezzo}</td>
                            <td>{medici[visita.id_medico].nome} {medici[visita.id_medico].cognome}</td>
                            <td>
                                <button className="btn btn-primary" onClick={() => navigator(`/elencoSlot/${idPaziente}/${visita.id_medico}/${visita.id_vis}`)}>Prenota</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </>
    );
};

export default MenuVisite;
