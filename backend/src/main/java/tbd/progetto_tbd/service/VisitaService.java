package tbd.progetto_tbd.service;

import java.util.List;

import tbd.progetto_tbd.dto.VisitaDto;

public interface VisitaService {
    VisitaDto createVisita(VisitaDto pazienteDto);
    VisitaDto getVisitaById(Long id_visita);
    List<VisitaDto> getAllVisite();
    VisitaDto updateVisita(Long id_visita, VisitaDto updatedVisita);
    void deleteVisita(Long id_visita);
}
