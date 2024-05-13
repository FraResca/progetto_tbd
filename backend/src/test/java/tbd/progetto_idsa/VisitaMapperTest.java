package tbd.progetto_idsa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;

import tbd.progetto_tbd.dto.VisitaDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Medico;
import tbd.progetto_tbd.entity.Visita;
import tbd.progetto_tbd.mapper.VisitaMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.MedicoRepository;

public class VisitaMapperTest {
    @Test
    public void testMapToVisitaDto() {
        Medico m = new Medico();
        Visita v = new Visita(1L, "tipo_vis", "descriz", 10.0f, m);
        VisitaDto visitaDto = VisitaMapper.mapToVisitaDto(v);
        assertTrue(visitaDto.getId_vis().equals(v.getId_vis()));
        assertTrue(visitaDto.getTipoVis().equals(v.getTipoVis()));
        assertTrue(visitaDto.getDescr().equals(v.getDescr()));
        assertTrue(visitaDto.getPrezzo().equals(v.getPrezzo()));
    }

    @Test
    public void testMapToVisita() {
        MedicoRepository medicoRepository = Mockito.mock(MedicoRepository.class);
        AppuntamentoRepository appuntamentoRepository = Mockito.mock(AppuntamentoRepository.class);
        VisitaDto visitaDto = new VisitaDto(1L, "Cardiologica", "Visita cardiologica", 50F, 1L);

        when(medicoRepository.findById(anyLong())).thenReturn(Optional.of(new Medico()));
        when(appuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(new Appuntamento()));

        Visita v = VisitaMapper.mapToVisita(visitaDto, medicoRepository);
        assertTrue(v.getId_vis().equals(visitaDto.getId_vis()));
        assertTrue(v.getTipoVis().equals(visitaDto.getTipoVis()));
        assertTrue(v.getDescr().equals(visitaDto.getDescr()));
        assertTrue(v.getPrezzo().equals(visitaDto.getPrezzo()));
    }

    @Test
    public void testVisitaMapperConstructor() {
        VisitaMapper visitaMapper = new VisitaMapper();
        assertEquals(visitaMapper.getClass(), VisitaMapper.class);
    }
}
