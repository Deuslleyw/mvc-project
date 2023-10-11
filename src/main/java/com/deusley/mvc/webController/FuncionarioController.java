package com.deusley.mvc.webController;

import com.deusley.mvc.domain.Cargo;
import com.deusley.mvc.domain.Funcionario;
import com.deusley.mvc.domain.UF;
import com.deusley.mvc.service.CargoService;
import com.deusley.mvc.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @Autowired
    private CargoService cargoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario) {
        return "/funcionario/cadastro";
    }
    @GetMapping("/listar")
    public String listar() {
        return "/funcionario/lista";

    }
    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario, RedirectAttributes attr){
        service.salvar(funcionario);
        attr.addFlashAttribute("success", "Funcionario inserido com sucesso");
        return "redirect:/funcionarios/cadastrar";
    }
    @ModelAttribute("cargos")
    public List<Cargo> getCargos(){
        return cargoService.buscarTodos();
    }
    @ModelAttribute("ufs")
    public UF [] getUfs(){
        return UF.values();
    }




}