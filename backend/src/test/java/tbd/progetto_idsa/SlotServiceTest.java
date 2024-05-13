package tbd.progetto_idsa;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import tbd.progetto_tbd.dto.SlotDto;
import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Slot;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.mapper.SlotMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.SlotRepository;
import tbd.progetto_tbd.service.impl.SlotServiceImpl;

public class SlotServiceTest {
        @Test
    public void testCreateSlot() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        SlotDto slotDto = new SlotDto(1L, Date.valueOf("2021-01-01"), Time.valueOf("10:00:00"), false);
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        when(mockSlotRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        SlotDto result = slotService.createSlot(slotDto);

        verify(mockSlotRepository).save(any());
        
        assertTrue(result.getId_slot().equals(slotDto.getId_slot()));
        assertTrue(result.getDataSlot().equals(slotDto.getDataSlot()));
        assertTrue(result.getOraSlot().equals(slotDto.getOraSlot()));
        assertTrue(result.getOccupato().equals(slotDto.getOccupato()));
    }

    @Test
    public void testGetSlotById() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        SlotDto slotDto = new SlotDto(1L, Date.valueOf("2021-01-01"), Time.valueOf("10:00:00"), false);
   
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);        
        when(mockAppuntamentoRepository.findById(any())).thenReturn(Optional.of(mockAppuntamento));
        Slot mappedSlot = SlotMapper.mapToSlot(slotDto, mockAppuntamentoRepository);

        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));
        SlotDto result = slotService.getSlotById(1L);

        verify(mockSlotRepository).findById(1L);

        assertTrue(result.getId_slot().equals(slotDto.getId_slot()));
        assertTrue(result.getDataSlot().equals(slotDto.getDataSlot()));
        assertTrue(result.getOraSlot().equals(slotDto.getOraSlot()));
        assertTrue(result.getOccupato().equals(slotDto.getOccupato()));
    }

    @Test
    public void testGetAllSlots() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        SlotDto slotDto = new SlotDto(1L, Date.valueOf("2021-01-01"), Time.valueOf("10:00:00"), false);

        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        
        Slot mappedSlot = SlotMapper.mapToSlot(slotDto, mockAppuntamentoRepository);
        List<Slot> mappedSlots = new ArrayList<>();
        mappedSlots.add(mappedSlot);
        when(mockSlotRepository.findAll()).thenReturn(mappedSlots);
        List<SlotDto> result = slotService.getAllSlots();

        verify(mockSlotRepository).findAll();

        assertTrue(result.get(0).getId_slot().equals(slotDto.getId_slot()));
        assertTrue(result.get(0).getDataSlot().equals(slotDto.getDataSlot()));
        assertTrue(result.get(0).getOraSlot().equals(slotDto.getOraSlot()));
        assertTrue(result.get(0).getOccupato().equals(slotDto.getOccupato()));
    }

    @Test
    public void testUpdateSlot() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        SlotDto slotDto = new SlotDto(1L, Date.valueOf("2021-01-01"), Time.valueOf("10:00:00"), false);
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        
        Slot mappedSlot = SlotMapper.mapToSlot(slotDto, mockAppuntamentoRepository);
        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));
        when(mockSlotRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        SlotDto result = slotService.updateSlot(1L, slotDto);

        verify(mockSlotRepository).findById(any());

        assertTrue(result.getId_slot().equals(slotDto.getId_slot()));
        assertTrue(result.getDataSlot().equals(slotDto.getDataSlot()));
        assertTrue(result.getOraSlot().equals(slotDto.getOraSlot()));
        assertTrue(result.getOccupato().equals(slotDto.getOccupato()));
    }

    @Test
    public void testDeleteSlot() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        SlotDto slotDto = new SlotDto(1L, Date.valueOf("2021-01-01"), Time.valueOf("10:00:00"), false);
        
        Appuntamento mockAppuntamento = new Appuntamento();
        mockAppuntamento.setId_app(1L);
        when(mockAppuntamentoRepository.findById(anyLong())).thenReturn(Optional.of(mockAppuntamento));
        
        Slot mappedSlot = SlotMapper.mapToSlot(slotDto, mockAppuntamentoRepository);
        when(mockSlotRepository.findById(any())).thenReturn(Optional.of(mappedSlot));

        slotService.deleteSlot(1L);

        verify(mockSlotRepository).deleteById(1L);
    }

    @Test
    public void testGetSlotByIdSlotNotFound() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockSlotRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            slotService.getSlotById(1L);
        });
    }

    @Test
    public void testUpdateSlotNotFound() {
        SlotRepository mockSlotRepository = mock(SlotRepository.class);
        AppuntamentoRepository mockAppuntamentoRepository = mock(AppuntamentoRepository.class);

        SlotServiceImpl slotService = new SlotServiceImpl(mockSlotRepository, mockAppuntamentoRepository);

        when(mockAppuntamentoRepository.findAllById(any())).thenReturn(new ArrayList<>());
        when(mockSlotRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            slotService.updateSlot(1L, new SlotDto());
        });
    }
}
