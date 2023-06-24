package backendcrm.br.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteSaldo {

    private int id;
    private double valorSaldo;
    private boolean operacaoTipoCredito;

}
