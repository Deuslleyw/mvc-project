package com.deusley.mvc.service.impl;

import com.deusley.mvc.dao.interfaces.CargoDao;
import com.deusley.mvc.domain.Cargo;
import com.deusley.mvc.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoDao dao;


    @Override
    public void salvar(Cargo cargo) {
        dao.save(cargo);
    }

    @Override
    public void editar(Cargo cargo) {
        dao.update(cargo);

    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);

    }

    @Override
    @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return dao.findAll();
    }
}
