package rs.ac.singidunum.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Gledalac;
import rs.ac.singidunum.service.GledalacService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/gledaoci")
@CrossOrigin
@RequiredArgsConstructor
public class GledalacController {

    private final GledalacService service;

    @GetMapping
    public List<Gledalac> getGledalaci(){

        return service.getGledalac();

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Gledalac> getGledalacById(@PathVariable Integer id){

        return ResponseEntity.of(service.getGledalacById(id));

    }

    @PostMapping
    public Gledalac saveGledalac(@RequestBody Gledalac model){

        return service.createGledalac(model);

    }

    @PutMapping(path = "/{id}")
    public Gledalac updateGledalac(@PathVariable Integer id, @RequestBody Gledalac model){

        return service.updateGledalac(id, model);

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGledalac(@PathVariable Integer id){

        service.deleteGledalac(id);

    }
    
}
