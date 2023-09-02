package com.deusley.mvc.dao.Impls;

import com.deusley.mvc.dao.AbstractDao;
import com.deusley.mvc.dao.interfaces.DepartamentoDao;
import com.deusley.mvc.domain.Departamento;
import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao {


    @Override
    public void delete(Departamento departamento) {

    }
}
