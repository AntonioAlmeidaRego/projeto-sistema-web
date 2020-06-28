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
	 * @param keySession the keySession to set
	 */
	public void setKeySession(String keySession) {
		this.keySession = keySession;
	}
	
	 /**
	 * @param keyView the keyView to set
	 */
	public void setKeyView(String keyView) {
		this.keyView = keyView;
	}
	 
	public ModelAndView viewSessionUser(ModelAndView view) {
		return view.addObject(keyView, sessionUtil.getSession(keySession));
	}
}
