package backendcrm.br.com.service.dao;

import backendcrm.br.com.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CupomDao extends JpaRepository<Cupom, Integer> {
//    void delete(Optional<Cupom> );
    @Query("SELECT c FROM Cupom c WHERE c.cliente.idCliente = :idCliente")
    List<Cupom> obterCupons(int idCliente);
}
