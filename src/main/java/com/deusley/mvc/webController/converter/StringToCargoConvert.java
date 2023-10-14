package com.deusley.mvc.webController.converter;

import com.deusley.mvc.domain.Cargo;
import com.deusley.mvc.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCargoConvert implements Converter<String, Cargo> {

    @Autowired
    private CargoService cargoService;


    @Override
    public Cargo convert(String text) {
        if(text.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(text);

        return cargoService.buscarPorId(id);
    }
}
