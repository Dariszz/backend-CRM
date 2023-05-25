package backendcrm.br.com.service;

import backendcrm.br.com.model.Cliente;
import backendcrm.br.com.service.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class ClienteService {

    @Autowired
    ClienteDao clienteDao;

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

}
