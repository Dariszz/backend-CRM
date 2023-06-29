package backendcrm.br.com.resource;

import backendcrm.br.com.model.Cliente;
import backendcrm.br.com.model.ClienteSaldo;
import backendcrm.br.com.model.dto.PontuacaoDTO;
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
    @GetMapping("/verificarCadastro/{id}")
    public boolean verificarClienteCadastrado(@PathVariable int id) {
        return clienteService.verificarClienteCadastrado(id);
    }
    @PostMapping("/pontuacao/{id}/{idPedido}")
    public ResponseEntity<?> atualizarPontuacao(@RequestBody PontuacaoDTO pontuacaoDTO) {
        try {
            return ResponseEntity.ok(clienteService.atualizarPontuacaoCliente(pontuacaoDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/telefone/{id}")
    public ResponseEntity<?> buscarTelefone(@PathVariable int id) {
        try {
            return ResponseEntity.ok(clienteService.buscarTelefone(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/desconto/{id}")
    public ResponseEntity<?> pegarDesconto(@PathVariable int id) {
        try {
            return ResponseEntity.ok(clienteService.pegarDesconto(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/cashback/{id}")
    public ResponseEntity<?> buscarCashback(@PathVariable int id) {
        try {
            return ResponseEntity.ok(clienteService.buscarCashback(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
