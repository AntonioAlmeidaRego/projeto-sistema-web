/**
 * 
 */
package br.com.sistemawebapp.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author antonio
 *
 */
@Service
public class SessionUtil <T extends Object>{
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;

	public void criarSession(String name, T entity) {
		if (request.getSession().getAttribute(name) == null) {
			request.getSession().setAttribute(name, entity);
		}
	}
	
	public T getSession(String name) {
		return (T) session.getAttribute(name);
	}
	
	public void clearSession() {
		request.getSession().invalidate();
	}
}
