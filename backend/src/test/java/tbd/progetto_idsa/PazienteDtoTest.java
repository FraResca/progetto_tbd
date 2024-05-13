package tbd.progetto_idsa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tbd.progetto_tbd.dto.PazienteDto;

public class PazienteDtoTest {
    @Test
    public void testEqualsSameObject() {
        PazienteDto p1 = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        PazienteDto p2 = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(p1.equals(p1));
        assertTrue(p2.equals(p2));
    }

    @Test
    public void testGetIdUtente(){
        List<Long> as = new ArrayList<Long>();
        as.add(1L);
        as.add(2L);
        PazienteDto p = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(p.getId_utente().equals(1L));
    }

    @Test
    public void testSetIdUtente(){
        PazienteDto p = new PazienteDto();
        p.setId_utente(1L);
        assertTrue(p.getId_utente().equals(1L));
    }

    @Test
    public void testGetNome(){
        List<Long> as = new ArrayList<Long>();
        as.add(1L);
        as.add(2L);
        PazienteDto p = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(p.getNome().equals("Nome"));
    }

    @Test
    public void testSetNome(){
        PazienteDto p = new PazienteDto();
        p.setNome("Nome");
        assertTrue(p.getNome().equals("Nome"));
    }

    @Test
    public void testGetCognome(){
        List<Long> as = new ArrayList<Long>();
        as.add(1L);
        as.add(2L);
        PazienteDto p = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(p.getCognome().equals("Cognome"));
    }

    @Test
    public void testSetCognome(){
        PazienteDto p = new PazienteDto();
        p.setCognome("Cognome");
        assertTrue(p.getCognome().equals("Cognome"));
    }

    @Test
    public void testGetDataN(){
        List<Long> as = new ArrayList<Long>();
        as.add(1L);
        as.add(2L);
        PazienteDto p = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(p.getData_n().equals(Date.valueOf("1999-10-10")));
    }

    @Test
    public void testSetDataN(){
        PazienteDto p = new PazienteDto();
        p.setData_n(Date.valueOf("1999-10-10"));
        assertTrue(p.getData_n().equals(Date.valueOf("1999-10-10")));
    }

    @Test
    public void testGetCf(){
        List<Long> as = new ArrayList<Long>();
        as.add(1L);
        as.add(2L);
        PazienteDto p = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(p.getCf().equals("Codice_Fiscale"));
    }

    @Test
    public void testSetCf(){
        PazienteDto p = new PazienteDto();
        p.setCf("Codice_Fiscale");
        assertTrue(p.getCf().equals("Codice_Fiscale"));
    }

    @Test
    public void testGetEmail(){
        List<Long> as = new ArrayList<Long>();
        as.add(1L);
        as.add(2L);
        PazienteDto p = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(p.getEmail().equals("email@casella.cose"));
    }

    @Test
    public void testSetEmail(){
        PazienteDto p = new PazienteDto();
        p.setEmail("email@casella.cose");
        assertTrue(p.getEmail().equals("email@casella.cose"));
    }

    @Test
    public void testGetPassword(){
        List<Long> as = new ArrayList<Long>();
        as.add(1L);
        as.add(2L);
        PazienteDto p = new PazienteDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(p.getPassword().equals("Password"));
    }

    @Test
    public void testSetPassword(){
        PazienteDto p = new PazienteDto();
        p.setPassword("Password");
        assertTrue(p.getPassword().equals("Password"));
    }
}
