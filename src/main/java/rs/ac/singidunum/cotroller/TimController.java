package rs.ac.singidunum.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Tim;
import rs.ac.singidunum.service.TimService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/timovi")
@CrossOrigin
@RequiredArgsConstructor
public class TimController {

    private final TimService service;

    @GetMapping
    public List<Tim> getAllTeams(){

        return service.getTimovi();

    }

    @GetMapping(path = "/{id}")
    public Optional<Tim> getAllTeamsById(@PathVariable Integer id){

        return service.getTimoviById(id);

    }



}
