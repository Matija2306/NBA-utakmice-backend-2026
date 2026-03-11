package rs.ac.singidunum.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.entity.Gledalac;
import rs.ac.singidunum.entity.Rezervacija;

import java.util.List;
import java.util.Optional;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer> {

    List<Rezervacija> findByDeletedAtIsNull();

    Optional<Rezervacija> findByIdAndDeletedAtIsNull(Integer id);

}
