package tbd.progetto_idsa;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

import tbd.progetto_tbd.entity.Medico;

public class MedicoTest {
    @Test
    public void testEqualsSameObject() {
        Medico m = new Medico(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f , "Specializzazione");        
        assertTrue(m.equals(m));
    }

    @Test
    public void testGetStipendio() {
        Medico medico = new Medico(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f , "Specializzazione");
        assertTrue(medico.getStipendio().equals(1000.0f));
    }

    @Test
    public void testSetStipendio() {
        Medico medico = new Medico();
        medico.setStipendio(1000.0f);
        assertTrue(medico.getStipendio().equals(1000.0f));
    }

    @Test
    public void testGetSpecializ() {
        Medico medico = new Medico(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password", 1000.0f , "Specializzazione");
        assertTrue(medico.getSpecializ().equals("Specializzazione"));
    }

    @Test
    public void testSetSpecializ() {
        Medico medico = new Medico();
        medico.setSpecializ("Specializzazione");
        assertTrue(medico.getSpecializ().equals("Specializzazione"));
    }
}
