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


    public void atualizarPontuacao(Integer id, BigDecimal preco) {
        Cliente cliente = buscarClienteId(id);
        int pontos = cliente.getPontuacao();
        cliente.setPontuacao(pontos + preco.intValue()); //Cada real = 1 ponto
        clienteDao.save(cliente);
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
