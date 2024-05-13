package tbd.progetto_idsa;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import tbd.progetto_tbd.dto.PazienteDto;
import tbd.progetto_tbd.entity.Paziente;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.mapper.PazienteMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.PazienteRepository;
import tbd.progetto_tbd.service.impl.PazienteServiceImpl;


public class PazienteServiceTest {
    @Test
    public void testCreatePaziente() {
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        PazienteServiceImpl pazienteService = new PazienteServiceImpl(mockPazienteRepository, mockAppuntamentoRepository);

        PazienteDto pazienteDto = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockPazienteRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        PazienteDto result = pazienteService.createPaziente(pazienteDto);

        verify(mockPazienteRepository).save(any());

        assertTrue(result.getId_utente().equals(pazienteDto.getId_utente()));
        assertTrue(result.getNome().equals(pazienteDto.getNome()));
        assertTrue(result.getCognome().equals(pazienteDto.getCognome()));
        assertTrue(result.getData_n().equals(pazienteDto.getData_n()));
        assertTrue(result.getCf().equals(pazienteDto.getCf()));
        assertTrue(result.getEmail().equals(pazienteDto.getEmail()));
        assertTrue(result.getPassword().equals(pazienteDto.getPassword()));
          
    }

    @Test
    public void testGetPazienteById() {
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        PazienteServiceImpl pazienteService = new PazienteServiceImpl(mockPazienteRepository, mockAppuntamentoRepository);

        PazienteDto pazienteDto = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        Paziente mappedPaziente = PazienteMapper.mapToPaziente(pazienteDto, mockAppuntamentoRepository);
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.of(mappedPaziente));
        PazienteDto result = pazienteService.getPazienteById(1L);

        verify(mockPazienteRepository).findById(any());
        
        assertTrue(result.getId_utente().equals(pazienteDto.getId_utente()));
        assertTrue(result.getNome().equals(pazienteDto.getNome()));
        assertTrue(result.getCognome().equals(pazienteDto.getCognome()));
        assertTrue(result.getData_n().equals(pazienteDto.getData_n()));
        assertTrue(result.getCf().equals(pazienteDto.getCf()));
        assertTrue(result.getEmail().equals(pazienteDto.getEmail()));
        assertTrue(result.getPassword().equals(pazienteDto.getPassword()));
    }

    @Test
    public void testGetAllPazienti() {
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        PazienteServiceImpl pazienteService = new PazienteServiceImpl(mockPazienteRepository, mockAppuntamentoRepository);

        PazienteDto pazienteDto = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        Paziente mappedPaziente = PazienteMapper.mapToPaziente(pazienteDto, mockAppuntamentoRepository);
        List<Paziente> mappedPazienti = new ArrayList<>();
        mappedPazienti.add(mappedPaziente);
        when(mockPazienteRepository.findAll()).thenReturn(mappedPazienti);
        List<PazienteDto> result = pazienteService.getAllPazienti();

        verify(mockPazienteRepository).findAll();

        assertTrue(result.get(0).getId_utente().equals(pazienteDto.getId_utente()));
        assertTrue(result.get(0).getNome().equals(pazienteDto.getNome()));
        assertTrue(result.get(0).getCognome().equals(pazienteDto.getCognome()));
        assertTrue(result.get(0).getData_n().equals(pazienteDto.getData_n()));
        assertTrue(result.get(0).getCf().equals(pazienteDto.getCf()));
        assertTrue(result.get(0).getEmail().equals(pazienteDto.getEmail()));
        assertTrue(result.get(0).getPassword().equals(pazienteDto.getPassword()));
    }

    @Test
    public void testUpdatePaziente() {
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        PazienteServiceImpl pazienteService = new PazienteServiceImpl(mockPazienteRepository, mockAppuntamentoRepository);

        PazienteDto pazienteDto = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        Paziente mappedPaziente = PazienteMapper.mapToPaziente(pazienteDto, mockAppuntamentoRepository);
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.of(mappedPaziente));
        when(mockPazienteRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        PazienteDto result = pazienteService.updatePaziente(1L, pazienteDto);

        verify(mockPazienteRepository).findById(any());

        assertTrue(result.getId_utente().equals(pazienteDto.getId_utente()));
        assertTrue(result.getNome().equals(pazienteDto.getNome()));
        assertTrue(result.getCognome().equals(pazienteDto.getCognome()));
        assertTrue(result.getData_n().equals(pazienteDto.getData_n()));
        assertTrue(result.getCf().equals(pazienteDto.getCf()));
        assertTrue(result.getEmail().equals(pazienteDto.getEmail()));
        assertTrue(result.getPassword().equals(pazienteDto.getPassword()));
    }

    @Test
    public void testDeletePaziente() {
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        PazienteServiceImpl pazienteService = new PazienteServiceImpl(mockPazienteRepository, mockAppuntamentoRepository);

        PazienteDto pazienteDto = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        Paziente mappedPaziente = PazienteMapper.mapToPaziente(pazienteDto, mockAppuntamentoRepository);
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.of(mappedPaziente));

        pazienteService.deletePaziente(1L);

        verify(mockPazienteRepository).deleteById(1L);
    }

    @Test
    public void testGetPazienteByIdNotFound() {
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        PazienteServiceImpl pazienteService = new PazienteServiceImpl(mockPazienteRepository, mockAppuntamentoRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            pazienteService.getPazienteById(1L);
        });
    }

    @Test
    public void testUpdatePazienteNotFound() {
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        PazienteServiceImpl pazienteService = new PazienteServiceImpl(mockPazienteRepository, mockAppuntamentoRepository);

        PazienteDto pazienteDto = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            pazienteService.updatePaziente(1L, pazienteDto);
        });
    }

    @Test
    public void testDeletePazienteNotFound() {
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        PazienteServiceImpl pazienteService = new PazienteServiceImpl(mockPazienteRepository, mockAppuntamentoRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockPazienteRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            pazienteService.deletePaziente(1L);
        });
    }
}
