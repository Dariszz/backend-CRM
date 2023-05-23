package backendcrm.br.com.resource;

import backendcrm.br.com.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {
}
