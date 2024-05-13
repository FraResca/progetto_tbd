package tbd.progetto_idsa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tbd.progetto_tbd.dto.RisultatoDto;

public class RisultatoDtoTest {
    @Test
    public void testEqualsSameObject() {
        RisultatoDto r = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        assertTrue(r.equals(r));
    }

    @Test
    public void testGetIdRisultato() {
        RisultatoDto r = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        assertTrue(r.getId_ris().equals(1L));
    }

    @Test
    public void testSetIdRisultato() {
        RisultatoDto r = new RisultatoDto();
        r.setId_ris(1L);
        assertTrue(r.getId_ris().equals(1L));
    }

    @Test
    public void testGetReferto() {
        RisultatoDto r = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        assertTrue(r.getReferto().equals("Referto"));
    }

    @Test
    public void testSetReferto() {
        RisultatoDto r = new RisultatoDto();
        r.setReferto("Referto");
        assertTrue(r.getReferto().equals("Referto"));
    }

    @Test
    public void testGetPrescr() {
        RisultatoDto r = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        assertTrue(r.getPrescr().equals("Prescrizione"));
    }

    @Test
    public void testSetPrescr() {
        RisultatoDto r = new RisultatoDto();
        r.setPrescr("Prescrizione");
        assertTrue(r.getPrescr().equals("Prescrizione"));
    }

    @Test
    public void testGetIdAppuntamento() {
        RisultatoDto r = new RisultatoDto(1L, "Referto", "Prescrizione", 1L);
        assertTrue(r.getId_appuntamento().equals(1L));
    }

    @Test
    public void testSetIdAppuntamento() {
        RisultatoDto r = new RisultatoDto();
        r.setId_appuntamento(1L);
        assertTrue(r.getId_appuntamento().equals(1L));
    }
}
