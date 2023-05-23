package backendcrm.br.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cupom {
    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer desconto;

    private LocalDateTime expira;

}
