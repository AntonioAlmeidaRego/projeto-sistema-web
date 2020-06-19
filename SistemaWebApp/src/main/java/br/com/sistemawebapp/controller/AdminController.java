/**
 * 
 */
package br.com.sistemawebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistemawebapp.util.ControllerUtil;

/**
 * @author antonio
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends ControllerUtil {
	
	@GetMapping("/portal-user")
	public ModelAndView portalUser() {
		return new ModelAndView("admin/portal-user");
	}
}
