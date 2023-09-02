package com.deusley.mvc.dao.interfaces;

import com.deusley.mvc.domain.Cargo;

import java.util.List;

public interface CargoDao {

    void save (Cargo cargo);

    void update (Cargo cargo);

    void delete (Cargo cargo);

    Cargo findById(Long id);

    List<Cargo> findAll();

}
