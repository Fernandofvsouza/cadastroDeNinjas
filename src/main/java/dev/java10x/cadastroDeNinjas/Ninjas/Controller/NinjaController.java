package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adcionar ninja(Create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    //Procurar ninja por id(Create)

    //Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninja";
    }


    //Mostrar ninja por id (Read)
    @GetMapping("/listarId")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar Ninja por ID";
    }

    //Alterar dados dos ninjas(Update)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por ID";
    }


    //Deletar Ninja(Deleat)
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return "Ninja deletado por ID";
    }

}
