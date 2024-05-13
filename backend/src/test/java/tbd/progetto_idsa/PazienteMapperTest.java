package tbd.progetto_idsa;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import tbd.progetto_tbd.dto.PazienteDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Paziente;
import tbd.progetto_tbd.mapper.PazienteMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class PazienteMapperTest {
    @Test
    public void testMapToPazienteDto() {
        Paziente paziente = new Paziente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        PazienteDto pazienteDto = PazienteMapper.mapToPazienteDto(paziente);

        assertTrue(paziente.getId_utente().equals(pazienteDto.getId_utente()));
        assertTrue(paziente.getNome().equals(pazienteDto.getNome()));
        assertTrue(paziente.getCognome().equals(pazienteDto.getCognome()));
        assertTrue(paziente.getData_n().equals(pazienteDto.getData_n()));
        assertTrue(paziente.getCf().equals(pazienteDto.getCf()));
        assertTrue(paziente.getEmail().equals(pazienteDto.getEmail()));
        assertTrue(paziente.getPassword().equals(pazienteDto.getPassword()));
    }

    @Test
    public void testMapToPaziente() {
        AppuntamentoRepository appuntamentoRepository = Mockito.mock(AppuntamentoRepository.class);
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        PazienteDto pazienteDto = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");

        Appuntamento a1 = new Appuntamento();
        a1.setId_app(1L);
        Appuntamento a2 = new Appuntamento();
        a2.setId_app(2L);
        Appuntamento a3 = new Appuntamento();
        a3.setId_app(3L);

        List<Appuntamento> as = Arrays.asList(a1, a2, a3);

        when(appuntamentoRepository.findAllById(ids)).thenReturn(as); // Mock the repository call

        Paziente paziente = PazienteMapper.mapToPaziente(pazienteDto, appuntamentoRepository);

        assertTrue(paziente.getId_utente().equals(pazienteDto.getId_utente()));
        assertTrue(paziente.getNome().equals(pazienteDto.getNome()));
        assertTrue(paziente.getCognome().equals(pazienteDto.getCognome()));
        assertTrue(paziente.getData_n().equals(pazienteDto.getData_n()));
        assertTrue(paziente.getCf().equals(pazienteDto.getCf()));
        assertTrue(paziente.getEmail().equals(pazienteDto.getEmail()));
        assertTrue(paziente.getPassword().equals(pazienteDto.getPassword()));
    }

    @Test
    public void testPazienteMapperConstructor() {
        PazienteMapper pazienteMapper = new PazienteMapper();
        assertEquals(PazienteMapper.class, pazienteMapper.getClass());
    }
}
