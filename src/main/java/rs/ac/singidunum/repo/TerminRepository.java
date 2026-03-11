package rs.ac.singidunum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.entity.Termin;

import java.util.List;
import java.util.Optional;

@Repository
public interface TerminRepository extends JpaRepository<Termin, Integer> {

    List<Termin> findByDeletedAtIsNull();

    Optional<Termin> findByIdAndDeletedAtIsNull(Integer id);

    Boolean existsByIdAndDeletedAtIsNull(Integer id);

}
