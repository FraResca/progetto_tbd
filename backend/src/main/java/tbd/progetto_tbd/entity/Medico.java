package tbd.progetto_tbd.entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Medico")
public class Medico extends Utente {
    @Column(name = "Stipendio", nullable = false)
    private Float stipendio;
    @Column(name = "Specializzazione", nullable = false, unique = true)
    private String specializ;

    public Medico(Long id_utente, String nome, String cognome,
                    Date data_n, String cf, String email, String password,
                    Float stipendio, String specializ) {
        super(id_utente, nome, cognome, data_n, cf, email, password);
        this.stipendio = stipendio;
        this.specializ = specializ;
    }
}
