package rs.ac.singidunum.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Rezervacija;
import rs.ac.singidunum.entity.Termin;
import rs.ac.singidunum.service.RezervacijaService;
import rs.ac.singidunum.service.TerminService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rezervacije")
@CrossOrigin
@RequiredArgsConstructor
public class RezervacijaController {

    private final RezervacijaService service;

    @GetMapping
    public List<Rezervacija> getTermini(){

        return service.getRezervacije();

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Rezervacija> getRezervacijaById(@PathVariable Integer id){

        return ResponseEntity.of(service.getRezervacijaById(id));

    }

    @PostMapping
    public Rezervacija saveRezervacija(@RequestBody Rezervacija model){

        return service.createRezervacija(model);

    }

    @PutMapping(path = "/{id}")
    public Rezervacija updateRezervacija(@PathVariable Integer id, @RequestBody Rezervacija model){

        return service.updateRezervacija(id, model);

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRezervacija(@PathVariable Integer id){

        service.deleteRezervacija(id);

    }

}
