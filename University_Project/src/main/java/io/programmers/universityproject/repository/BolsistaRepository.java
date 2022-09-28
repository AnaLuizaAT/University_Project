package io.programmers.universityproject.repository;

import io.programmers.universityproject.model.Bolsista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BolsistaRepository extends JpaRepository<Bolsista, Integer> {

    @Query("SELECT b FROM Bolsista b WHERE b.ano = ?1")
    List<Bolsista> findByAno(int ano);

    @Query("select b from Bolsista b where upper(b.nome) like (:nome%)")
    List<Bolsista> findByNome(String nome);
}