package backendcrm.br.com.service;

import backendcrm.br.com.model.Cliente;
import backendcrm.br.com.model.ClienteSaldo;
import backendcrm.br.com.model.dto.DescontoDTO;
import backendcrm.br.com.model.dto.TelefoneDTO;
import backendcrm.br.com.model.dto.ValorVendaDTO;
import backendcrm.br.com.service.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@RestController
public class ClienteService {
    @Autowired
    ClienteDao clienteDao;
    @Autowired
    RestTemplate rest;
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }
    public Cliente atualizarPontuacaoCliente(int idCliente,int idPedido) throws Exception {
        Cliente c = buscarClienteId(idCliente);
        double valorVenda = valorTotal(idPedido);
        if (c == null) {
            throw new Exception("Cliente não existe");
        }
        double pontuacaoTotal = 0;
        if (valorVenda <= 1000) {
            pontuacaoTotal += 20;
        } else if (valorVenda <= 5000){
            pontuacaoTotal += 50;
        } else {
            pontuacaoTotal += 100;
        }
        int vip = 0;
        if (pontuacaoTotal == 200) {
            vip += 1;
        } else if (pontuacaoTotal == 350) {
            vip += 2;
        } else if (pontuacaoTotal == 500) {
            vip += 3;
        }
        double desconto = 0;
        if (vip == 1) {
            desconto = 100;
        } else if (vip == 2) {
            desconto = 250;
        } else if (vip == 3) {
            desconto = 500;
        }
        c.setPontuacao(c.getPontuacao() + pontuacaoTotal);
        c.setVip(c.getVip() + vip);
        c.setDesconto(c.getDesconto() + desconto);
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
    public double valorTotal(int idPedido) {
        String url = "https://backend-vendas-production.up.railway.app/pedido/buscar/valor/pedido/" + idPedido;
        ResponseEntity<ValorVendaDTO> resp = rest.getForEntity(url, ValorVendaDTO.class);
        ValorVendaDTO c = resp.getBody();
        return c.getValorTotal();
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
    public TelefoneDTO buscarTelefone(int id) throws Exception {
        Optional<Cliente> cliente = clienteDao.findById(id);
        if (cliente.isPresent()) {
            TelefoneDTO telefoneDTO = TelefoneDTO.builder()
                    .telefone(cliente.get().getTelefone())
                    .nome(cliente.get().getNome())
                    .build();
            return telefoneDTO;
        } else {
            throw new Exception("Cliente não existe.");
        }
    }

    public DescontoDTO pegarDesconto(int id) throws Exception {
        Optional<Cliente> cliente = clienteDao.findById(id);
        if (cliente.isPresent()) {
            DescontoDTO descontoDTO = DescontoDTO.builder()
                    .desconto(cliente.get().getPontuacao())
                    .build();
            return descontoDTO;
        } else {
            throw new Exception("Cliente não existe.");
        }
    }
}
