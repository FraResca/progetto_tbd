package tbd.progetto_tbd.mapper;

import tbd.progetto_tbd.dto.PazienteDto;
import tbd.progetto_tbd.entity.Paziente;
import tbd.progetto_tbd.repository.AppuntamentoRepository;

public class PazienteMapper {
    public static PazienteDto mapToPazienteDto(Paziente paziente) {
        return new PazienteDto(
            paziente.getId_utente(),
            paziente.getNome(),
            paziente.getCognome(),
            paziente.getData_n(),
            paziente.getCf(),
            paziente.getEmail(),
            paziente.getPassword()
        );
    }

    public static Paziente mapToPaziente(PazienteDto pazienteDto, AppuntamentoRepository appuntamentoRepository) {
        return new Paziente(
            pazienteDto.getId_utente(),
            pazienteDto.getNome(),
            pazienteDto.getCognome(),
            pazienteDto.getData_n(),
            pazienteDto.getCf(),
            pazienteDto.getEmail(),
            pazienteDto.getPassword()
        );
    }
}
