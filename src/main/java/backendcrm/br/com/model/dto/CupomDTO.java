package backendcrm.br.com.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CupomDTO {

    private String nome;

    private Integer desconto;

    private LocalDateTime expira;

}
