package backendcrm.br.com.service;

import backendcrm.br.com.model.dto.CupomDTO;
import backendcrm.br.com.service.IService;
import backendcrm.br.com.model.Cupom;
import backendcrm.br.com.resource.CupomRepository;
import backendcrm.br.com.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CupomService implements IService<Cupom, CupomDTO> {

    private final CupomRepository repository;

    @Override
    public Cupom findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> getNotFoundException("Cupom não encontrado"));
    }

    @Override
    public List<Cupom> findAll() {
        return repository.findAll();
    }

    @Override
    public Cupom save(CupomDTO cupomDTO) {
        Cupom cupom = Mapper.INSTANCE.map(cupomDTO, Cupom.class);
        return repository.save(cupom);
    }

    @Override
    public void update(CupomDTO cupomDTO, Long id) {
        Cupom cupom = findById(id);
        Mapper.INSTANCE.map(cupomDTO, cupom);
        repository.save(cupom);
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

}
