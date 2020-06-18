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
public class SessionModelAndView <T extends Object>{
	@Autowired
	private SessionUtil<T> sessionUtil;
	private String keySession;
	private String keyView;
	/**
	 * 
	 */
	public SessionModelAndView(String keySession, String keyView) {
		this.keySession = keySession;
		this.keyView = keyView;
	}

	public ModelAndView viewSessionUser(ModelAndView view) {
		return view.addObject(keyView, sessionUtil.getSession(keySession));
	}
}
