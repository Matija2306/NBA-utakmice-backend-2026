package rs.ac.singidunum.service;

import lombok.RequiredArgsConstructor;
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

    public Optional<Tim> getTimoviById(Integer id){

        return repository.findById(id);

    }

}
