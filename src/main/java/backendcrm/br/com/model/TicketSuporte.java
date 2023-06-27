package backendcrm.br.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketSuporte {
    @Id
    private Long id;
    @ManyToOne
    private Cliente cliente;
    private String assunto;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreatedDate //spring vai injeta a data sozinho.
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    public enum Status {
        ABERTO, EM_ANDAMENTO, FECHADO
    }
}
