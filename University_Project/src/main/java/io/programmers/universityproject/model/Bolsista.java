package io.programmers.universityproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "br_capes_bolsistas_uab")
public class Bolsista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "NM_BOLSISTA")
    private String nome;

    @Column(name = "CPF_BOLSISTA")
    private String cpf;

    @Column(name = "NM_ENTIDADE_ENSINO")
    private String instituicao;

    @Column(name = "ME_REFERENCIA")
    private int mes;

    @Column(name = "AN_REFERENCIA")
    private int ano;

    @Column(name = "SG_DIRETORIA")
    private String diretoria;

    @Column(name = "SG_SISTEMA_ORIGEM")
    private String sisOrigem;

    @Column(name = "CD_MODALIDADE_SGB")
    private int codModalidade;

    @Column(name = "DS_MODALIDADE_PAGAMENTO")
    private String codPagamento;

    @Column(name = "CD_MOEDA")
    private String codMoeda;

    @Column(name = "VL_BOLSISTA_PAGAMENTO")
    private int valorBolsa;

}
