package backendcrm.br.com.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private Integer desconto;

    //tipo cupom (frete gratis, desconto, compre 2 leve 1)

    private boolean cupomValido;

    @ManyToOne
    private Cliente cliente;
}
