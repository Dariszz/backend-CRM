package backendcrm.br.com.service.dao;

import backendcrm.br.com.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CupomDao extends JpaRepository<Cupom, Integer> {
//    void delete(Optional<Cupom> );
}
