package dev.java10x.cadastroDeNinjas.Ninjas.Controller;

import dev.java10x.cadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.Model.NinjaModel;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }



    //Adcionar ninja(Create)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.getNome() + " ID: " + novoNinja.getId());
    }



    //Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    @Operation(summary = "Lista todos os ninjas", description = "Rota lista todos os ninjas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninjas não encontrados")
    })
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
    @Operation(summary = "Lista o ninja por ID", description = "Rota lista um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
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
    @Operation(summary = "Altera o ninja pelo ID", description = "Rota altera um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")

    })
    public ResponseEntity<String> alterarNinjaPorId(
            @Parameter(description = "ID do ninja a ser alterado")
            @PathVariable Long id,
            @Parameter(description = "Objeto NinjaDTO com os dados atualizados do ninja")
            @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO novoNinja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if(novoNinja != null){
            return ResponseEntity.status(HttpStatus.OK).body("Ninja com ID: " + id + " atualizado com sucesso para!");
        }else{
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID: " + id + " não encontrado!");
        }

    }


    //Deletar Ninja(Deleat)
    @DeleteMapping("/deletarId/{id}")
    @Operation(summary = "Deleta o ninja pelo ID", description = "Rota deleta um ninja pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deletarNinjaPorId(
            @Parameter(description = "ID do ninja a ser deletado")
            @PathVariable Long id){
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID: " + id + " deletado com sucesso!");

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID: " + id + " não encontrado!");
        }

    }

}
