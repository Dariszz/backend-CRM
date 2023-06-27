package backendcrm.br.com.service;

import backendcrm.br.com.model.Cupom;
import backendcrm.br.com.service.dao.CupomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CupomService {
    @Autowired
    CupomDao cupomDao;
    public Cupom BuscarPeloId(int id) {
        Optional<Cupom> c = cupomDao.findById(id);
        if (c.isPresent()){
            return c.get();
        } else{
            return null;
        }
    }
    public Cupom save(Cupom cupom) {
        return cupomDao.save(cupom);
    }
    public Cupom cancelar(int id) {
        Cupom c = BuscarPeloId(id);
    c.setCupomValido(false);
    return cupomDao.save(c);
    }
    public boolean checarCupons(int idCliente) {
        Optional<Cupom> c = cupomDao.findById(idCliente);
        if (c.isPresent()) {
            return true;
        } else {
            return false;
        }

    }
}
