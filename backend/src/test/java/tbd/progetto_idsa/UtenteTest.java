package tbd.progetto_idsa;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import tbd.progetto_tbd.entity.Utente;

class UtenteTest {
    @Test
    void testEqualsSameObject() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(u.equals(u));
    }

    @Test
    void testGetId_utente() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(u.getId_utente() == 1L);
    }

    @Test
    void testSetId_Utente() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        u.setId_utente(2L);
        assertTrue(u.getId_utente() == 2L);
    }

    @Test
    void testGetNome() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(u.getNome().equals("Nome"));
    }

    @Test
    void testSetNome() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        u.setNome("Nome2");
        assertTrue(u.getNome().equals("Nome2"));
    }

    @Test
    void testGetCognome() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(u.getCognome().equals("Cognome"));
    }

    @Test
    void testSetCognome() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        u.setCognome("Cognome2");
        assertTrue(u.getCognome().equals("Cognome2"));
    }

    @Test
    void testGetData_n() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(u.getData_n().equals(Date.valueOf("1999-10-10")));
    }

    @Test
    void testSetData_n() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        u.setData_n(Date.valueOf("1999-10-11"));
        assertTrue(u.getData_n().equals(Date.valueOf("1999-10-11")));
    }

    @Test
    void testGetCf() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(u.getCf().equals("Codice_Fiscale"));
    }

    @Test
    void testSetCf() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        u.setCf("Codice_Fiscale2");
        assertTrue(u.getCf().equals("Codice_Fiscale2"));
    }

    @Test
    void testGetEmail() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(u.getEmail().equals("email@casella.cose"));
    }

    @Test
    void testSetEmail() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        u.setEmail("email2@casella.cose");
        assertTrue(u.getEmail().equals("email2@casella.cose"));
    }

    @Test
    void testGetPassword() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(u.getPassword().equals("Password"));
    }

    @Test
    void testSetPassword() {
        Utente u = new Utente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        u.setPassword("Password2");
        assertTrue(u.getPassword().equals("Password2"));
    }
        
}
