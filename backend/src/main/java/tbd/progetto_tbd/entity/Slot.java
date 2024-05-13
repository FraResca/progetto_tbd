package tbd.progetto_tbd.entity;

import java.sql.Date;
import java.sql.Time;

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
@Table(name = "Slot")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_slot;
    @Column(name = "DataOraSlot", nullable = false)
    private Date DataSlot;
    @Column(name = "OraSlot", nullable = false)
    private Time OraSlot;
    @Column(name = "Occupata", nullable = false)
    private Boolean occupato;
}
