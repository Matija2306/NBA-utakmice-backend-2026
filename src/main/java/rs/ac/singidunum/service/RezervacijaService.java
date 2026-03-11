package rs.ac.singidunum.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.entity.Gledalac;
import rs.ac.singidunum.entity.Rezervacija;
import rs.ac.singidunum.entity.Termin;
import rs.ac.singidunum.repo.GledalacRepository;
import rs.ac.singidunum.repo.RezervacijaRepository;
import rs.ac.singidunum.repo.TerminRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RezervacijaService {

    private final RezervacijaRepository repository;
    private final GledalacRepository gledalacRepository;
    private final TerminRepository terminRepository;

    public List<Rezervacija> getRezervacije() {
        return repository.findByDeletedAtIsNull();
    }

    public Optional<Rezervacija> getRezervacijaById(Integer id) {

        return repository.findByIdAndDeletedAtIsNull(id);

    }

    public Rezervacija createRezervacija(Rezervacija model) {

        Rezervacija rezervacija = new Rezervacija();

        if (!gledalacRepository.existsByIdAndDeletedAtIsNull(model.getGledalac().getId()))
            throw new RuntimeException("GLEDALAC_NOT_FOUND");

        Gledalac gledalac = new Gledalac();
        gledalac.setId(model.getGledalac().getId());
        rezervacija.setGledalac(gledalac);

        if (!terminRepository.existsByIdAndDeletedAtIsNull(model.getTermin().getId()))
            throw new RuntimeException("TERMIN_NOT_FOUND");

        Termin termin = new Termin();
        termin.setId(model.getTermin().getId());
        rezervacija.setTermin(termin);

        rezervacija.setBrojKarata(model.getBrojKarata());

        rezervacija.setCreatedAt(LocalDateTime.now());

        return repository.save(rezervacija);
    }

    public Rezervacija updateRezervacija(Integer id, Rezervacija model) {

        Rezervacija rezervacija = this.getRezervacijaById(id).orElseThrow();

        Gledalac gledalac = new Gledalac();
        gledalac.setId(model.getGledalac().getId());
        rezervacija.setGledalac(gledalac);

        Termin termin = new Termin();
        termin.setId(model.getTermin().getId());
        rezervacija.setTermin(termin);

        rezervacija.setBrojKarata(model.getBrojKarata());

        rezervacija.setUpdateAt(LocalDateTime.now());

        return repository.save(rezervacija);

    }

    public void deleteRezervacija(Integer id) {

        Rezervacija rezervacija = getRezervacijaById(id).orElseThrow();

        rezervacija.setDeletedAt(LocalDateTime.now());

        repository.save(rezervacija);

    }
}
