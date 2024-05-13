package tbd.progetto_tbd.repository;

import tbd.progetto_tbd.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico,Long> {    
    Medico findByEmail(String email);
}