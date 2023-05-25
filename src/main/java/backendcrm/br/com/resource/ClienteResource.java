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
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPontuacao(@PathVariable Integer id, @RequestParam BigDecimal preco) {
        clienteService.atualizarPontuacao(id, preco);
        return ResponseEntity.ok().build();
    } //http://localhost:8080/cadastro/69?preco=171,69 URL
    //Semi-Pronto, faltando apenas pegar a requisição de id e valor da compra do grupo de Compras.


}
