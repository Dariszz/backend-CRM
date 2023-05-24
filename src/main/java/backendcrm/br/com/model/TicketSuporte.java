package backendcrm.br.com.model;

import backendcrm.br.com.resource.ClienteResource;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private String assunto;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreatedDate //Basicamente o spring vai injeta a data sozinho.
    private LocalDateTime dataAbertura;

    private LocalDateTime dataFechamento;

    public enum Status {
        ABERTO, EM_ANDAMENTO, FECHADO
    }

}
