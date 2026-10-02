package dev.java10x.cadastroDeNinjas.Missoes.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //Get mandar uma requisção para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissao(){
        return "Listando todas as missões";
    }

    //Post mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada com sucesso";
    }

    //Put -- mandar uma requisição para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }


    //Delete -- mandar uma requisição para deletar uma missao
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }

}
