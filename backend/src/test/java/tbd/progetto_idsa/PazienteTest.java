package tbd.progetto_idsa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import tbd.progetto_tbd.entity.Paziente;

public class PazienteTest {
    @Test
    void testEqualsSameObject() {
        Paziente p = new Paziente(1L, "Nome", "Cognome", Date.valueOf("1999-10-10"), "Codice_Fiscale", "email@casella.cose", "Password");
        assertTrue(p.equals(p));
    }
}
