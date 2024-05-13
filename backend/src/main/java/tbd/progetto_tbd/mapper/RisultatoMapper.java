package tbd.progetto_tbd.mapper;

import tbd.progetto_tbd.dto.RisultatoDto;
import tbd.progetto_tbd.entity.Risultato;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.repository.AppuntamentoRepository;

public class RisultatoMapper {
    public static RisultatoDto mapToRisultatoDto(Risultato risultato) {
        return new RisultatoDto(
            risultato.getId_ris(),
            risultato.getReferto(),
            risultato.getPrescr(),
            risultato.getAppuntamento().getId_app()
        );
    }

    public static Risultato mapToRisultato(RisultatoDto risultatoDto, AppuntamentoRepository appuntamentoRepository) {
        return new Risultato(
            risultatoDto.getId_ris(),
            risultatoDto.getReferto(),
            risultatoDto.getPrescr(),
            appuntamentoRepository.findById(risultatoDto.getId_appuntamento()).
                orElseThrow(() -> new ResourceNotFoundException("Appuntamento non esiste per l'id dato : " + risultatoDto.getId_appuntamento()))
        );
    }
}