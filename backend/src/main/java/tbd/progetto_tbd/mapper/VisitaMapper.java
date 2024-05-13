package tbd.progetto_tbd.mapper;

import tbd.progetto_tbd.dto.VisitaDto;
import tbd.progetto_tbd.entity.Visita;
import tbd.progetto_tbd.repository.MedicoRepository;

public class VisitaMapper {
    public static VisitaDto mapToVisitaDto(Visita visita) {
        return new VisitaDto(
            visita.getId_vis(),
            visita.getTipoVis(),
            visita.getDescr(),
            visita.getPrezzo(),
            visita.getMedico().getId_utente()
        );
    }

    public static Visita mapToVisita(VisitaDto visitaDto, MedicoRepository medicoRepository) {
        return new Visita(
            visitaDto.getId_vis(),
            visitaDto.getTipoVis(),
            visitaDto.getDescr(),
            visitaDto.getPrezzo(),
            medicoRepository.findById(visitaDto.getId_medico())
                .orElseThrow(() -> new RuntimeException("Medico non trovato"))
        );
    }
}
