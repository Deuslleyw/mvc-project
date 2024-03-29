package com.deusley.mvc.service.impl;

import com.deusley.mvc.dao.interfaces.DepartamentoDao;
import com.deusley.mvc.domain.Departamento;
import com.deusley.mvc.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoDao dao;

    @Override
    @Transactional
    public void salvar(Departamento departamento) {
        dao.save(departamento);

    }

    @Override
    @Transactional
    public void editar(Departamento departamento) {
        dao.update(departamento);

    }

    @Override
    @Transactional
    public void excluir(Long id) {
        dao.delete(id);

    }

    @Override
    @Transactional(readOnly = true)
    public Departamento buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean departamentoComCargos(Long id) {
        if (buscarPorId(id).getCargos().isEmpty()) {
            return false;
        }
        return true;
    }
}
