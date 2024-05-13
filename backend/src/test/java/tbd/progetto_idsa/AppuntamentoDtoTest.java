package tbd.progetto_idsa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tbd.progetto_tbd.dto.AppuntamentoDto;

public class AppuntamentoDtoTest {
    @Test
    public void testEqualsSameObject() {
        AppuntamentoDto a = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        assertTrue(a.equals(a));
    }

    @Test
    public void testGetIdAppuntamento() {
        AppuntamentoDto a = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        assertTrue(a.getId_app().equals(1L));
    }

    @Test
    public void testSetIdAppuntamento() {
        AppuntamentoDto a = new AppuntamentoDto();
        a.setId_app(1L);
        assertTrue(a.getId_app().equals(1L));
    }

    @Test
    public void testGetPagato() {
        AppuntamentoDto a = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        assertTrue(a.getPagato().equals(false));
    }

    @Test
    public void testSetPagato() {
        AppuntamentoDto a = new AppuntamentoDto();
        a.setPagato(true);
        assertTrue(a.getPagato().equals(true));
    }

    @Test
    public void testGetIdPaziente() {
        AppuntamentoDto a = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        assertTrue(a.getId_paziente().equals(1L));
    }

    @Test
    public void testSetIdPaziente() {
        AppuntamentoDto a = new AppuntamentoDto();
        a.setId_paziente(1L);
        assertTrue(a.getId_paziente().equals(1L));
    }

    @Test
    public void testGetIdMedico() {
        AppuntamentoDto a = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        assertTrue(a.getId_medico().equals(1L));
    }

    @Test
    public void testSetIdMedico() {
        AppuntamentoDto a = new AppuntamentoDto();
        a.setId_medico(1L);
        assertTrue(a.getId_medico().equals(1L));
    }

    @Test
    public void testGetIdVisita() {
        AppuntamentoDto a = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        assertTrue(a.getId_visita().equals(1L));
    }

    @Test
    public void testSetIdVisita() {
        AppuntamentoDto a = new AppuntamentoDto();
        a.setId_visita(1L);
        assertTrue(a.getId_visita().equals(1L));
    }

    @Test
    public void testGetIdSlot() {
        AppuntamentoDto a = new AppuntamentoDto(1L, false, 1L, 1L, 1L, 1L);
        assertTrue(a.getId_slot().equals(1L));
    }

    @Test
    public void testSetIdSlot() {
        AppuntamentoDto a = new AppuntamentoDto();
        a.setId_slot(1L);
        assertTrue(a.getId_slot().equals(1L));
    }
}
