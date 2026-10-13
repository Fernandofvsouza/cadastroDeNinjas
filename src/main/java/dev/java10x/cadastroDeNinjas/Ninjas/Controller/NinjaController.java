package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import dev.java10x.cadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }



    //Adcionar ninja(Create)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }

    //Procurar ninja por id(Create)

    //Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public ResponseEntity<?> listarNinjas(){
        List<NinjaDTO>  ninjas = ninjaService.listarNinjas();
        if(ninjas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista vazia");
        }else {
            return ResponseEntity.ok(ninjas);
        }
    }


    //Mostrar ninja por id (Read)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninjaEncontrado = ninjaService.listarNinjasPorId(id);
        if(ninjaEncontrado == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID: " + id + " não encontrado!");
        }else{
            return ResponseEntity.ok(ninjaEncontrado);
        }
    }

    //Alterar dados dos ninjas(Update)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO novoNinja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body("Ninja com ID: " + id + " atualizado com sucesso para!");
    }


    //Deletar Ninja(Deleat)
    @DeleteMapping("/deletarId/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID: " + id + " deletado com sucesso!");

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID: " + id + " não encontrado!");
        }

    }

}
