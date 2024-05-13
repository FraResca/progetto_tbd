package tbd.progetto_tbd.service;

import java.util.List;

import tbd.progetto_tbd.dto.MedicoDto;

public interface MedicoService {
    MedicoDto createMedico(MedicoDto medicoDto);
    MedicoDto getMedicoById(Long id_utente);
    List<MedicoDto> getAllMedici();
    MedicoDto updateMedico(Long id_utente, MedicoDto updatedMedico);
    void deleteMedico(Long id_utente);
    MedicoDto getMedicoByEmail(String email);
}