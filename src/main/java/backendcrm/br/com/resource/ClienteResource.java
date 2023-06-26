package backendcrm.br.com.resource;

import backendcrm.br.com.model.Cliente;
import backendcrm.br.com.model.ClienteSaldo;
import backendcrm.br.com.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cliente")
@RestController

public class ClienteResource {

    @Autowired
    ClienteService clienteService;
    @PostMapping("/cadastro")
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @GetMapping("/buscar/{id}")
    public Cliente buscarClienteId(@PathVariable int id) {
        return clienteService.buscarClienteId(id);
    }

    @PutMapping("/saldo/atualizar")
    public ResponseEntity<?> atualizarSaldo(@RequestBody ClienteSaldo clienteSaldo) {

        try {
            return ResponseEntity.ok(clienteService.atualizarSaldo(clienteSaldo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/pontuacao/{id}/{valorVenda}")
    public ResponseEntity<?> atualizarPontuacao(@PathVariable int id, @PathVariable double valorVenda) {
        try {
            return ResponseEntity.ok(clienteService.atualizarPontuacaoCliente(id, valorVenda));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}
