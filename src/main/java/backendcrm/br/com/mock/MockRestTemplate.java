package backendcrm.br.com.mock;


import backendcrm.br.com.model.dto.StatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component(value = "mock")
public class MockRestTemplate extends RestTemplate {
    static Map<String, Object> comandos;

    static {
        comandos = new HashMap<>();

        comandos.put("https://localhost:8080/rh/validar/cliente/1",
                StatusDTO.builder()
                        .status("Vendedor.")
                        .build()
        );
        comandos.put("https://localhost:8080/rh/validar/cliente/2",
                StatusDTO.builder()
                        .status("Não encontrado.")
                        .build()
        );
    }
    public <T> ResponseEntity<T> getForEntity(String url, Class<T> reponseType, Object ...uriVariables){

        return  new ResponseEntity<T>((T) comandos.get(url), HttpStatus.OK);
    }
}

