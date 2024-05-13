package tbd.progetto_idsa;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import tbd.progetto_tbd.dto.RisultatoDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Risultato;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.mapper.RisultatoMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.PazienteRepository;
import tbd.progetto_tbd.repository.RisultatoRepository;
import tbd.progetto_tbd.service.impl.RisultatoServiceImpl;


public class RisultatoServiceTest {
    @Test
    public void testCreateRisultato() {
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);

        RisultatoServiceImpl risultatoService = new RisultatoServiceImpl(mockRisultatoRepository, mockAppuntamentoRepository, mockPazienteRepository);

        RisultatoDto risultatoDto = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        when(mockRisultatoRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        RisultatoDto result = risultatoService.createRisultato(risultatoDto);

        verify(mockRisultatoRepository).save(any());

        assertTrue(result.getId_ris().equals(risultatoDto.getId_ris()));
        assertTrue(result.getReferto().equals(risultatoDto.getReferto()));
        assertTrue(result.getPrescr().equals(risultatoDto.getPrescr()));
        assertTrue(result.getId_appuntamento().equals(risultatoDto.getId_appuntamento()));   
    }

    @Test
    public void testGetRisultatoById() {
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);

        RisultatoServiceImpl risultatoService = new RisultatoServiceImpl(mockRisultatoRepository, mockAppuntamentoRepository, mockPazienteRepository);

        RisultatoDto risultatoDto = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
   
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);        
        when(mockAppuntamentoRepository.findById(any())).thenReturn(Optional.of(mockAppuntamento));
        Risultato mappedRisultato = RisultatoMapper.mapToRisultato(risultatoDto, mockAppuntamentoRepository);

        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.of(mappedRisultato));
        RisultatoDto result = risultatoService.getRisultatoById(1L);

        verify(mockRisultatoRepository).findById(1L);

        assertTrue(result.getId_ris().equals(risultatoDto.getId_ris()));
        assertTrue(result.getReferto().equals(risultatoDto.getReferto()));
        assertTrue(result.getPrescr().equals(risultatoDto.getPrescr()));
        assertTrue(result.getId_appuntamento().equals(risultatoDto.getId_appuntamento()));

    }

    @Test
    public void testGetAllRisultati() {
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);

        RisultatoServiceImpl risultatoService = new RisultatoServiceImpl(mockRisultatoRepository, mockAppuntamentoRepository, mockPazienteRepository);

        RisultatoDto risultatoDto = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);

        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        
        Risultato mappedRisultato = RisultatoMapper.mapToRisultato(risultatoDto, mockAppuntamentoRepository);
        List<Risultato> mappedRisultati = new ArrayList<>();
        mappedRisultati.add(mappedRisultato);
        when(mockRisultatoRepository.findAll()).thenReturn(mappedRisultati);
        List<RisultatoDto> result = risultatoService.getAllRisultati();

        verify(mockRisultatoRepository).findAll();

        assertTrue(result.get(0).getId_ris().equals(risultatoDto.getId_ris()));
        assertTrue(result.get(0).getReferto().equals(risultatoDto.getReferto()));
        assertTrue(result.get(0).getPrescr().equals(risultatoDto.getPrescr()));
        assertTrue(result.get(0).getId_appuntamento().equals(risultatoDto.getId_appuntamento()));
    }

    @Test
    public void testUpdateRisultato() {
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);

        RisultatoServiceImpl risultatoService = new RisultatoServiceImpl(mockRisultatoRepository, mockAppuntamentoRepository, mockPazienteRepository);

        RisultatoDto risultatoDto = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        
        Risultato mappedRisultato = RisultatoMapper.mapToRisultato(risultatoDto, mockAppuntamentoRepository);
        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.of(mappedRisultato));
        when(mockRisultatoRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        RisultatoDto result = risultatoService.updateRisultato(1L, risultatoDto);

        verify(mockRisultatoRepository).findById(any());

        assertTrue(result.getId_ris().equals(risultatoDto.getId_ris()));
        assertTrue(result.getReferto().equals(risultatoDto.getReferto()));
        assertTrue(result.getPrescr().equals(risultatoDto.getPrescr()));
        assertTrue(result.getId_appuntamento().equals(risultatoDto.getId_appuntamento()));
    }

    @Test
    public void testDeleteRisultato() {
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);

        RisultatoServiceImpl risultatoService = new RisultatoServiceImpl(mockRisultatoRepository, mockAppuntamentoRepository, mockPazienteRepository);

        RisultatoDto risultatoDto = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        
        Risultato mappedRisultato = RisultatoMapper.mapToRisultato(risultatoDto, mockAppuntamentoRepository);
        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.of(mappedRisultato));

        risultatoService.deleteRisultato(1L);

        verify(mockRisultatoRepository).deleteById(1L);
    }

    @Test
    public void testGetRisultatoByIdRisultatoNotFound() {
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);

        RisultatoServiceImpl risultatoService = new RisultatoServiceImpl(mockRisultatoRepository, mockAppuntamentoRepository, mockPazienteRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            risultatoService.getRisultatoById(1L);
        });
    }

    @Test
    public void testUpdateRisultatoNotFound() {
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);

        RisultatoServiceImpl risultatoService = new RisultatoServiceImpl(mockRisultatoRepository, mockAppuntamentoRepository, mockPazienteRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            risultatoService.updateRisultato(1L, new RisultatoDto());
        });
    }

    @Test
    public void testDeleteRisultatoNotFound() {
        RisultatoRepository mockRisultatoRepository = mock(RisultatoRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);
        PazienteRepository mockPazienteRepository = mock(PazienteRepository.class);

        RisultatoServiceImpl risultatoService = new RisultatoServiceImpl(mockRisultatoRepository, mockAppuntamentoRepository, mockPazienteRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockRisultatoRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            risultatoService.deleteRisultato(1L);
        });
    }
}
