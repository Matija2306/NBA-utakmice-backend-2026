package rs.ac.singidunum.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.entity.Tim;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimRepository extends JpaRepository<Tim, Integer> {

    List<Tim> findAll();

    Page<Tim> findAll(Pageable pageable);

    Page<Tim> findByNazivContainingIgnoreCaseOrSkracenicaContainingIgnoreCase(String naziv, String skracenica, Pageable pageable);

    Optional<Tim> findById(Integer id);

}
