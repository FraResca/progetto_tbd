package tbd.progetto_tbd.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MedicoDto {
    private Long id_utente;
    private String nome;
    private String cognome;
    private Date data_n;
    private String cf;
    private String email;
    private String password;
    private Float stipendio;
    private String specializ;
}