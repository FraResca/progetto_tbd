package tbd.progetto_tbd.mapper;

import tbd.progetto_tbd.dto.MedicoDto;
import tbd.progetto_tbd.entity.Medico;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.VisitaRepository;

public class MedicoMapper {
    public static MedicoDto mapToMedicoDto(Medico medico) {
        return new MedicoDto(
            medico.getId_utente(),
            medico.getNome(),
            medico.getCognome(),
            medico.getData_n(),
            medico.getCf(),
            medico.getEmail(),
            medico.getPassword(),
            medico.getStipendio(),
            medico.getSpecializ()
        );
    }

    public static Medico mapToMedico(MedicoDto medicoDto, AppuntamentoRepository appuntamentoRepository, VisitaRepository visitaRepository) {
        return new Medico(
            medicoDto.getId_utente(),
            medicoDto.getNome(),
            medicoDto.getCognome(),
            medicoDto.getData_n(),
            medicoDto.getCf(),
            medicoDto.getEmail(),
            medicoDto.getPassword(),
            medicoDto.getStipendio(),
            medicoDto.getSpecializ()
        );
    }
}
