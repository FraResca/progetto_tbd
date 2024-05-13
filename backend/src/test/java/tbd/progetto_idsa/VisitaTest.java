package tbd.progetto_idsa;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import tbd.progetto_tbd.entity.Medico;
import tbd.progetto_tbd.entity.Visita;

public class VisitaTest {
    @Test
    public void testEqualsSameObject() {
        Medico m = new Medico();
        Visita v = new Visita(1L, "tipo_vis", "descriz", 10.0f, m);
        assertTrue(v.equals(v));
    }

    @Test
    public void testGetTipoVisita() {
        Medico m = new Medico();
        Visita v = new Visita(1L, "tipo_vis", "descriz", 10.0f, m);
        assertTrue(v.getTipoVis().equals("tipo_vis"));
    }

    @Test
    public void testSetTipoVisita() {
        Visita v = new Visita();
        v.setTipoVis("tipo_vis");
        assertTrue(v.getTipoVis().equals("tipo_vis"));
    }

    @Test
    public void testGetDescrizione() {
        Medico m = new Medico();
        Visita v = new Visita(1L, "tipo_vis", "descriz", 10.0f, m);
        assertTrue(v.getDescr().equals("descriz"));
    }

    @Test
    public void testSetDescrizione() {
        Visita v = new Visita();
        v.setDescr("descriz");
        assertTrue(v.getDescr().equals("descriz"));
    }

    @Test
    public void testGetPrezzo() {
        Medico m = new Medico();
        Visita v = new Visita(1L, "tipo_vis", "descriz", 10.0f, m);
        assertTrue(v.getPrezzo().equals(10.0f));
    }

    @Test
    public void testSetPrezzo() {
        Visita v = new Visita();
        v.setPrezzo(10.0f);
        assertTrue(v.getPrezzo().equals(10.0f));
    }

    @Test
    public void testGetMedico() {
        Medico m = new Medico();
        Visita v = new Visita(1L, "tipo_vis", "descriz", 10.0f, m);
        assertTrue(v.getMedico().equals(m));
    }

    @Test
    public void testSetMedico() {
        Medico m = new Medico();
        Visita v = new Visita();
        v.setMedico(m);
        assertTrue(v.getMedico().equals(m));
    }
}
