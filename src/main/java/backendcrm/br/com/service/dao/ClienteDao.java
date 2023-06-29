package backendcrm.br.com.service.dao;

import backendcrm.br.com.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Integer> {
}
