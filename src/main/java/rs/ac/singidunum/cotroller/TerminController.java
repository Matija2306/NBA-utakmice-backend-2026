package rs.ac.singidunum.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Termin;
import rs.ac.singidunum.service.TerminService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/termini")
@CrossOrigin
@RequiredArgsConstructor
public class TerminController {
  
    private final TerminService service;
    
    @GetMapping
    public List<Termin> getTermini(){

        return service.getTermini();

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Termin> getTerminById(@PathVariable Integer id){

        return ResponseEntity.of(service.getTerminById(id));

    }

    @PostMapping
    public Termin saveTermin(@RequestBody Termin model){

        return service.createTermin(model);

    }

    @PutMapping(path = "/{id}")
    public Termin updateTermin(@PathVariable Integer id, @RequestBody Termin model){

        return service.updateTermin(id, model);

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTermin(@PathVariable Integer id){

        service.deleteTermin(id);

    }
  
    
    
}
