package tbd.progetto_tbd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VisitaDto {
    private Long id_vis;
    private String tipoVis;
    private String descr;
    private Float prezzo;
    private Long id_medico;
}