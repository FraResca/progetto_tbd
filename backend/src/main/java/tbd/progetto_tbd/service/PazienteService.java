package tbd.progetto_tbd.service;

import java.util.List;

import tbd.progetto_tbd.dto.PazienteDto;

public interface PazienteService {
    PazienteDto createPaziente(PazienteDto pazienteDto);
    PazienteDto getPazienteById(Long id_utente);
    List<PazienteDto> getAllPazienti();
    PazienteDto updatePaziente(Long id_utente, PazienteDto updatedPaziente);
    void deletePaziente(Long id_utente);
    PazienteDto getPazienteByEmail(String email);
}
