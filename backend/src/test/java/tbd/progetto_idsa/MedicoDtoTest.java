package tbd.progetto_idsa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.Test;

import tbd.progetto_tbd.dto.MedicoDto;

public class MedicoDtoTest {
    @Test
    public void testEqualsSameObject() {
        MedicoDto m = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        assertTrue(m.equals(m));
    }

    @Test
    public void testGetIdUtente(){
        MedicoDto m = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        assertTrue(m.getId_utente().equals(1L));
    }

    @Test
    public void testSetIdUtente(){
        MedicoDto m = new MedicoDto();
        m.setId_utente(1L);
        assertTrue(m.getId_utente().equals(1L));
    }

    @Test
    public void testGetNome(){
        MedicoDto m = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        assertTrue(m.getNome().equals("Nome"));
    }

    @Test
    public void testSetNome(){
        MedicoDto m = new MedicoDto();
        m.setNome("Nome");
        assertTrue(m.getNome().equals("Nome"));
    }

    @Test
    public void testGetCognome(){
        MedicoDto m = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        assertTrue(m.getCognome().equals("Cognome"));
    }

    @Test
    public void testSetCognome(){
        MedicoDto m = new MedicoDto();
        m.setCognome("Cognome");
        assertTrue(m.getCognome().equals("Cognome"));
    }

    @Test
    public void testGetDataN(){;
        MedicoDto m = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        assertTrue(m.getId_utente().equals(1L));
    }

    @Test
    public void testSetDataN(){
        MedicoDto m = new MedicoDto();
        m.setData_n(Date.valueOf("1999-10-10"));
        assertTrue(m.getData_n().equals(Date.valueOf("1999-10-10")));
    }

    @Test
    public void testGetCf(){
        MedicoDto m = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        assertTrue(m.getCf().equals("Codice_Fiscale"));
    }

    @Test
    public void testSetCf(){
        MedicoDto m = new MedicoDto();
        m.setCf("Codice_Fiscale");
        assertTrue(m.getCf().equals("Codice_Fiscale"));
    }

    @Test
    public void testGetEmail(){
        MedicoDto m = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        assertTrue(m.getEmail().equals("email@casella.cose"));
    }

    @Test
    public void testSetEmail(){
        MedicoDto m = new MedicoDto();
        m.setEmail("email@casella.cose");
        assertTrue(m.getEmail().equals("email@casella.cose"));
    }

    @Test
    public void testGetPassword(){
        MedicoDto m = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        assertTrue(m.getId_utente().equals(1L));
    }

    @Test
    public void testSetPassword(){
        MedicoDto m = new MedicoDto();
        m.setPassword("Password");
        assertTrue(m.getPassword().equals("Password"));
    }

    @Test
    public void testGetStipendio(){
        MedicoDto m = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        assertTrue(m.getStipendio().equals(1000.0f));
    }

    @Test
    public void testSetStipendio(){
        MedicoDto m = new MedicoDto();
        m.setStipendio(1000.0f);
        assertTrue(m.getStipendio().equals(1000.0f));
    }

    @Test
    public void testGetSpecializ(){
        MedicoDto m = new MedicoDto(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f, "Specializ");
        assertTrue(m.getSpecializ().equals("Specializ"));
    }

    @Test
    public void testSetSpecializ(){
        MedicoDto m = new MedicoDto();
        m.setSpecializ("Specializ");
        assertTrue(m.getSpecializ().equals("Specializ"));
    }
}