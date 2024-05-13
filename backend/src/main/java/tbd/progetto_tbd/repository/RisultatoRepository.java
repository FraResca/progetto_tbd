package tbd.progetto_tbd.repository;

import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Risultato;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RisultatoRepository extends JpaRepository<Risultato,Long> {
    List<Risultato> findByAppuntamento(Appuntamento paziente);
}
