package dev.java10x.cadastroDeNinjas.Missoes.Mapper;

import org.springframework.stereotype.Component;
import dev.java10x.cadastroDeNinjas.Missoes.DTO.MissoesDTO;
import dev.java10x.cadastroDeNinjas.Missoes.Model.MissoesModel;

@Component
public class MissoesMapper {
    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDescricao(missoesDTO.getDescricao());
        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDescricao(missoesModel.getDescricao());
        return missoesDTO;
    }

}
