package tbd.progetto_tbd.entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Paziente")
public class Paziente extends Utente{
    public Paziente(Long id_utente, String nome, String cognome, Date data_n, String cf, String email, String password) {
        super(id_utente, nome, cognome, data_n, cf, email, password);
    }
}
