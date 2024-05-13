package tbd.progetto_idsa;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import tbd.progetto_tbd.dto.VisitaDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Medico;
import tbd.progetto_tbd.entity.Visita;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.mapper.VisitaMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.MedicoRepository;
import tbd.progetto_tbd.repository.VisitaRepository;
import tbd.progetto_tbd.service.impl.VisitaServiceImpl;

public class VisitaServiceTest {
    @Test
    public void testCreateVisita() {
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);

        VisitaServiceImpl visitaService = new VisitaServiceImpl(mockVisitaRepository, mockMedicoRepository);

        VisitaDto visitaDto = new VisitaDto(1L, "Cardiologica", "Descrizione", 50.0F, 1L);
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        Medico mockMedico = new Medico();
        mockMedico.setId_utente(1L);
        when(mockMedicoRepository.findById(anyLong())).thenReturn(Optional.of(mockMedico));
        when(mockVisitaRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        VisitaDto result = visitaService.createVisita(visitaDto);

        verify(mockVisitaRepository).save(any());
        
        assertTrue(result.getId_vis().equals(visitaDto.getId_vis()));
        assertTrue(result.getDescr().equals(visitaDto.getDescr()));
        assertTrue(result.getPrezzo().equals(visitaDto.getPrezzo()));
        assertTrue(result.getId_medico().equals(visitaDto.getId_medico()));
    }

    @Test
    public void testGetVisitaById() {
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);

        VisitaServiceImpl visitaService = new VisitaServiceImpl(mockVisitaRepository, mockMedicoRepository);

        VisitaDto visitaDto = new VisitaDto(1L, "Cardiologica", "Descrizione", 50.0F, 1L);
   
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);        
        when(mockAppuntamentoRepository.findById(any())).thenReturn(Optional.of(mockAppuntamento));
        Medico mockMedico = new Medico();
        mockMedico.setId_utente(1L);
        when(mockMedicoRepository.findById(anyLong())).thenReturn(Optional.of(mockMedico));
        

        Visita mappedVisita = VisitaMapper.mapToVisita(visitaDto, mockMedicoRepository);

        when(mockVisitaRepository.findById(any())).thenReturn(Optional.of(mappedVisita));
        VisitaDto result = visitaService.getVisitaById(1L);

        verify(mockVisitaRepository).findById(1L);

        assertTrue(result.getId_vis().equals(visitaDto.getId_vis()));
        assertTrue(result.getDescr().equals(visitaDto.getDescr()));
        assertTrue(result.getPrezzo().equals(visitaDto.getPrezzo()));
        assertTrue(result.getId_medico().equals(visitaDto.getId_medico()));
    }

    @Test
    public void testGetAllVisite() {
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);

        VisitaServiceImpl visitaService = new VisitaServiceImpl(mockVisitaRepository, mockMedicoRepository);

        VisitaDto visitaDto = new VisitaDto(1L, "Cardiologica", "Descrizione", 50.0F, 1L);

        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        Medico mockMedico = new Medico();
        mockMedico.setId_utente(1L);
        when(mockMedicoRepository.findById(anyLong())).thenReturn(Optional.of(mockMedico));
        

        Visita mappedVisita = VisitaMapper.mapToVisita(visitaDto, mockMedicoRepository);
        List<Visita> mappedVisite = new ArrayList<>();
        mappedVisite.add(mappedVisita);
        when(mockVisitaRepository.findAll()).thenReturn(mappedVisite);
        List<VisitaDto> result = visitaService.getAllVisite();

        verify(mockVisitaRepository).findAll();

        assertTrue(result.get(0).getId_vis().equals(visitaDto.getId_vis()));
        assertTrue(result.get(0).getDescr().equals(visitaDto.getDescr()));
        assertTrue(result.get(0).getPrezzo().equals(visitaDto.getPrezzo()));
        assertTrue(result.get(0).getId_medico().equals(visitaDto.getId_medico()));
    }

    @Test
    public void testUpdateVisita() {
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);

        VisitaServiceImpl visitaService = new VisitaServiceImpl(mockVisitaRepository, mockMedicoRepository);

        VisitaDto visitaDto = new VisitaDto(1L, "Cardiologica", "Descrizione", 50.0F, 1L);;;
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        Medico mockMedico = new Medico();
        mockMedico.setId_utente(1L);
        when(mockMedicoRepository.findById(anyLong())).thenReturn(Optional.of(mockMedico));

        Visita mappedVisita = VisitaMapper.mapToVisita(visitaDto, mockMedicoRepository);
        when(mockVisitaRepository.findById(any())).thenReturn(Optional.of(mappedVisita));
        when(mockVisitaRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        VisitaDto result = visitaService.updateVisita(1L, visitaDto);

        verify(mockVisitaRepository).findById(any());

        assertTrue(result.getId_vis().equals(visitaDto.getId_vis()));
        assertTrue(result.getDescr().equals(visitaDto.getDescr()));
        assertTrue(result.getPrezzo().equals(visitaDto.getPrezzo()));
        assertTrue(result.getId_medico().equals(visitaDto.getId_medico()));
        
    }

    @Test
    public void testDeleteVisita() {
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);

        VisitaServiceImpl visitaService = new VisitaServiceImpl(mockVisitaRepository, mockMedicoRepository);

        VisitaDto visitaDto = new VisitaDto(1L, "Cardiologica", "Descrizione", 50.0F, 1L);;;
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        Medico mockMedico = new Medico();
        mockMedico.setId_utente(1L);
        when(mockMedicoRepository.findById(anyLong())).thenReturn(Optional.of(mockMedico));

        Visita mappedVisita = VisitaMapper.mapToVisita(visitaDto, mockMedicoRepository);
        when(mockVisitaRepository.findById(any())).thenReturn(Optional.of(mappedVisita));

        visitaService.deleteVisita(1L);

        verify(mockVisitaRepository).deleteById(1L);
    }

    @Test
    public void testGetVisitaByIdVisitaNotFound() {
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);

        VisitaServiceImpl visitaService = new VisitaServiceImpl(mockVisitaRepository, mockMedicoRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockVisitaRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            visitaService.getVisitaById(1L);
        });
    }

    @Test
    public void testUpdateVisitaNotFound() {
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);

        VisitaServiceImpl visitaService = new VisitaServiceImpl(mockVisitaRepository, mockMedicoRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockVisitaRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            visitaService.updateVisita(1L, new VisitaDto());
        });
    }
}
