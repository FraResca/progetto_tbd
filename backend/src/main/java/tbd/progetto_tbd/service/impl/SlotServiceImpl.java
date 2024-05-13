package tbd.progetto_tbd.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tbd.progetto_tbd.dto.SlotDto;
import tbd.progetto_tbd.entity.Slot;
import tbd.progetto_tbd.exception.ResourceNotFoundException;
import tbd.progetto_tbd.mapper.SlotMapper;
import tbd.progetto_tbd.repository.AppuntamentoRepository;
import tbd.progetto_tbd.repository.SlotRepository;
import tbd.progetto_tbd.service.SlotService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SlotServiceImpl implements SlotService {
    @Autowired
    private SlotRepository slotRepository;
    @Autowired
    private AppuntamentoRepository appuntamentoRepository;

    @Override
    public SlotDto createSlot(SlotDto slotDto) {
        Slot slot = SlotMapper.mapToSlot(slotDto, appuntamentoRepository);
        Slot savedSlot = slotRepository.save(slot);
        return SlotMapper.mapToSlotDto(savedSlot);
    }
    
    @Override
    public SlotDto getSlotById(Long id_slot){
        Slot slot = slotRepository.findById(id_slot)
            .orElseThrow(() -> new ResourceNotFoundException("Slot not found"));
            return SlotMapper.mapToSlotDto(slot);
    }

    @Override
    public List<SlotDto> getAllSlots(){
        List<Slot> slots = slotRepository.findAll();
        return slots.stream().map((slot) -> SlotMapper.mapToSlotDto(slot))
            .collect(Collectors.toList());
    }

    @Override
    public SlotDto updateSlot(Long id_slot, SlotDto updatedSlot){
        Slot slot = slotRepository.findById(id_slot)
            .orElseThrow(() -> new ResourceNotFoundException("Slot not found"));
        slot.setOccupato(updatedSlot.getOccupato());
        Slot updatedSlotObj = slotRepository.save(slot);

        return SlotMapper.mapToSlotDto(updatedSlotObj);
    }

    @Override
    public void deleteSlot(Long id_slot){
        slotRepository.findById(id_slot);
        slotRepository.deleteById(id_slot);
    }

    @Override
    public List<SlotDto> getSlotsNotOccupied(){
        List<Slot> slots = slotRepository.findByOccupato(false);
        return slots.stream().map((slot) -> SlotMapper.mapToSlotDto(slot))
            .collect(Collectors.toList());
    }
}