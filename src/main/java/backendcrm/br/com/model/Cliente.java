package backendcrm.br.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    private String nome, email, telefone, cpf;
    private int cep, vip;
    private double pontuacao, saldo, desconto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Cupom> cupons = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    List<TicketSuporte> tickets = new ArrayList<>();

    @PostConstruct //Esse método será evocado sempre que uma nova instância for criada.
    public void init() {
        if (!this.cupons.isEmpty()) return;
                Cupom cupom10 = new Cupom();
        cupom10.setCupomValido(true);
        cupom10.setDesconto(10d);
        cupom10.setNome("Cupom de 10!");

        Cupom cupom25 = new Cupom();
        cupom25.setCupomValido(true);
        cupom25.setDesconto(25d);
        cupom25.setNome("Cupom de 25!");

        Cupom cupom100 = new Cupom();
        cupom100.setCupomValido(true);
        cupom100.setDesconto(100d);
        cupom100.setNome("Cupom de 100!");

        this.cupons.add(cupom10);
        this.cupons.add(cupom25);
        this.cupons.add(cupom100);
        this.cupons.forEach(cupom -> cupom.setId(this.getIdCliente()));
    }

}