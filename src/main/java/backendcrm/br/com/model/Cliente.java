package backendcrm.br.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cliente")

public class Cliente {

    //id, nome, email, telefone, cpf, cep
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCliente;

    private String nome, email, telefone, cpf;
    private int cep, pontuacao;


}
