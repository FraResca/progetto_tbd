package tbd.progetto_tbd.service;

import java.util.List;

import tbd.progetto_tbd.dto.SlotDto;

public interface SlotService {
    SlotDto createSlot(SlotDto pazienteDto);
    SlotDto getSlotById(Long id_slot);
    List<SlotDto> getAllSlots();
    SlotDto updateSlot(Long id_slot, SlotDto updatedSlot);
    void deleteSlot(Long id_slot);
    List <SlotDto> getSlotsNotOccupied();
}