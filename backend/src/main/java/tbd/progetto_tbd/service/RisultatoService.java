package tbd.progetto_tbd.service;

import java.util.List;

import tbd.progetto_tbd.dto.RisultatoDto;

public interface RisultatoService {
    RisultatoDto createRisultato(RisultatoDto risultatoDto);
    RisultatoDto getRisultatoById(Long id_ris);
    List<RisultatoDto> getAllRisultati();
    RisultatoDto updateRisultato(Long id_ris, RisultatoDto updatedRisultato);
    void deleteRisultato(Long id_ris);
    List<RisultatoDto> getRisultatiByPaziente(Long id_utente);
    List<RisultatoDto> getRisultatiByApp(Long id_app);
}