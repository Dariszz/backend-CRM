package backendcrm.br.com.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Interface base que contém um CRUD básico
 * para ser implementado por classes Services
 * que implementem esta interface.
 * @param <T1> Dado de retorno
 * @param <T2> Dado de entrada
 */
public interface IService<T1, T2> {
        T1 findById(Long id);

        List<T1> findAll();

        T1 save(T2 t2);

        void update(T2 t2, Long id);

        void delete(Long id);

        default ResponseStatusException getNotFoundException(String mensagem) {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, mensagem);
        }

}
