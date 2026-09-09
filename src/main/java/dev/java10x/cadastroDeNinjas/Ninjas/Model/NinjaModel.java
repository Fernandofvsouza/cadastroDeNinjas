package dev.java10x.cadastroDeNinjas.Ninjas.Model;

import dev.java10x.cadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table( name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String nome;

    private String email;

    private int idade;

    //@ManyToOne um ninja pode ter uma missão, mas uma missão pode ter vários ninjas
    //Many missoes to one Ninja
    @ManyToOne
    @JoinColumn(name = "missoes_id") //foreign key (Chave estrangeira serve para conectar duas tabelas garantindo que um registro em uma tabela se relacione corretamente com um registro de outra tabela)
    private MissoesModel missoes;




}
