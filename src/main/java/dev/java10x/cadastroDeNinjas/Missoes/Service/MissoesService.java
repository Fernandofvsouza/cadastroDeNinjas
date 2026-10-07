package dev.java10x.cadastroDeNinjas.Missoes.Service;

import dev.java10x.cadastroDeNinjas.Missoes.Model.MissoesModel;
import dev.java10x.cadastroDeNinjas.Missoes.Repository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Listar todas a missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    //Listar missoes por ID
    public MissoesModel listarMissoesPorId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.orElse(null);
    }

    //Criar uma missao
    public MissoesModel criarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    //Deletar Missao por id
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

}
