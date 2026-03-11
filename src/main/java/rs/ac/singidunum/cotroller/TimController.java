package rs.ac.singidunum.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/list")
    public List<Tim> getAllTeams(){

        return service.getTimovi();

    }

    @GetMapping
    public ResponseEntity<Page<Tim>> getAllHoteli(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortMetod
    ){

        if (search != null && !search.trim().isEmpty()){

            return ResponseEntity.ok(service.searchTimovi(search, page, size, sortBy, sortMetod));

        }

        return ResponseEntity.ok(service.getAllTimovi(page, size, sortBy, sortMetod));

    }

    @GetMapping(path = "/{id}")
    public Optional<Tim> getAllTeamsById(@PathVariable Integer id){

        return service.getTimoviById(id);

    }



}
