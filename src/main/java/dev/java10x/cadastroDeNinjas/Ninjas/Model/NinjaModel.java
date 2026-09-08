package dev.java10x.cadastroDeNinjas.Ninjas.Model;

import dev.java10x.cadastroDeNinjas.Missoes.Model.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "tb_cadastro")
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



    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public NinjaModel(String nome, String email, int idade, MissoesModel missoes) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.missoes = missoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    public MissoesModel getMissoes() {
        return missoes;
    }

    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }
}
