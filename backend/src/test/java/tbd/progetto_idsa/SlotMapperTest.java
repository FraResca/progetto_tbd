package tbd.progetto_idsa;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;

import org.junit.Test;
import org.mockito.Mockito;

import tbd.progetto_tbd.dto.SlotDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Slot;
import tbd.progetto_tbd.mapper.SlotMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;

public class SlotMapperTest {
    @Test
    public void testMapToSlotDto() {
        Appuntamento a = new Appuntamento();
        a.setId_app(1L);
        Slot s = new Slot(1L, Date.valueOf("2021-01-01"), Time.valueOf("10:00:00"), false);
        SlotDto sDto = SlotMapper.mapToSlotDto(s);
        assertTrue(sDto.getId_slot().equals(1L));
        assertTrue(sDto.getDataSlot().equals(Date.valueOf("2021-01-01")));
        assertTrue(sDto.getOraSlot().equals(Time.valueOf("10:00:00")));
        assertTrue(sDto.getOccupato().equals(false));
    }

    @Test
    public void testMapToSlot() {
        SlotDto sDto = new SlotDto(1L, Date.valueOf("2021-01-01"), Time.valueOf("10:00:00"), false);
        AppuntamentoRepository appuntamentoRepository = Mockito.mock(AppuntamentoRepository.class);
        Appuntamento a = new Appuntamento();
        a.setId_app(1L);
        
        when(appuntamentoRepository.findById(1L)).thenReturn(java.util.Optional.of(a));
        
        Slot s = SlotMapper.mapToSlot(sDto, appuntamentoRepository);
        assertTrue(s.getId_slot().equals(1L));
        assertTrue(s.getDataSlot().equals(Date.valueOf("2021-01-01")));
        assertTrue(s.getOraSlot().equals(Time.valueOf("10:00:00")));
        assertTrue(s.getOccupato().equals(false));
    }

    @Test
    public void testSlotMapperConstructor() {
        SlotMapper slotMapper = new SlotMapper();
        assertTrue(slotMapper instanceof SlotMapper);
    }
}
