package tbd.progetto_tbd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Risultato")
public class Risultato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ris;
    @Column(name = "Referto", nullable = false)
    private String referto;
    @Column(name = "Prescr", nullable = false)
    private String prescr;

    @OneToOne
    @JoinColumn(name = "id_appuntamento")
    private Appuntamento appuntamento;
}
