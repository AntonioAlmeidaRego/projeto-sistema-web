/**
 * 
 */
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
public class FuncionarioController extends ControllerUtil // todo controller deverá extender dessa class
{
	@Autowired
	private FuncionarioService funcionarioService;

	// Método de Exibir Formulario de Cadastro da Entidade Funcionario. Método GET
	// HTTP
	@GetMapping("/cadastro-funcionario")
	public ModelAndView cadastro(Funcionario funcionario) {
		return modelAndView(new ModelAndView("funcionario/cadastro").addObject("funcionario", funcionario));
	}

	// Método de Salvar a entidade Funcionario. Método POST HTTP
	@PostMapping("/saveFuncionario")
	public ModelAndView save(Funcionario funcionario) {
		Funcionario funcionarioAux = funcionarioService.findByCPFOrRG(funcionario.getCpf(), funcionario.getRg());

		if ((funcionarioAux == null) && (funcionario.getId() == null)) {
			funcionarioService.save(funcionario);

			setMessage("Funcionario Salvo com Sucesso!");
			setRedirectStatus(RedirectStatus.SUCCESS);
			return redirect("/funcionario/lista");
		} else if ((funcionarioAux == null) && (funcionario.getId() != null)) {
			funcionarioService.update(funcionario);

			setMessage("Funcionario Alterado com Sucesso!");
			setRedirectStatus(RedirectStatus.SUCCESS);
			return redirect("/funcionario/lista");
		}
		setMessage("Não foi possível salvar funcionario!");
		setRedirectStatus(RedirectStatus.ERROR);
		return redirect("/funcionario/lista");
	}

	// Método de Lista todas as entidades do funcionario. Método GET HTTP
	@GetMapping("/lista")
	public ModelAndView findAll() {
		return modelAndView(
				new ModelAndView("funcionario/lista").addObject("funcionarios", funcionarioService.findAll()));
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

	// implementar membro do Grupo de Julia junto com ela, os métodos restore, restoreAll, detalhe e update da entidade funcionario
}
