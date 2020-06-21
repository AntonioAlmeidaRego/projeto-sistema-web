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

import br.com.sistemawebapp.annotations.AttrUpdate;
import br.com.sistemawebapp.annotations.IdUpdate;
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

	// Método de Exibir Formulario de Cadastro da Entidade Funcionario. Método GET
	// HTTP
	@GetMapping("/cadastro-funcionario")
	public ModelAndView cadastro(Funcionario funcionario) {
		return modelAndView(new ModelAndView("funcionario/cadastro").addObject("funcionario", funcionario));
	}

	// Método de Salvar a entidade Funcionario. Método POST HTTP
	@PostMapping("/saveFuncionario")
	public ModelAndView save(Funcionario funcionario) {
		entityQuery().setObject(funcionarioService);
		entityQuery().setReturnObject(new Funcionario());

		final boolean isIdUpdate = entityQuery().isIdUpdate(IdUpdate.class, funcionario);
		if ((!isIdUpdate)) {
			final boolean exist = entityQuery().isExist(funcionario.getCpf(), funcionario.getRg());
			if (!exist) {
				funcionarioService.save(funcionario);
				setMessage("Funcionario Salvo com Sucesso!");
				setRedirectStatus(RedirectStatus.SUCCESS);
				return redirect("/funcionario/lista");
			}
		} else if ((isIdUpdate)) {
			final boolean exist = entityQuery().isExist(funcionario.getCpf(), funcionario.getRg());
			final boolean entityUptade = entityQuery().isUpdate(AttrUpdate.class, funcionario,
					(Funcionario) entityQuery().getReturnObject());
			if ((exist) && (!entityUptade)) {
				funcionarioService.update(funcionario);
				setMessage("Funcionario Alterado com Sucesso!");
				setRedirectStatus(RedirectStatus.SUCCESS);
				return redirect("/funcionario/lista");
			} else {
				if (!exist) {
					funcionarioService.update(funcionario);
					setMessage("Funcionario Alterado com Sucesso!");
					setRedirectStatus(RedirectStatus.SUCCESS);
					return redirect("/funcionario/lista");
				}
			}
		} 

		return cadastro(funcionario).addObject("error", "Não foi possível salvar funcionario!");
	}

	// Método de Lista todas as entidades do funcionario. Método GET HTTP
	@GetMapping("/lista")
	public ModelAndView findAll() {
		return modelAndView(
				view(new ModelAndView("funcionario/lista").addObject("funcionarios", funcionarioService.findAll()))
				);
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

}
