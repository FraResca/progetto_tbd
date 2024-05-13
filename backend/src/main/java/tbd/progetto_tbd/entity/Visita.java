package tbd.progetto_tbd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Visita")
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vis;
    @Column(name = "Tipo_visita", nullable = false)
    private String tipoVis;
    @Column(name = "Descrizione", nullable = true)
    private String descr;
    @Column(name = "Prezzo", nullable = false)
    private Float prezzo;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
}
