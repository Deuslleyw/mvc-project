package com.deusley.mvc.web.validator;

import com.deusley.mvc.domain.Funcionario;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class FuncionarioValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Funcionario.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        Funcionario func = (Funcionario) obj;

        LocalDate entrada = func.getDataEntrada();

        if (func.getDataSaida() !=null){
            if (func.getDataSaida().isBefore(entrada)){
                errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
            }
        }

    }
}
