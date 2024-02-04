package com.deusley.mvc.dao.interfaces;

import com.deusley.mvc.domain.Funcionario;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioDao {


    void save (Funcionario funcionario);

    void update (Funcionario funcionario);

    void delete (Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();

    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByCargoId(Long id);

    List<Funcionario> findByDataEntradaEsaida(LocalDate entrada, LocalDate saida);

    List<Funcionario> findByDataEntrada(LocalDate entrada);

    List<Funcionario> findByDataSaida(LocalDate saida);
}

