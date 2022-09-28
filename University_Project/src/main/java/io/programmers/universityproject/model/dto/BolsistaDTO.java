package io.programmers.universityproject.model.dto;


import io.programmers.universityproject.model.Bolsista;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class BolsistaDTO {
    private String nome;
    private String cpf;
    private String instituicao;
    private int valorBolsa;

    public static BolsistaDTO create(Bolsista bolsista) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(bolsista, BolsistaDTO.class);
    }
}