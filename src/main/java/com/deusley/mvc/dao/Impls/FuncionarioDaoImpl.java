package com.deusley.mvc.dao.Impls;

import com.deusley.mvc.dao.AbstractDao;
import com.deusley.mvc.dao.interfaces.FuncionarioDao;
import com.deusley.mvc.domain.Funcionario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {



    public List<Funcionario> findByNome(String nome) {

        return createQuery("select f from Funcionario f where f.nome like concat ('%',?1,'%')", nome);
    }
}

