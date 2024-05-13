package tbd.progetto_tbd.repository;

import tbd.progetto_tbd.entity.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PazienteRepository extends JpaRepository<Paziente,Long> {
    Paziente findByEmail (String email);
}
