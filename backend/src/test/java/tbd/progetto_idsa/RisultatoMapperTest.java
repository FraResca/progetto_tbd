package tbd.progetto_idsa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;

import tbd.progetto_tbd.dto.RisultatoDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Risultato;
import tbd.progetto_tbd.mapper.RisultatoMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;

public class RisultatoMapperTest {
    @Test
    public void testMapToRisultatoDto() {
        Appuntamento a = new Appuntamento();
        a.setId_app(1L);
        Risultato r = new Risultato(1L, "referto", "prescr", a);
        RisultatoDto appuntamentoDto = RisultatoMapper.mapToRisultatoDto(r);
        assertTrue(appuntamentoDto.getId_ris().equals(r.getId_ris()));
        assertTrue(appuntamentoDto.getReferto().equals(r.getReferto()));
        assertTrue(appuntamentoDto.getPrescr().equals(r.getPrescr()));
        assertTrue(appuntamentoDto.getId_appuntamento().equals(r.getAppuntamento().getId_app()));
    }

    @Test
    public void testMapToRisultato() {
        RisultatoDto r = new RisultatoDto(1L, "referto", "prescr", 1L);
        AppuntamentoRepository appuntamentoRepository = Mockito.mock(AppuntamentoRepository.class);
        Appuntamento appuntamento = new Appuntamento();
        appuntamento.setId_app(1L);
        when(appuntamentoRepository.findById(1L)).thenReturn(Optional.of(appuntamento));
        
        Risultato risultato = RisultatoMapper.mapToRisultato(r, appuntamentoRepository);
        assertTrue(risultato.getId_ris().equals(r.getId_ris()));
        assertTrue(risultato.getReferto().equals(r.getReferto()));
        assertTrue(risultato.getPrescr().equals(r.getPrescr()));
        assertTrue(risultato.getAppuntamento().getId_app().equals(r.getId_appuntamento()));
    }

    @Test
    public void testRisultatoMapperConstructor() {
        RisultatoMapper risultatoMapper = new RisultatoMapper();
        assertEquals(risultatoMapper.getClass(), RisultatoMapper.class);
    }
}
