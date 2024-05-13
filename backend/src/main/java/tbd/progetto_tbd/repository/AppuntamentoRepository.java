package tbd.progetto_tbd.repository;

import tbd.progetto_tbd.entity.Appuntamento;
import tbd.progetto_tbd.entity.Medico;
import tbd.progetto_tbd.entity.Paziente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppuntamentoRepository extends JpaRepository<Appuntamento,Long> {    
    List<Appuntamento> findByMedico(Medico medico);
    List<Appuntamento> findByPaziente(Paziente paziente);
}
