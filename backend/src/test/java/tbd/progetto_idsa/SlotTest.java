package tbd.progetto_idsa;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Time;

import org.junit.Test;

import tbd.progetto_tbd.entity.Slot;

public class SlotTest {
    @Test
    public void testEqualsSameObject() {        
        Slot s = new Slot(1L, Date.valueOf("2021-01-01"), Time.valueOf("10:00:00"), false);
        assertTrue(s.equals(s));
    }

    @Test
    public void testGetDataOraSlot() {
        Slot s = new Slot(1L, Date.valueOf("2021-01-01"), Time.valueOf("10:00:00"), false);
        assertTrue(s.getId_slot().equals(1L));
    }

    @Test
    public void testSetDataOraSlot() {
        Slot s = new Slot();
        s.setId_slot(1L);
        assertTrue(s.getId_slot().equals(1L));
    }

    @Test
    public void testGetOccupato() {
        Slot s = new Slot(1L, Date.valueOf("2021-01-01"), Time.valueOf("10:00:00"), false);
        assertTrue(s.getOccupato().equals(false));
    }

    @Test
    public void testSetOccupato() {
        Slot s = new Slot();
        s.setOccupato(true);
        assertTrue(s.getOccupato().equals(true));
    }
}
