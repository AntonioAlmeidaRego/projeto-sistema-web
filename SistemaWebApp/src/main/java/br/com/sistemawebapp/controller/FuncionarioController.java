/**
 * 
 */
package br.com.sistemawebapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistemawebapp.model.Funcionario;
import br.com.sistemawebapp.service.FuncionarioService;

/**
 * @author antonio
 *
 */
@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/cadastro-funcionario")
	public ModelAndView cadastro(Funcionario funcionario) {
		return new ModelAndView("funcionario/cadastro").addObject("funcionario", funcionario);
	}
	
	@PostMapping("/saveFuncionario")
	public ModelAndView save(Funcionario funcionario) {
		funcionarioService.save(funcionario);
		
		return findAll().addObject("success", "Salvo com Sucesso!");
	}
	
	@GetMapping("/lista")
	public ModelAndView findAll()
	{
		return new ModelAndView("funcionario/lista").addObject("funcionarios", funcionarioService.findAll());
	}
	
}
