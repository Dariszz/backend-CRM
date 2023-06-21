package backendcrm.br.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cliente")

public class Cliente {

    //id, nome, email, telefone, cpf, cep
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    private String nome, email, telefone, cpf;
    private int cep;
    private double pontuacao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cupom> cupons = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    List<TicketSuporte> tickets = new ArrayList<>();

}