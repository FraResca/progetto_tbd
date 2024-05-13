package tbd.progetto_idsa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;
import org.mockito.Mockito;

import tbd.progetto_tbd.dto.MedicoDto;
import tbd.progetto_tbd.entity.Medico;
import tbd.progetto_tbd.mapper.MedicoMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.VisitaRepository;

public class MedicoMapperTest {
    @Test
    public void testMapToMedicoDto() {
        Medico medico = new Medico(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f , "Specializzazione");
        MedicoDto medicoDto = MedicoMapper.mapToMedicoDto(medico);

        assertTrue(medico.getId_utente().equals(medicoDto.getId_utente()));
        assertTrue(medico.getNome().equals(medicoDto.getNome()));
        assertTrue(medico.getCognome().equals(medicoDto.getCognome()));
        assertTrue(medico.getData_n().equals(medicoDto.getData_n()));
        assertTrue(medico.getCf().equals(medicoDto.getCf()));
        assertTrue(medico.getEmail().equals(medicoDto.getEmail()));
        assertTrue(medico.getPassword().equals(medicoDto.getPassword()));
        assertTrue(medico.getStipendio().equals(medicoDto.getStipendio()));
        assertTrue(medico.getSpecializ().equals(medicoDto.getSpecializ()));
    }

    @Test
    public void testMapToMedico() {
        AppuntamentoRepository appuntamentoRepository = Mockito.mock(AppuntamentoRepository.class);
        VisitaRepository visitaRepository = Mockito.mock(VisitaRepository.class);
        MedicoDto m = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        Medico medico = MedicoMapper.mapToMedico(m, appuntamentoRepository, visitaRepository);

        assertTrue(m.getId_utente().equals(medico.getId_utente()));
        assertTrue(m.getNome().equals(medico.getNome()));
        assertTrue(m.getCognome().equals(medico.getCognome()));
        assertTrue(m.getData_n().equals(medico.getData_n()));
        assertTrue(m.getCf().equals(medico.getCf()));
        assertTrue(m.getEmail().equals(medico.getEmail()));
        assertTrue(m.getPassword().equals(medico.getPassword()));
        assertTrue(m.getStipendio().equals(medico.getStipendio()));
        assertTrue(m.getSpecializ().equals(medico.getSpecializ()));
    }

    @Test
    public void testMedicoMapperConstructor() {
        MedicoMapper medicoMapper = new MedicoMapper();
        assertEquals(medicoMapper.getClass(), MedicoMapper.class);
    }
}
