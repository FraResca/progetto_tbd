package tbd.progetto_idsa;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import tbd.progetto_tbd.dto.AppuntamentoDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Medico;
import tbd.progetto_tbd.entity.Paziente;
import tbd.progetto_tbd.entity.Risultato;
import tbd.progetto_tbd.entity.Slot;
import tbd.progetto_tbd.entity.Visita;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.mapper.AppuntamentoMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.MedicoRepository;
import tbd.progetto_tbd.repository.PazienteRepository;
import tbd.progetto_tbd.repository.RisultatoRepository;
import tbd.progetto_tbd.repository.SlotRepository;
import tbd.progetto_tbd.repository.VisitaRepository;
import tbd.progetto_tbd.service.impl.AppuntamentoServiceImpl;


public class AppuntamentoServiceTest {
    @Test
    public void testCreateAppuntamento() {
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        SlotRepository mockSlotRepository = mock(SlotRepository.class);

        AppuntamentoServiceImpl appuntamentoService = new AppuntamentoServiceImpl(mockAppuntamentoRepository, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);

        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        
        Paziente mappedPaziente = new Paziente();
        mappedPaziente.setId_utente(1L);
        Medico mappedMedico = new Medico();
        mappedMedico.setId_utente(1L);
        Risultato mappedRisultato = new Risultato();
        mappedRisultato.setId_ris(1L);
        Visita mappedVisita = new Visita();
        mappedVisita.setId_vis(1L);;
        Slot mappedSlot = new Slot();
        mappedSlot.setId_slot(1L);;

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockAppuntamentoRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.of(mappedPaziente));
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.of(mappedMedico));
        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.of(mappedRisultato));
        when(mockVisitaRepository.findById(any())).thenReturn(Optional.of(mappedVisita));
        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));

        AppuntamentoDto result = appuntamentoService.createAppuntamento(appuntamentoDto);

        verify(mockAppuntamentoRepository).save(any());

        assertTrue(result.getId_app().equals(appuntamentoDto.getId_app()));
        assertTrue(result.getPagato().equals(appuntamentoDto.getPagato()));
        assertTrue(result.getId_paziente().equals(appuntamentoDto.getId_paziente()));
        assertTrue(result.getId_medico().equals(appuntamentoDto.getId_medico()));
        assertTrue(result.getId_visita().equals(appuntamentoDto.getId_visita()));
        assertTrue(result.getId_slot().equals(appuntamentoDto.getId_slot()));  
    }

    @Test
    public void testGetAppuntamentoById() {
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        SlotRepository mockSlotRepository = mock(SlotRepository.class);

        AppuntamentoServiceImpl appuntamentoService = new AppuntamentoServiceImpl(mockAppuntamentoRepository, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);

        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        
        Paziente mappedPaziente = new Paziente();
        mappedPaziente.setId_utente(1L);
        Medico mappedMedico = new Medico();
        mappedMedico.setId_utente(1L);
        Risultato mappedRisultato = new Risultato();
        mappedRisultato.setId_ris(1L);
        Visita mappedVisita = new Visita();
        mappedVisita.setId_vis(1L);
        Slot mappedSlot = new Slot();
        mappedSlot.setId_slot(1L);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.of(mappedPaziente));
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.of(mappedMedico));
        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.of(mappedRisultato));
        when(mockVisitaRepository.findById(any())).thenReturn(Optional.of(mappedVisita));
        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));

        Appuntamento mappedAppuntamento = AppuntamentoMapper.mapToAppuntamento(appuntamentoDto, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);
        when(mockAppuntamentoRepository.findById(any())).thenReturn(Optional.of(mappedAppuntamento));
        AppuntamentoDto result = appuntamentoService.getAppuntamentoById(1L);
        
        verify(mockAppuntamentoRepository).findById(any());
        
        assertTrue(result.getId_app().equals(appuntamentoDto.getId_app()));
        assertTrue(result.getPagato().equals(appuntamentoDto.getPagato()));
        assertTrue(result.getId_paziente().equals(appuntamentoDto.getId_paziente()));
        assertTrue(result.getId_medico().equals(appuntamentoDto.getId_medico()));
        assertTrue(result.getId_slot().equals(appuntamentoDto.getId_slot()));
        assertTrue(result.getId_slot().equals(appuntamentoDto.getId_slot()));  
    }

    @Test
    public void testGetAllAppuntamenti() {
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        SlotRepository mockSlotRepository = mock(SlotRepository.class);

        AppuntamentoServiceImpl appuntamentoService = new AppuntamentoServiceImpl(mockAppuntamentoRepository, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);

        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        
        Paziente mappedPaziente = new Paziente();
        mappedPaziente.setId_utente(1L);
        Medico mappedMedico = new Medico();
        mappedMedico.setId_utente(1L);
        Risultato mappedRisultato = new Risultato();
        mappedRisultato.setId_ris(1L);
        Visita mappedVisita = new Visita();
        mappedVisita.setId_vis(1L);
        Slot mappedSlot = new Slot();
        mappedSlot.setId_slot(1L);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.of(mappedPaziente));
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.of(mappedMedico));
        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.of(mappedRisultato));
        when(mockVisitaRepository.findById(any())).thenReturn(Optional.of(mappedVisita));
        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));

        Appuntamento mappedAppuntamento = AppuntamentoMapper.mapToAppuntamento(appuntamentoDto, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);
        List<Appuntamento> mappedAppuntamenti = new ArrayList<>();
        mappedAppuntamenti.add(mappedAppuntamento);
        when(mockAppuntamentoRepository.findAll()).thenReturn(mappedAppuntamenti);
        List<AppuntamentoDto> result = appuntamentoService.getAllAppuntamenti();

        verify(mockAppuntamentoRepository).findAll();

        assertTrue(result.get(0).getId_app().equals(appuntamentoDto.getId_app()));
        assertTrue(result.get(0).getPagato().equals(appuntamentoDto.getPagato()));
        assertTrue(result.get(0).getId_paziente().equals(appuntamentoDto.getId_paziente()));
        assertTrue(result.get(0).getId_medico().equals(appuntamentoDto.getId_medico()));
        assertTrue(result.get(0).getId_visita().equals(appuntamentoDto.getId_visita()));
        assertTrue(result.get(0).getId_slot().equals(appuntamentoDto.getId_slot()));
    }

    @Test
    public void testUpdateAppuntamento() {
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        SlotRepository mockSlotRepository = mock(SlotRepository.class);

        AppuntamentoServiceImpl appuntamentoService = new AppuntamentoServiceImpl(mockAppuntamentoRepository, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);

        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        
        Paziente mappedPaziente = new Paziente();
        mappedPaziente.setId_utente(1L);
        Medico mappedMedico = new Medico();
        mappedMedico.setId_utente(1L);
        Risultato mappedRisultato = new Risultato();
        mappedRisultato.setId_ris(1L);
        Visita mappedVisita = new Visita();
        mappedVisita.setId_vis(1L);
        Slot mappedSlot = new Slot();
        mappedSlot.setId_slot(1L);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.of(mappedPaziente));
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.of(mappedMedico));
        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.of(mappedRisultato));
        when(mockVisitaRepository.findById(any())).thenReturn(Optional.of(mappedVisita));
        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));

        Appuntamento mappedAppuntamento = AppuntamentoMapper.mapToAppuntamento(appuntamentoDto, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);
        when(mockAppuntamentoRepository.findById(any())).thenReturn(Optional.of(mappedAppuntamento));
        when(mockAppuntamentoRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        AppuntamentoDto result = appuntamentoService.updateAppuntamento(1L, appuntamentoDto);

        verify(mockAppuntamentoRepository).findById(any());

        assertTrue(result.getId_app().equals(appuntamentoDto.getId_app()));
        assertTrue(result.getPagato().equals(appuntamentoDto.getPagato()));
        assertTrue(result.getId_paziente().equals(appuntamentoDto.getId_paziente()));
        assertTrue(result.getId_medico().equals(appuntamentoDto.getId_medico()));
        assertTrue(result.getId_visita().equals(appuntamentoDto.getId_visita()));
        assertTrue(result.getId_slot().equals(appuntamentoDto.getId_slot()));
    }

    @Test
    public void testDeleteAppuntamento() {
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        SlotRepository mockSlotRepository = mock(SlotRepository.class);

        AppuntamentoServiceImpl appuntamentoService = new AppuntamentoServiceImpl(mockAppuntamentoRepository, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);

        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        
        Paziente mappedPaziente = new Paziente();
        mappedPaziente.setId_utente(1L);
        Medico mappedMedico = new Medico();
        mappedMedico.setId_utente(1L);
        Risultato mappedRisultato = new Risultato();
        mappedRisultato.setId_ris(1L);
        Visita mappedVisita = new Visita();
        mappedVisita.setId_vis(1L);
        Slot mappedSlot = new Slot();
        mappedSlot.setId_slot(1L);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.of(mappedPaziente));
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.of(mappedMedico));
        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.of(mappedRisultato));
        when(mockVisitaRepository.findById(any())).thenReturn(Optional.of(mappedVisita));
        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));
        
        Appuntamento mappedAppuntamento = AppuntamentoMapper.mapToAppuntamento(appuntamentoDto, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);
        when(mockAppuntamentoRepository.findById(any())).thenReturn(Optional.of(mappedAppuntamento));

        appuntamentoService.deleteAppuntamento(1L);

        verify(mockAppuntamentoRepository).deleteById(1L);
    }

    @Test
    public void testGetAppuntamentiByMedico() {
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        
        AppuntamentoServiceImpl appuntamentoService = new AppuntamentoServiceImpl(mockAppuntamentoRepository, mockPazienteRepository, mockMedicoRepository,mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);

        AppuntamentoDto appuntamentoDto = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        
        Paziente mappedPaziente = new Paziente();
        mappedPaziente.setId_utente(1L);
        Medico mappedMedico = new Medico();
        mappedMedico.setId_utente(1L);
        Risultato mappedRisultato = new Risultato();
        mappedRisultato.setId_ris(1L);
        Visita mappedVisita = new Visita();
        mappedVisita.setId_vis(1L);
        Slot mappedSlot = new Slot();
        mappedSlot.setId_slot(1L);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.of(mappedPaziente));
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.of(mappedMedico));
        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.of(mappedRisultato));
        when(mockVisitaRepository.findById(any())).thenReturn(Optional.of(mappedVisita));
        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));

        Appuntamento mappedAppuntamento = AppuntamentoMapper.mapToAppuntamento(appuntamentoDto, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);
        List<Appuntamento> mappedAppuntamenti = new ArrayList<>();
        mappedAppuntamenti.add(mappedAppuntamento);

        when(mockMedicoRepository.findById(1L)).thenReturn(Optional.of(mappedMedico));
        when(mockAppuntamentoRepository.findByMedico(mappedMedico)).thenReturn(mappedAppuntamenti);

        List<AppuntamentoDto> result = appuntamentoService.getAppuntamentiByMedico(1L);

        verify(mockMedicoRepository, times(2)).findById(1L);
        verify(mockAppuntamentoRepository).findByMedico(mappedMedico);

        assertEquals(mappedAppuntamenti.size(), result.size());
    }

    @Test
    public void testGetAppuntamentoByIdAppuntamentoNotFound() {
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        SlotRepository mockSlotRepository = mock(SlotRepository.class);

        AppuntamentoServiceImpl appuntamentoService = new AppuntamentoServiceImpl(mockAppuntamentoRepository, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);

        when(mockAppuntamentoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            appuntamentoService.getAppuntamentoById(1L);
        });
    }

    @Test
    public void deleteAppuntamentoAppuntamentoNotFound() {
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        SlotRepository mockSlotRepository = mock(SlotRepository.class);

        AppuntamentoServiceImpl appuntamentoService = new AppuntamentoServiceImpl(mockAppuntamentoRepository, mockPazienteRepository, mockMedicoRepository, mockRisultatoRepository, mockVisitaRepository, mockSlotRepository);

        when(mockAppuntamentoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            appuntamentoService.deleteAppuntamento(1L);
        });
    }
}
