package backendcrm.br.com.service;

import backendcrm.br.com.model.Cupom;
import backendcrm.br.com.service.dao.CupomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CupomService {
    @Autowired
    CupomDao cupomDao;

    public Optional<Cupom> BuscarPeloId(int id) {
        return cupomDao.findById(id);
    }

    public Cupom save(Cupom cupom) {
        return cupomDao.save(cupom);
    }
}
