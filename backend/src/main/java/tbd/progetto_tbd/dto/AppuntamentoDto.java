package tbd.progetto_tbd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AppuntamentoDto {
    private Long id_app;
    private Boolean pagato;
    private Long id_paziente;
    private Long id_medico;
    private Long id_visita;
    private Long id_slot;
}
