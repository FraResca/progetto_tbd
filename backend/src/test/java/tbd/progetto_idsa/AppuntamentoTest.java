package tbd.progetto_idsa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Medico;
import tbd.progetto_tbd.entity.Paziente;
import tbd.progetto_tbd.entity.Slot;
import tbd.progetto_tbd.entity.Visita;

public class AppuntamentoTest {
    @Test
    public void testEqualsSameObject() {
        Paziente p = new Paziente();
        Medico m = new Medico();
        Visita v = new Visita();
        Slot s = new Slot();
        Appuntamento a = new Appuntamento(1L, false, p, m, v, s);
        assertTrue(a.equals(a));
    }

    @Test
    public void testGetIdAppuntamento() {
        Paziente p = new Paziente();
        Medico m = new Medico();
        Visita v = new Visita();
        Slot s = new Slot();
        Appuntamento a = new Appuntamento(1L, false, p, m, v, s);
        assertTrue(a.getId_app().equals(1L));
    }

    @Test
    public void testSetIdAppuntamento() {
        Appuntamento a = new Appuntamento();
        a.setId_app(1L);
        assertTrue(a.getId_app().equals(1L));
    }

    @Test
    public void testGetPagato() {
        Paziente p = new Paziente();
        Medico m = new Medico();
        Visita v = new Visita();
        Slot s = new Slot();
        Appuntamento a = new Appuntamento(1L, false, p, m, v, s);
        assertTrue(a.getPagato().equals(false));
    }

    @Test
    public void testSetPagato() {
        Appuntamento a = new Appuntamento();
        a.setPagato(true);
        assertTrue(a.getPagato().equals(true));
    }

    @Test
    public void testGetPaziente() {
        Paziente p = new Paziente();
        Medico m = new Medico();
        Visita v = new Visita();
        Slot s = new Slot();
        Appuntamento a = new Appuntamento(1L, false, p, m, v, s);
        assertTrue(a.getPaziente().equals(p));
    }

    @Test
    public void testSetPaziente() {
        Paziente p = new Paziente();
        Appuntamento a = new Appuntamento();
        a.setPaziente(p);
        assertTrue(a.getPaziente().equals(p));
    }

    @Test
    public void testGetMedico() {
        Paziente p = new Paziente();
        Medico m = new Medico();
        Visita v = new Visita();
        Slot s = new Slot();
        Appuntamento a = new Appuntamento(1L, false, p, m, v, s);
        assertTrue(a.getMedico().equals(m));
    }

    @Test
    public void testSetMedico() {
        Medico m = new Medico();
        Appuntamento a = new Appuntamento();
        a.setMedico(m);
        assertTrue(a.getMedico().equals(m));
    }

    @Test
    public void testGetVisita() {
        Paziente p = new Paziente();
        Medico m = new Medico();
        Visita v = new Visita();
        Slot s = new Slot();
        Appuntamento a = new Appuntamento(1L, false, p, m, v, s);
        assertTrue(a.getVisita().equals(v));
    }

    @Test
    public void testSetVisita() {
        Visita v = new Visita();
        Appuntamento a = new Appuntamento();
        a.setVisita(v);
        assertTrue(a.getVisita().equals(v));
    }

    @Test
    public void testGetSlot() {
        Paziente p = new Paziente();
        Medico m = new Medico();
        Visita v = new Visita();
        Slot s = new Slot();
        Appuntamento a = new Appuntamento(1L, false, p, m, v, s);
        assertTrue(a.getSlot().equals(s));
    }

    @Test
    public void testSetSlot() {
        Slot s = new Slot();
        Appuntamento a = new Appuntamento();
        a.setSlot(s);
        assertTrue(a.getSlot().equals(s));
    }
}
