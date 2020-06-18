/**
 * 
 */
package br.com.sistemawebapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author antonio
 *
 */
@Service
public class ControllerUtil<T extends Object> extends RedirectModelAndView{
	@Autowired
	private SessionModelAndView<T> view; 

	/**
	 * 
	 */
	public ControllerUtil() {
		view = new SessionModelAndView<T>("user-log", "logado");
	}
	
	public ModelAndView modelAndView(ModelAndView view) {
		return this.view.viewSessionUser(view);
	}
}
