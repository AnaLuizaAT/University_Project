package io.programmers.universityproject.model.dto;

import io.programmers.universityproject.model.Bolsista;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class BolsistaCodificadoDTO {
    private String nome;
    private int ano;
    private String instituicao;
    private int valorBolsa;

    public static BolsistaCodificadoDTO create(Bolsista bolsista) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(bolsista, BolsistaCodificadoDTO.class);
    }
}
