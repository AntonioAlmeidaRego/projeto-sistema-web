package br.com.sistemawebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistemawebapp.enums.RedirectStatus;
import br.com.sistemawebapp.model.Funcionario;
import br.com.sistemawebapp.service.FuncionarioService;
import br.com.sistemawebapp.util.ControllerUtil;

/**
 * @author antonio
 *
 */
@Controller
@RequestMapping("/funcionario")
public class FuncionarioController extends ControllerUtil<Funcionario> // todo controller deverá extender dessa class
{
	@Autowired
	private FuncionarioService funcionarioService;

	/*
	 * Método para exibir o formulário de cadastro para submeter dados para a base
	 * de dados. Método GET do protocolo HTTP
	 */
	@GetMapping("/cadastro-funcionario")
	public ModelAndView cadastro(Funcionario funcionario) {
		return modelAndView(new ModelAndView("funcionario/cadastro").addObject("funcionario", funcionario));
	}

	/*
	 * Método para receber dados submetido do formulário HTML para a base de dados.
	 * Método POST do protocolo HTTP
	 */
	@PostMapping("/saveFuncionario")
	public ModelAndView save(Funcionario funcionario) {	
		
		if (existing(funcionario)) {  // Cadastra um novo funcionário.
			funcionarioService.save(funcionario); 
			setMessage("Funcionario Salvo com Sucesso!"); 
			setRedirectStatus(RedirectStatus.SUCCESS); 
			return redirect("/funcionario/lista"); 
		} 
		else if (existing(funcionario)) {  // Atualiza um funcionário já cadastrado.
			funcionarioService.update(funcionario); 
			setMessage("Funcionario Alterado com Sucesso!"); 
			setRedirectStatus(RedirectStatus.SUCCESS); 
			return redirect("/funcionario/lista"); 
		}
		else { 
			return cadastro(funcionario).addObject("error", "Não foi possível salvar funcionario!");
		}
	}

	// Método de Lista todas as entidades do funcionario. Método GET HTTP
	@GetMapping("/lista")
	public ModelAndView findAll() {
		return modelAndView(
				view(new ModelAndView("funcionario/lista").addObject("funcionarios", funcionarioService.findAll())));
	}

	@GetMapping("/delete/{id}") // Método de remoção logicamente a entidade. Método GET HTTP
	public ModelAndView delete(@PathVariable("id") String idCrypt) {
		Funcionario funcionario = funcionarioService.findOne(idCrypt);

		if (funcionario != null) {
			funcionarioService.delete(funcionario);
			setMessage("Entidade Removida Com Sucesso!");
			setRedirectStatus(RedirectStatus.SUCCESS);
			return redirect("/funcionario/lista");
		}
		setMessage("Entidade não encontrada. Por favor tente outra!");
		setRedirectStatus(RedirectStatus.ERROR);
		return redirect("/funcionario/lista");
	}
	
	@GetMapping("/updateFuncionario/{id}")
	public ModelAndView update(@PathVariable("id") String idCrypt) {
		Funcionario funcionario = funcionarioService.findByIdCrypt(idCrypt);
		if(funcionario !=null) {
			return cadastro(funcionario);
		}
		
		setMessage("Funcionário não Encontrado. Por Favor tente novamente!");
		setRedirectStatus(RedirectStatus.ERROR);
		return redirect("/funcionario/lista");
	}
	
	public boolean existing(Funcionario funcionario) {
		entityQuery().setObject(funcionarioService); 
		entityQuery().setReturnObject(new Funcionario()); 
		final boolean isIdUpdate = entityQuery().isIdUpdate(funcionario); 
		
		if ((!isIdUpdate)) {
			final boolean exist = entityQuery().isExist(funcionario.getCpf(),funcionario.getRg());
			if (!exist) {
				return true;
			}
		}
		else {
			final boolean exist = entityQuery().isExist(funcionario.getCpf(),funcionario.getRg());									 
			final boolean entityUptade = entityQuery().isUpdate(funcionario);
			
			if ((exist) && (!entityUptade)) {
				return false;
				
			} else if (!exist) { 
				return false;
			}
		}
		return false;
	}
}