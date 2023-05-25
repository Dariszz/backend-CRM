package backendcrm.br.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private LocalDateTime data;

    private String descricao;

    public enum Tipo {
        CHAMADA, EMAIL, VISITA, OUTROS
    }

}