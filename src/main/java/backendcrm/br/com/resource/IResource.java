package backendcrm.br.com.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Interface base que contém um CRUD básico
 * para ser implementado por classes Controllers
 * que implementem esta interface.
 * @param <T1> Dado de retorno
 * @param <T2> Dado de entrada
 */
public interface IResource<T1,T2> {

    ResponseEntity<T1> findById(Long id);

    ResponseEntity<List<T1>> findAll();

    ResponseEntity<T1> save(T2 t2);

    ResponseEntity<Void> update(T2 t2, Long id);

    ResponseEntity<Void> delete(Long id);
    default ResponseStatusException getNotFoundException(String mensagem) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, mensagem);
    }
}
