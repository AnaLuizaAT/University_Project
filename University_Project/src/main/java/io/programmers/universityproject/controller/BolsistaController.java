package io.programmers.universityproject.controller;

import io.programmers.universityproject.model.Bolsista;
import io.programmers.universityproject.model.dto.BolsistaCodificadoDTO;
import io.programmers.universityproject.model.dto.BolsistaDTO;
import io.programmers.universityproject.service.BolsistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bolsistas")
public class BolsistaController {

    @Autowired
    private BolsistaService bolsistaService;

    @GetMapping
    public ResponseEntity<Page<Bolsista>> listarBolsistas(@PageableDefault(page = 0, size = 10, /*sort = "id", */direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(bolsistaService.findAllBolsistas(pageable));
    }

    @GetMapping("/{ano}")
    public ResponseEntity listarBolsistaAno(@PathVariable("ano") int ano) {
        BolsistaDTO bolsista = bolsistaService.findBolsistaByAno(ano);
        return ResponseEntity.ok(bolsista);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity listarBolsistaNome(@PathVariable("nome") String nome) {
        List<BolsistaCodificadoDTO> bolsistas = bolsistaService.findBolsistaByNome(nome);
        return ResponseEntity.ok(bolsistas);
    }
}