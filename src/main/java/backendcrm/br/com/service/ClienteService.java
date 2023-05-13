package backendcrm.br.com.service;

import backendcrm.br.com.model.Cliente;
import backendcrm.br.com.service.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ClienteService {

    @Autowired
    ClienteDao clienteDao;

    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }


    public Cliente atualizarPontuacaoCliente(int id, Cliente cliente) throws Exception {
        Cliente c = buscarClienteId(id);
        if (c == null) {
            throw new Exception("Cliente não existe");
        }
        c.setPontuacao(cliente.getPontuacao());
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
