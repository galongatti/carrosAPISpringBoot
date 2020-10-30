package webservice.carros.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import webservice.carros.domain.Carro;
import webservice.carros.domain.CarroService;
import webservice.carros.domain.dto.CarroDTO;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.security.access.annotation.Secured;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity get() {
        List<CarroDTO> listaCarros = service.getCarros();
        return ResponseEntity.ok(listaCarros);
        //return new ResponseEntity<>(listaCarros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarrosById(@PathVariable("id") Long id) {

        ResponseEntity result;

        CarroDTO c = service.getCarroById(id);

        return ResponseEntity.ok(c);

    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getCarrosByTipo(@PathVariable("tipo") String tipo) {

        ResponseEntity result;
        List<CarroDTO> c = service.getCarroByTipo(tipo);

        if (!c.isEmpty()) {
            result = ResponseEntity.ok(c);
        } else {
            result = ResponseEntity.noContent()
                    .build();
        }

        return result;
    }

    @PostMapping("")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity post(@RequestBody Carro carro) {

        CarroDTO c = service.save(carro);
        URI location = getUri(c.getId());
        return ResponseEntity.created(location)
                .build();

    }

    @PutMapping("")
    public ResponseEntity put(@RequestBody Carro carro) {

        CarroDTO c = service.update(carro);
        if (c != null) {
            return ResponseEntity.ok(c);
        } else {
            return ResponseEntity.badRequest()
                    .build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long id) {

        service.delete(id);

        return ResponseEntity.ok()
                .build();

    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

}
