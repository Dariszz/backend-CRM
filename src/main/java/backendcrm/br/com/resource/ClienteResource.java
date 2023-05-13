package backendcrm.br.com.resource;

import backendcrm.br.com.model.Cliente;
import backendcrm.br.com.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cadastro")
@RestController

public class ClienteResource {

    @Autowired
    ClienteService clienteService;
    @PostMapping("/cliente")
    public Cliente salvarCliente(@RequestBody Cliente cliente) {

        return clienteService.save(cliente);

    }

    @PutMapping("/cliente/pontuacao/{id}")
    public ResponseEntity<?> atualizarPontuacao(@PathVariable int id, @RequestBody Cliente cliente) {

        try {
            return ResponseEntity.ok(clienteService.atualizarPontuacaoCliente(id, cliente));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }


}
