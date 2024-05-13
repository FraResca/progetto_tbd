package tbd.progetto_tbd.repository;

import tbd.progetto_tbd.entity.Slot;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot,Long> {
    List<Slot> findByOccupato(Boolean occupato);
}
