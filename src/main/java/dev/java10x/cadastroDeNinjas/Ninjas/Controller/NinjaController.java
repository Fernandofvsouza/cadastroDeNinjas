package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    //Adcionar ninja(Create)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //Procurar ninja por id(Create)

    //Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }


    //Mostrar ninja por id (Read)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    //Alterar dados dos ninjas(Update)
    @PutMapping("/alterarId")
    public String alterarNinjaPorId(){
        return "Alterar Ninja por ID";
    }


    //Deletar Ninja(Deleat)
    @DeleteMapping("/deletarId/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }

}
