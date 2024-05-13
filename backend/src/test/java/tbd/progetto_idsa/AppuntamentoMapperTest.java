package tbd.progetto_idsa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.mockito.Mockito;

import tbd.progetto_tbd.dto.AppuntamentoDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Medico;
import tbd.progetto_tbd.entity.Paziente;
import tbd.progetto_tbd.entity.Risultato;
import tbd.progetto_tbd.entity.Slot;
import tbd.progetto_tbd.entity.Visita;
import tbd.progetto_tbd.mapper.AppuntamentoMapper;
import tbd.progetto_tbd.repository.MedicoRepository;
import tbd.progetto_tbd.repository.PazienteRepository;
import tbd.progetto_tbd.repository.RisultatoRepository;
import tbd.progetto_tbd.repository.SlotRepository;
import tbd.progetto_tbd.repository.VisitaRepository;

public class AppuntamentoMapperTest {
    @Test
    public void testMapToAppuntamentoDto() {
        Paziente p = new Paziente();
        Medico m = new Medico();
        Visita v = new Visita();
        Slot s = new Slot();
        Appuntamento appuntamento = new Appuntamento(1L, false, p, m, v, s);
        AppuntamentoDto appuntamentoDto = AppuntamentoMapper.mapToAppuntamentoDto(appuntamento);
        
        assertTrue(appuntamento.getId_app().equals(appuntamentoDto.getId_app()));
        assertTrue(appuntamento.getPagato().equals(appuntamentoDto.getPagato()));
    }

    @Test
    public void testMapToAppuntamento() {
        // Create a sample AppuntamentoDto
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        
        // Create mock repositories
        PazienteRepository pazienteRepository = Mockito.mock(PazienteRepository.class);
        MedicoRepository medicoRepository = Mockito.mock(MedicoRepository.class);
        RisultatoRepository risultatoRepository = Mockito.mock(RisultatoRepository.class);
        VisitaRepository visitaRepository = Mockito.mock(VisitaRepository.class);
        SlotRepository slotRepository = Mockito.mock(SlotRepository.class);
        
        when(pazienteRepository.findById(anyLong())).thenReturn(Optional.of(new Paziente()));
        when(medicoRepository.findById(anyLong())).thenReturn(Optional.of(new Medico()));
        when(risultatoRepository.findById(anyLong())).thenReturn(Optional.of(new Risultato()));
        when(visitaRepository.findById(anyLong())).thenReturn(Optional.of(new Visita()));
        when(slotRepository.findById(anyLong())).thenReturn(Optional.of(new Slot()));

        // Call the method to be tested
        Appuntamento appuntamento = AppuntamentoMapper.mapToAppuntamento(appuntamentoDto, pazienteRepository, medicoRepository, risultatoRepository, visitaRepository, slotRepository);
        
        // Assert the result
        assertEquals(appuntamentoDto.getId_app(), appuntamento.getId_app());
        assertEquals(appuntamentoDto.getPagato(), appuntamento.getPagato());
    }

    @Test
    public void testAppuntamentoMapperConstructor() {
        AppuntamentoMapper appuntamentoMapper = new AppuntamentoMapper();
        assertEquals(appuntamentoMapper.getClass(), AppuntamentoMapper.class);
    }

    @Test
    public void testPazienteNotFound() {
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        PazienteRepository pazienteRepository = Mockito.mock(PazienteRepository.class);
        MedicoRepository medicoRepository = Mockito.mock(MedicoRepository.class);
        RisultatoRepository risultatoRepository = Mockito.mock(RisultatoRepository.class);
        VisitaRepository visitaRepository = Mockito.mock(VisitaRepository.class);
        SlotRepository slotRepository = Mockito.mock(SlotRepository.class);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            when(pazienteRepository.findById(anyLong())).thenReturn(Optional.empty());
            AppuntamentoMapper.mapToAppuntamento(appuntamentoDto, pazienteRepository, medicoRepository, risultatoRepository, visitaRepository, slotRepository);
        });

        String pazienteMessage = "Paziente not found";
        String pazienteException = exception.getMessage();
        assertTrue(pazienteException.contains(pazienteMessage));
    }

    @Test
    public void testMedicoNotFound() {
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        PazienteRepository pazienteRepository = Mockito.mock(PazienteRepository.class);
        MedicoRepository medicoRepository = Mockito.mock(MedicoRepository.class);
        RisultatoRepository risultatoRepository = Mockito.mock(RisultatoRepository.class);
        VisitaRepository visitaRepository = Mockito.mock(VisitaRepository.class);
        SlotRepository slotRepository = Mockito.mock(SlotRepository.class);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            when(pazienteRepository.findById(anyLong())).thenReturn(Optional.of(new Paziente()));
            when(medicoRepository.findById(anyLong())).thenReturn(Optional.empty());
            AppuntamentoMapper.mapToAppuntamento(appuntamentoDto, pazienteRepository, medicoRepository, risultatoRepository, visitaRepository, slotRepository);
        });

        String medicoMessage = "Medico not found";
        String medicoException = exception.getMessage();
        assertTrue(medicoException.contains(medicoMessage));
    }

    @Test
    public void testVisitaNotFound() {
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        PazienteRepository pazienteRepository = Mockito.mock(PazienteRepository.class);
        MedicoRepository medicoRepository = Mockito.mock(MedicoRepository.class);
        RisultatoRepository risultatoRepository = Mockito.mock(RisultatoRepository.class);
        VisitaRepository visitaRepository = Mockito.mock(VisitaRepository.class);
        SlotRepository slotRepository = Mockito.mock(SlotRepository.class);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            when(pazienteRepository.findById(anyLong())).thenReturn(Optional.of(new Paziente()));
            when(medicoRepository.findById(anyLong())).thenReturn(Optional.of(new Medico()));
            when(risultatoRepository.findById(anyLong())).thenReturn(Optional.of(new Risultato()));
            when(visitaRepository.findById(anyLong())).thenReturn(Optional.empty());
            AppuntamentoMapper.mapToAppuntamento(appuntamentoDto, pazienteRepository, medicoRepository, risultatoRepository, visitaRepository, slotRepository);
        });

        String visitaMessage = "Visita not found";
        String visitaException = exception.getMessage();
        assertTrue(visitaException.contains(visitaMessage));
    }

    @Test
    public void testSlotNotFound() {
        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        PazienteRepository pazienteRepository = Mockito.mock(PazienteRepository.class);
        MedicoRepository medicoRepository = Mockito.mock(MedicoRepository.class);
        RisultatoRepository risultatoRepository = Mockito.mock(RisultatoRepository.class);
        VisitaRepository visitaRepository = Mockito.mock(VisitaRepository.class);
        SlotRepository slotRepository = Mockito.mock(SlotRepository.class);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            when(pazienteRepository.findById(anyLong())).thenReturn(Optional.of(new Paziente()));
            when(medicoRepository.findById(anyLong())).thenReturn(Optional.of(new Medico()));
            when(risultatoRepository.findById(anyLong())).thenReturn(Optional.of(new Risultato()));
            when(visitaRepository.findById(anyLong())).thenReturn(Optional.of(new Visita()));
            when(slotRepository.findById(anyLong())).thenReturn(Optional.empty());
            AppuntamentoMapper.mapToAppuntamento(appuntamentoDto, pazienteRepository, medicoRepository, risultatoRepository, visitaRepository, slotRepository);
        });

        String slotMessage = "Slot not found";
        String slotException = exception.getMessage();
        assertTrue(slotException.contains(slotMessage));
    }
}

