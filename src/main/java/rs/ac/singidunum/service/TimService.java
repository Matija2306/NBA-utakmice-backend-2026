package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.entity.Tim;
import rs.ac.singidunum.repo.TimRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimService {

    private final TimRepository repository;

    public List<Tim> getTimovi(){

        return repository.findAll();

    }

    public Page<Tim> getAllTimovi(int page, int size, String sortBy, String sortMetod) {

        Sort sort = sortMetod.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return repository.findAll(pageable);

    }

    public Page<Tim> searchTimovi(String search, int page, int size, String sortBy, String sortMetod) {

        Sort sort = sortMetod.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return repository.findByNazivContainingIgnoreCaseOrSkracenicaContainingIgnoreCase(search, search, pageable);

    }

    public Optional<Tim> getTimoviById(Integer id){

        return repository.findById(id);

    }

}
