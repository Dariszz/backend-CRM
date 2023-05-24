package backendcrm.br.com.resource;

import backendcrm.br.com.model.Cliente;
import backendcrm.br.com.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    // localhost:8080/clientes/pontuacao/1?preco=1.99
    //@PutMapping("/pontuacao/{id}") //Pode alterar o endpoint se preferir, mas precisa incluir o "{id}"
    //public ResponseEntity<Void> atualizarPontuacao(@PathVariable Integer id, @RequestParam BigDecimal preco) {
        //Aqui faz a lógica para aumenta a pontuação do cliente
    //}


}
