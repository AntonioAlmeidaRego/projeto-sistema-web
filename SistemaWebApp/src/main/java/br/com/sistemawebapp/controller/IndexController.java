/**
 * 
 */
package br.com.sistemawebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author antonio
 * Mauricio: ver o cadastro funcionario e endereço e carteira (cruds)
 * Cleo: 
 * Julia: HTML
 * Cimara: 
 * Antonio: 
 */
@Controller
public class IndexController {
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@GetMapping("/admin")
	public ModelAndView admin() {
		return new ModelAndView("layout");
	}
}
