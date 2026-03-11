package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.entity.Gledalac;
import rs.ac.singidunum.entity.Termin;
import rs.ac.singidunum.repo.TerminRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TerminService {

    private final TerminRepository repository;

    public List<Termin> getTermini(){
        return repository.findByDeletedAtIsNull();
    }

    public Optional<Termin> getTerminById(Integer id){

        return repository.findByIdAndDeletedAtIsNull(id);

    }

    public Termin createTermin(Termin model){

        Termin termin = new Termin();

        termin.setDatum(model.getDatum());
        termin.setUtakmica(model.getUtakmica());
        termin.setCreatedAt(LocalDateTime.now());

        return repository.save(termin);

    }

    public Termin updateTermin(Integer id, Termin model){

        Termin termin = getTerminById(id).orElseThrow();

        termin.setDatum(model.getDatum());
        termin.setUtakmica(model.getUtakmica());
        termin.setUpdateAt(LocalDateTime.now());


        return repository.save(termin);

    }

    public void deleteTermin(Integer id){

        Termin termin = getTerminById(id).orElseThrow();

        termin.setDeletedAt(LocalDateTime.now());

        repository.save(termin);

    }


}
