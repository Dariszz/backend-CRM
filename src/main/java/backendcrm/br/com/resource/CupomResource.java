package backendcrm.br.com.resource;
import backendcrm.br.com.model.Cupom;
import backendcrm.br.com.model.dto.CupomDTO;
import backendcrm.br.com.resource.IResource;
import backendcrm.br.com.service.CupomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@Tag(name = "Cupom")
@RequestMapping("/cupons")
@RequiredArgsConstructor

public class CupomResource implements IResource<Cupom, CupomDTO> {


    private final CupomService service;

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Busca um cupom por ID.")
    public ResponseEntity<Cupom> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    @GetMapping("/all")
    @Operation(summary = "Retorna todos os cupons.")
    public ResponseEntity<List<Cupom>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    @PostMapping
    @Operation(summary = "Salva um novo cupom no banco de dados.")
    public ResponseEntity<Cupom> save(@RequestBody @Valid CupomDTO cupomDTO) {
        return new ResponseEntity<>(service.save(cupomDTO), HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um cupom no banco de dados.")
    public ResponseEntity<Void> update(@RequestBody @Valid CupomDTO cupomDTO, @PathVariable Long id) {
        service.update(cupomDTO, id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um cupom no banco de dados.")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
