/**
 * 
 */
package br.com.sistemawebapp.util;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistemawebapp.enums.RedirectStatus;

/**
 * @author antonio
 *
 */
@Service
public class RedirectModelAndView {
	private String message;
	private RedirectStatus redirectStatus;
	private boolean isRedirectStatus = false;
	
	public void setRedirectStatus(RedirectStatus redirectStatus) {
		isRedirectStatus = true;
		this.redirectStatus = redirectStatus;
	}
	  
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ModelAndView redirect(String uri) {
		return new ModelAndView("redirect:"+uri);
	}
	
	public ModelAndView view(ModelAndView view) {
		if(isRedirectStatus) {
			isRedirectStatus = false;
			return view.addObject(redirectStatus.toString().toLowerCase(), message);
		}
		return view;
	}
}
