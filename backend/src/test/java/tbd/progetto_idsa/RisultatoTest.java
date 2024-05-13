package tbd.progetto_idsa;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Risultato;

public class RisultatoTest {
    @Test
    public void testEqualsSameObject() {
        Appuntamento a = new Appuntamento();
        Risultato r = new Risultato(1L, "referto", "prescr", a);
        assertTrue(r.equals(r));
    }

    @Test
    public void testGetIdRisultato() {
        Appuntamento a = new Appuntamento();
        Risultato r = new Risultato(1L, "referto", "prescr", a);
        assertTrue(r.getId_ris().equals(1L));
    }

    @Test
    public void testSetIdRisultato() {
        Risultato r = new Risultato();
        r.setId_ris(1L);
        assertTrue(r.getId_ris().equals(1L));
    }

    @Test
    public void testGetReferto() {
        Appuntamento a = new Appuntamento();
        Risultato r = new Risultato(1L, "referto", "prescr", a);
        assertTrue(r.getReferto().equals("referto"));
    }

    @Test
    public void testSetReferto() {
        Risultato r = new Risultato();
        r.setReferto("referto");
        assertTrue(r.getReferto().equals("referto"));
    }

    @Test
    public void testGetPrescr() {
        Appuntamento a = new Appuntamento();
        Risultato r = new Risultato(1L, "referto", "prescr", a);
        assertTrue(r.getPrescr().equals("prescr"));
    }

    @Test
    public void testSetPrescr() {
        Risultato r = new Risultato();
        r.setPrescr("prescr");
        assertTrue(r.getPrescr().equals("prescr"));
    }

    @Test
    public void testGetAppuntamento() {
        Appuntamento a = new Appuntamento();
        Risultato r = new Risultato(1L, "referto", "prescr", a);
        assertTrue(r.getAppuntamento().equals(a));
    }

    @Test
    public void testSetAppuntamento() {
        Risultato r = new Risultato();
        Appuntamento a = new Appuntamento();
        r.setAppuntamento(a);
        assertTrue(r.getAppuntamento().equals(a));
    }
}
