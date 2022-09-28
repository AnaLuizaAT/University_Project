package io.programmers.universityproject.service;

import io.programmers.universityproject.model.Bolsista;
import io.programmers.universityproject.model.dto.BolsistaCodificadoDTO;
import io.programmers.universityproject.model.dto.BolsistaDTO;
import io.programmers.universityproject.repository.BolsistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BolsistaService {

    @Autowired
    private BolsistaRepository bolsistaRepository;

    public Page<Bolsista> findAllBolsistas(Pageable pageable) {
        return bolsistaRepository.findAll(pageable);
    }

    public BolsistaDTO findBolsistaByAno(int ano) {
        var bolsista = bolsistaRepository.findByAno(ano).stream().map(BolsistaDTO::create).collect(Collectors.toList());
        return bolsista.get(0);
    }

    public List<BolsistaCodificadoDTO> findBolsistaByNome(String nome) {
        var listaBolsistas = bolsistaRepository
                .findByNome(nome)
                .stream()
                .map(BolsistaCodificadoDTO::create)
                .collect(Collectors.toList());
        for (BolsistaCodificadoDTO bl : listaBolsistas) {
            //invertendo ordem do nome do bolsista.
            var nomeBolsista = bl.getNome().toCharArray();
            System.out.println(nomeBolsista);
            int fim = nomeBolsista.length - 1;
            for (int i = 0; i < nomeBolsista.length / 2; i++) {
                char copia = nomeBolsista[i];
                nomeBolsista[i] = nomeBolsista[fim];
                nomeBolsista[fim] = copia;
                fim--;
            }
            //codificando o nome do bolsista.
            String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            char[] arrayAlfabeto = alfabeto.toCharArray();
            for (int i = 0, j = 0; i < nomeBolsista.length; i++) {
                for (j = 0; j < arrayAlfabeto.length; j++) {
                    if (nomeBolsista[i] == arrayAlfabeto[j]) {
                        nomeBolsista[i] = arrayAlfabeto[j + 1];
                        break;
                    }
                }
            }
            //var novoNome = new String(nomeBolsista);
            var novoNome = String.copyValueOf(nomeBolsista);
            bl.setNome(novoNome);
            System.out.println(novoNome);
        }
        return listaBolsistas;
    }
}