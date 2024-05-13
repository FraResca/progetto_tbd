package tbd.progetto_tbd.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SlotDto {
    private Long id_slot;
    private Date DataSlot;
    private Time OraSlot;
    private Boolean occupato;
}