package tbd.progetto_tbd.mapper;

import tbd.progetto_tbd.dto.SlotDto;
import tbd.progetto_tbd.entity.Slot;
import tbd.progetto_tbd.repository.AppuntamentoRepository;

public class SlotMapper {
    public static SlotDto mapToSlotDto(Slot slot) {
        return new SlotDto(
            slot.getId_slot(),
            slot.getDataSlot(),
            slot.getOraSlot(),
            slot.getOccupato()
        );
    }

    public static Slot mapToSlot(SlotDto slotDto, AppuntamentoRepository appuntamentoRepository) {
        return new Slot(
            slotDto.getId_slot(),
            slotDto.getDataSlot(),
            slotDto.getOraSlot(),
            slotDto.getOccupato()
        );
    }
}