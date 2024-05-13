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

import tbd.progetto_tbd.dto.MedicoDto;
import tbd.progetto_tbd.entity.Medico;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.mapper.MedicoMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.MedicoRepository;
import tbd.progetto_tbd.repository.VisitaRepository;
import tbd.progetto_tbd.service.impl.MedicoServiceImpl;


public class MedicoServiceTest {
    @Test
    public void testCreateMedico() {
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);

        MedicoServiceImpl medicoService = new MedicoServiceImpl(mockMedicoRepository, mockAppuntamentoRepository, mockVisitaRepository);

        MedicoDto medicoDto = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockMedicoRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        MedicoDto result = medicoService.createMedico(medicoDto);

        verify(mockMedicoRepository).save(any());

        assertTrue(result.getId_utente().equals(medicoDto.getId_utente()));
        assertTrue(result.getNome().equals(medicoDto.getNome()));
        assertTrue(result.getCognome().equals(medicoDto.getCognome()));
        assertTrue(result.getData_n().equals(medicoDto.getData_n()));
        assertTrue(result.getCf().equals(medicoDto.getCf()));
        assertTrue(result.getEmail().equals(medicoDto.getEmail()));
        assertTrue(result.getPassword().equals(medicoDto.getPassword()));
    }

    @Test
    public void testGetMedicoById() {
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);

        MedicoServiceImpl medicoService = new MedicoServiceImpl(mockMedicoRepository, mockAppuntamentoRepository, mockVisitaRepository);

        MedicoDto medicoDto = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        Medico mappedMedico = MedicoMapper.mapToMedico(medicoDto, mockAppuntamentoRepository, mockVisitaRepository);
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.of(mappedMedico));
        MedicoDto result = medicoService.getMedicoById(1L);

        verify(mockMedicoRepository).findById(any());
        
        assertTrue(result.getId_utente().equals(medicoDto.getId_utente()));
        assertTrue(result.getNome().equals(medicoDto.getNome()));
        assertTrue(result.getCognome().equals(medicoDto.getCognome()));
        assertTrue(result.getData_n().equals(medicoDto.getData_n()));
        assertTrue(result.getCf().equals(medicoDto.getCf()));
        assertTrue(result.getEmail().equals(medicoDto.getEmail()));
        assertTrue(result.getPassword().equals(medicoDto.getPassword()));
    }

    @Test
    public void testGetAllMedici() {
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);

        MedicoServiceImpl medicoService = new MedicoServiceImpl(mockMedicoRepository, mockAppuntamentoRepository, mockVisitaRepository);

        MedicoDto medicoDto = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        Medico mappedMedico = MedicoMapper.mapToMedico(medicoDto, mockAppuntamentoRepository, mockVisitaRepository);
        List<Medico> mappedMedici = new ArrayList<>();
        mappedMedici.add(mappedMedico);
        when(mockMedicoRepository.findAll()).thenReturn(mappedMedici);
        List<MedicoDto> result = medicoService.getAllMedici();

        verify(mockMedicoRepository).findAll();

        assertTrue(result.get(0).getId_utente().equals(medicoDto.getId_utente()));
        assertTrue(result.get(0).getNome().equals(medicoDto.getNome()));
        assertTrue(result.get(0).getCognome().equals(medicoDto.getCognome()));
        assertTrue(result.get(0).getData_n().equals(medicoDto.getData_n()));
        assertTrue(result.get(0).getCf().equals(medicoDto.getCf()));
        assertTrue(result.get(0).getEmail().equals(medicoDto.getEmail()));
        assertTrue(result.get(0).getPassword().equals(medicoDto.getPassword()));
    }

    @Test
    public void testUpdateMedico() {
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);

        MedicoServiceImpl medicoService = new MedicoServiceImpl(mockMedicoRepository, mockAppuntamentoRepository, mockVisitaRepository);

        MedicoDto medicoDto = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        Medico mappedMedico = MedicoMapper.mapToMedico(medicoDto, mockAppuntamentoRepository, mockVisitaRepository);
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.of(mappedMedico));
        when(mockMedicoRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        MedicoDto result = medicoService.updateMedico(1L, medicoDto);

        verify(mockMedicoRepository).findById(any());

        assertTrue(result.getId_utente().equals(medicoDto.getId_utente()));
        assertTrue(result.getNome().equals(medicoDto.getNome()));
        assertTrue(result.getCognome().equals(medicoDto.getCognome()));
        assertTrue(result.getData_n().equals(medicoDto.getData_n()));
        assertTrue(result.getCf().equals(medicoDto.getCf()));
        assertTrue(result.getEmail().equals(medicoDto.getEmail()));
        assertTrue(result.getPassword().equals(medicoDto.getPassword()));
    }

    @Test
    public void testDeleteMedico() {
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);

        MedicoServiceImpl medicoService = new MedicoServiceImpl(mockMedicoRepository, mockAppuntamentoRepository, mockVisitaRepository);

        MedicoDto medicoDto = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        Medico mappedMedico = MedicoMapper.mapToMedico(medicoDto, mockAppuntamentoRepository, mockVisitaRepository);
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.of(mappedMedico));

        medicoService.deleteMedico(1L);

        verify(mockMedicoRepository).deleteById(1L);
    }

    @Test
    public void testGetMedicoByIdNotFound() {
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);

        MedicoServiceImpl medicoService = new MedicoServiceImpl(mockMedicoRepository, mockAppuntamentoRepository, mockVisitaRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            medicoService.getMedicoById(1L);
        });
    }

    @Test
    public void testUpdateMedicoNotFound() {
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);

        MedicoServiceImpl medicoService = new MedicoServiceImpl(mockMedicoRepository, mockAppuntamentoRepository, mockVisitaRepository);

        MedicoDto medicoDto = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        
        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            medicoService.updateMedico(1L, medicoDto);
        });
    }

    @Test
    public void testDeleteMedicoNotFound() {
        MedicoRepository mockMedicoRepository = mock(MedicoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        VisitaRepository mockVisitaRepository = mock(VisitaRepository.class);

        MedicoServiceImpl medicoService = new MedicoServiceImpl(mockMedicoRepository, mockAppuntamentoRepository, mockVisitaRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockMedicoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            medicoService.deleteMedico(1L);
        });
    }
}
