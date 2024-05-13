package tbd.progetto_idsa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tbd.progetto_tbd.dto.VisitaDto;

public class VisitaDtoTest {
    @Test
    public void testEqualsSameObject() {
        VisitaDto v = new VisitaDto(1L, "Cardiologica", "Visita cardiologica", 50F, 1L);
        assertTrue(v.equals(v));
    }

    @Test
    public void testId_vis() {
        VisitaDto v = new VisitaDto(1L, "Cardiologica", "Visita cardiologica", 50F, 1L);
        assertTrue(v.getId_vis().equals(1L));
    }

    @Test
    public void testSetId_vis() {
        VisitaDto v = new VisitaDto();
        v.setId_vis(1L);
        assertTrue(v.getId_vis().equals(1L));
    }

    @Test
    public void testGetTipoVis() {
        VisitaDto v = new VisitaDto(1L, "Cardiologica", "Visita cardiologica", 50F, 1L);
        assertTrue(v.getTipoVis().equals("Cardiologica"));
    }

    @Test
    public void testSetTipoVis() {
        VisitaDto v = new VisitaDto();
        v.setTipoVis("Cardiologica");
        assertTrue(v.getTipoVis().equals("Cardiologica"));
    }

    @Test
    public void testGetDescr() {
        VisitaDto v = new VisitaDto(1L, "Cardiologica", "Visita cardiologica", 50F, 1L);
        assertTrue(v.getDescr().equals("Visita cardiologica"));
    }

    @Test
    public void testSetDescr() {
        VisitaDto v = new VisitaDto();
        v.setDescr("Visita cardiologica");
        assertTrue(v.getDescr().equals("Visita cardiologica"));
    }

    @Test
    public void testGetPrezzo() {
        VisitaDto v = new VisitaDto(1L, "Cardiologica", "Visita cardiologica", 50F, 1L);
        assertTrue(v.getPrezzo().equals(50F));
    }

    @Test
    public void testSetPrezzo() {
        VisitaDto v = new VisitaDto();
        v.setPrezzo(50F);
        assertTrue(v.getPrezzo().equals(50F));
    }

    @Test
    public void testGetIdMedico() {
        VisitaDto v = new VisitaDto(1L, "Cardiologica", "Visita cardiologica", 50F, 1L);
        assertTrue(v.getId_medico().equals(1L));
    }

    @Test
    public void testSetIdMedico() {
        VisitaDto v = new VisitaDto();
        v.setId_medico(1L);
        assertTrue(v.getId_medico().equals(1L));
    }
}
