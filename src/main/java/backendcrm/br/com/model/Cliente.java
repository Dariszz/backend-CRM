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


    // id, nome, email, telefone, cpf, cep
    // criar histórico de cliente (todas as compras etc)
    // criar sistema de VIP
    // tipo de cupom
    // desconto em datas especiais
    // criar um saldo para o cliente, atualizar saldo


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    private String nome, email, telefone, cpf;
    private int cep;
    private double pontuacao, saldo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cupom> cupons = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    List<TicketSuporte> tickets = new ArrayList<>();

}