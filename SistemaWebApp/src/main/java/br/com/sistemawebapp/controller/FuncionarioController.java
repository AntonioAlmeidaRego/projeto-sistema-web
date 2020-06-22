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
		/*
		 * Esses métodos são obrigatórios, devem ser instanciados para que os demais
		 * possam ser executados
		 */
		entityQuery().setObject(funcionarioService); // Método para setar o objeto que faz a consulta na base de dados
		entityQuery().setReturnObject(new Funcionario()); // Método para setar o objeto que vai retornar na consulta da
															// base de dados

		final boolean isIdUpdate = entityQuery()
				.isIdUpdate(funcionario); /*
											 * Método usado para verificar se a chave primaria é diferente de vazio,
											 * caso isso ocorra é porque essa entidade não existe na base de dados
											 */
		if ((!isIdUpdate)) { // Se for falso, entidade não foi inserida na base de dados
			final boolean exist = entityQuery().isExist(funcionario.getCpf(),
					funcionario.getRg());/*
											 * Método usado para verificar se existe uma entidade que tenha os atributos
											 * únicos
											 */
			if (!exist) {// Se for falso não existe uma entidade com essas informações na base de dados
				funcionarioService.save(funcionario); // Inserir na base de dados
				setMessage("Funcionario Salvo com Sucesso!"); // Setar uma mensagem de sucesso
				setRedirectStatus(RedirectStatus.SUCCESS); // Setar o status do redirecionamento da requisição
				return redirect("/funcionario/lista"); // redirecionar para a página lista
			}
		} else if ((isIdUpdate)) {// Se for verdadeiro, entidade já foi inserida na base de dados
			final boolean exist = entityQuery().isExist(funcionario.getCpf(),
					funcionario.getRg());/*
											 * Método usado para verificar se existe uma entidade que tenha os atributos
											 * únicos
											 */
			final boolean entityUptade = entityQuery()
					.isUpdate(funcionario);/*
											 * Método para verificar se a entidade atualizou seus atributos únicos.
											 */
			/*
			 * Se a entidade não atualizou seus dados e se existe uma entidade com esses
			 * dados. Deverá retornar verdadeiro. Caso isso aconteça esta entidade deverá
			 * atualizar seus dados.
			 */
			if ((exist) && (!entityUptade)) {
				funcionarioService.update(funcionario); // Atualizar na base de dados
				setMessage("Funcionario Alterado com Sucesso!"); // Setar uma mensagem de sucesso
				setRedirectStatus(RedirectStatus.SUCCESS); // Setar o status do redirecionamento da requisição
				return redirect("/funcionario/lista"); // redirecionar para a página lista
			} else {
				/*
				 * Senão. Se a entidade atualizou seus dados, mas não poderá inserir informações
				 * que já tenha na base de dados. Isso deverá retornar verdadeiro
				 */
				if (!exist) {
					funcionarioService.update(funcionario);// Atualizar na base de dados
					setMessage("Funcionario Alterado com Sucesso!");// Setar uma mensagem de sucesso
					setRedirectStatus(RedirectStatus.SUCCESS);// Setar o status do redirecionamento da requisição
					return redirect("/funcionario/lista");// redirecionar para a página lista
				}
			}
		}

		/*
		 * Se o fluxo do método save retornar o método cadastro, mostra que a entidade
		 * não tem informações suficientes para inserir na base de dados, não seguindo a
		 * regra de negocio do projeto.
		 */

		return cadastro(funcionario).addObject("error", "Não foi possível salvar funcionario!");
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

}