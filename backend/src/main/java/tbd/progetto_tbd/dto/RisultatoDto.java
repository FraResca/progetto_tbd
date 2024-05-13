package tbd.progetto_tbd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RisultatoDto {
    private Long id_ris;
    private String referto;
    private String prescr;
    private Long id_appuntamento;
}
