package tbd.progetto_idsa;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.sql.Time;

import org.junit.Test;

import tbd.progetto_tbd.dto.SlotDto;

public class SlotDtoTest {
    @Test
    public void testEqualsSameObject() {
        SlotDto s = new SlotDto(1L, Date.valueOf("2021-10-10"), Time.valueOf("10:00:00"), false);
        assertTrue(s.equals(s));
    }

    @Test
    public void testId_slot() {
        SlotDto s = new SlotDto(1L, Date.valueOf("2021-10-10"), Time.valueOf("10:00:00"), false);
        assertTrue(s.getId_slot().equals(1L));
    }

    @Test
    public void testSetId_slot() {
        SlotDto s = new SlotDto();
        s.setId_slot(1L);
        assertTrue(s.getId_slot().equals(1L));
    }

    @Test
    public void testGetDataOraSlot() {
        SlotDto s = new SlotDto(1L, Date.valueOf("2021-10-10"), Time.valueOf("10:00:00"), false);
        assertTrue(s.getId_slot().equals(1L));
    }

    @Test
    public void testSetDataOraSlot() {
        SlotDto s = new SlotDto();
        s.setId_slot(1L);
        assertTrue(s.getId_slot().equals(1L));
    }

    @Test
    public void testGetOccupato() {
        SlotDto s = new SlotDto(1L, Date.valueOf("2021-10-10"), Time.valueOf("10:00:00"), false);
        assertTrue(s.getOccupato().equals(false));
    }

    @Test
    public void testSetOccupato() {
        SlotDto s = new SlotDto();
        s.setOccupato(true);
        assertTrue(s.getOccupato().equals(true));
    }
}
