package rs.ac.singidunum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.entity.Gledalac;

import java.util.List;
import java.util.Optional;

@Repository
public interface GledalacRepository extends JpaRepository<Gledalac, Integer> {

    List<Gledalac> findByDeletedAtIsNull();

    Optional<Gledalac> findByIdAndDeletedAtIsNull(Integer id);

    Boolean existsByIdAndDeletedAtIsNull(Integer id);

}
