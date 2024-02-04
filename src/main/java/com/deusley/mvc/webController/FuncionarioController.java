package com.deusley.mvc.webController;

import com.deusley.mvc.domain.Cargo;
import com.deusley.mvc.domain.Funcionario;
import com.deusley.mvc.domain.UF;
import com.deusley.mvc.service.CargoService;
import com.deusley.mvc.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
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
    public String listar(ModelMap model) {
        model.addAttribute("funcionarios", service.buscarTodos());
        return "/funcionario/lista";

    }

    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario, RedirectAttributes attr) {
        service.salvar(funcionario);
        attr.addFlashAttribute("success", "Funcionario inserido com sucesso");
        return "redirect:/funcionarios/cadastrar";
    }

    @ModelAttribute("cargos")
    public List<Cargo> getCargos() {
        return cargoService.buscarTodos();
    }

    @ModelAttribute("ufs")
    public UF[] getUfs() {
        return UF.values();
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("funcionario", service.buscarPorId(id));
        return "funcionario/cadastro";

    }

    @PostMapping("/editar")
    public String editar(Funcionario funcionario, RedirectAttributes attr) {
        service.editar(funcionario);
        attr.addFlashAttribute("success", "Editado com sucesso");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        service.excluir(id);
        attr.addFlashAttribute("success", "Excluido com sucesso");
        return "redirect:/funcionarios/listar";
    }
    @GetMapping("/buscar/nome")
    public String getPorNome(@RequestParam("nome") String nome, ModelMap model){
        model.addAttribute("funcionarios", service.buscarPorNome(nome));
        return "/funcionario/lista";
    }
    @GetMapping("/buscar/cargo")
    public String getPorCargo(@RequestParam("id") Long id, ModelMap model){
        model.addAttribute("funcionarios", service.buscarPorCargo(id));
        return "/funcionario/lista";
}
    @GetMapping("/buscar/data")
    public String getPorDatas(@RequestParam(value = "entrada" ,required = false)
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate entrada,
                              @RequestParam(value = "saida", required = false )
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate saida,
                              ModelMap model) {
        model.addAttribute("funcionarios", service.buscarPorDatas(entrada, saida));
        return "/funcionario/lista";


}}