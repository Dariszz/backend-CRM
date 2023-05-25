package backendcrm.br.com.resource;
import backendcrm.br.com.model.Cupom;
import backendcrm.br.com.service.CupomService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cupons")

public class CupomResource{
    @Autowired
    CupomService service;
    //Buscar Cupom
    @GetMapping("/{id}")
    public ResponseEntity <Cupom> findById(@PathVariable int id) {
        return ResponseEntity.ok(service.BuscarPeloId(id));
    }
    //Salvar Cupom
    @PostMapping
    public ResponseEntity<Cupom> save(@RequestBody @Valid Cupom cupom) {
        return new ResponseEntity<>(service.save(cupom), HttpStatus.CREATED);
    }
    @PutMapping ("/cancelar/{id}")
    public ResponseEntity<Cupom> save(@PathVariable int id) {
        return new ResponseEntity<>(service.cancelar(id), HttpStatus.CREATED);
    }

}
