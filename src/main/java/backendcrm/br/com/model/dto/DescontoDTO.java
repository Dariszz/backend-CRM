package backendcrm.br.com.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DescontoDTO {
    private int clienteId;
    private Double valorTotal, desconto;
    private String formaPagamento;
}
