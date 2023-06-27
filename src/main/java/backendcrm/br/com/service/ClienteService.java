package backendcrm.br.com.service;

import backendcrm.br.com.model.Cliente;
import backendcrm.br.com.model.ClienteSaldo;
import backendcrm.br.com.model.dto.StatusDTO;
import backendcrm.br.com.service.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@RestController
public class ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Qualifier("mock")
    @Autowired
    RestTemplate rest;
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    public Cliente atualizarPontuacaoCliente(int id, double valorVenda) throws Exception {
        Cliente c = buscarClienteId(id);
        if (c == null) {
            throw new Exception("Cliente não existe");
        }
        double pontuacaoTotal = 0;

        if (valorVenda <= 100) {
            pontuacaoTotal += 20;
        } else if (valorVenda <= 500){
            pontuacaoTotal += 50;
        } else {
            pontuacaoTotal += 100;
        }
        c.setPontuacao(c.getPontuacao() + pontuacaoTotal);
        return clienteDao.save(c);
    }

    public Cliente buscarClienteId(int id) {
        Optional<Cliente> cliente = clienteDao.findById(id);

        if (cliente.isPresent()) {
            return cliente.get();
        } else {
            return null;
        }
    }

    public boolean verificarClienteCadastrado(int id){
        Optional<Cliente> cliente = clienteDao.findById(id);
        if (cliente.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    public String validarVendedor(int id) {
        String url = "https://localhost:8080/rh/validar/cliente/1" + id;
        ResponseEntity<StatusDTO> resp = rest.getForEntity(url, StatusDTO.class);
        StatusDTO c = resp.getBody();
        return c.getStatus();
    }

    public Cliente atualizarSaldo(ClienteSaldo clienteSaldo) throws Exception {
        Cliente c = buscarClienteId(clienteSaldo.getId());
        if (c == null) {
            throw new Exception("Cliente não existe");
        }
        if (clienteSaldo.isOperacaoTipoCredito() == true) {
            c.setSaldo(c.getSaldo() + clienteSaldo.getValorSaldo());
            return clienteDao.save(c);
        } else {
            c.setSaldo(c.getSaldo() - clienteSaldo.getValorSaldo());
            return clienteDao.save(c);
        }
    }
    public ResponseEntity<Double> buscarPedidos(int id) {
        String url = "http://backend-vendas-production.up.railway.app/pedido/buscar/valor/pedido/" + id;
        return rest.getForEntity(url, Double.class);
    }


}
