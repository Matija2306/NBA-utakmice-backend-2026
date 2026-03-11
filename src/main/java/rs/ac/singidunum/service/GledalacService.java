package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.entity.Gledalac;
import rs.ac.singidunum.repo.GledalacRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GledalacService {

    private final GledalacRepository repository;

    public List<Gledalac> getGledalac(){

        return repository.findByDeletedAtIsNull();

    }

    public Optional<Gledalac> getGledalacById(Integer id){

        return repository.findByIdAndDeletedAtIsNull(id);

    }

    public Gledalac createGledalac(Gledalac model){

        Gledalac gledalac = new Gledalac();

        gledalac.setIme(model.getIme());
        gledalac.setPrezime(model.getPrezime());
        gledalac.setEmail(model.getEmail());
        gledalac.setCreatedAt(LocalDateTime.now());

        return repository.save(gledalac);

    }

    public Gledalac updateGledalac(Integer id, Gledalac model){

        Gledalac gledalac = getGledalacById(id).orElseThrow();

        gledalac.setIme(model.getIme());
        gledalac.setPrezime(model.getPrezime());
        gledalac.setEmail(model.getEmail());
        gledalac.setUpdateAt(LocalDateTime.now());

        return repository.save(gledalac);

    }

    public void deleteGledalac(Integer id){

        Gledalac gledalac = getGledalacById(id).orElseThrow();

        gledalac.setDeletedAt(LocalDateTime.now());

        repository.save(gledalac);

    }
    
}
