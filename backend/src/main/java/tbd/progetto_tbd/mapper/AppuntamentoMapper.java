package tbd.progetto_tbd.mapper;

import tbd.progetto_tbd.dto.AppuntamentoDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.repository.MedicoRepository;
import tbd.progetto_tbd.repository.PazienteRepository;
import tbd.progetto_tbd.repository.RisultatoRepository;
import tbd.progetto_tbd.repository.SlotRepository;
import tbd.progetto_tbd.repository.VisitaRepository;

public class AppuntamentoMapper {
    public static AppuntamentoDto mapToAppuntamentoDto(Appuntamento appuntamento) {
        return new AppuntamentoDto(
            appuntamento.getId_app(),
            appuntamento.getPagato(),
            appuntamento.getPaziente().getId_utente(),
            appuntamento.getMedico().getId_utente(),
            appuntamento.getVisita().getId_vis(),
            appuntamento.getSlot().getId_slot()
        );
    }

    public static Appuntamento mapToAppuntamento(AppuntamentoDto appuntamentoDto, PazienteRepository pazienteRepository, MedicoRepository medicoRepository, RisultatoRepository risultatoRepository, VisitaRepository visitaRepository, SlotRepository slotRepository) {
        return new Appuntamento(
            appuntamentoDto.getId_app(),
            appuntamentoDto.getPagato(),
            pazienteRepository.findById(appuntamentoDto.getId_paziente()).orElseThrow(() -> new ResourceNotFoundException("Paziente not found")),
            medicoRepository.findById(appuntamentoDto.getId_medico()).orElseThrow(() -> new ResourceNotFoundException("Medico not found")),
            visitaRepository.findById(appuntamentoDto.getId_visita()).orElseThrow(() -> new ResourceNotFoundException("Visita not found")),
            slotRepository.findById(appuntamentoDto.getId_slot()).orElseThrow(() -> new ResourceNotFoundException("Slot not found"))
        );
    }
}
