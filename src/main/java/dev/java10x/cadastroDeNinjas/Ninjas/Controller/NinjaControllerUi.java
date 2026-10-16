package dev.java10x.cadastroDeNinjas.Ninjas.Controller;


import dev.java10x.cadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.java10x.cadastroDeNinjas.Ninjas.Service.NinjaService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {
    private final NinjaService ninjaService;


    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();

        model.addAttribute("ninjas", ninjas);
        return "listarNinjas"; // Retorna o nome da pagina que renderiza html

    }


    @GetMapping("/deletarId/{id}")
    public String deletarNinjaPorId(@PathVariable Long id){

        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar"; // Redireciona para a página de listagem após a exclusão

    }


    @GetMapping("/listar/{id}")
    public String listarNinjasPorId(@PathVariable Long id , Model model){
        NinjaDTO ninjaEncontrado = ninjaService.listarNinjasPorId(id);

        if(ninjaEncontrado == null){
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas";
        }else{
            model.addAttribute("ninja", ninjaEncontrado);
            return "detalhesninja";
        }
    }


}
