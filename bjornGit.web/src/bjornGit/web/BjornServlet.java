package bjornGit.web;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bjornGit.ejb.BjornBeanLocal;

/**
 * Servlet implementation class BjornServlet
 */
@WebServlet("/BjornServlet")
public class BjornServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			BjornBeanLocal sessionCounterBean;
			if (session.getAttribute("counterBean") != null)
				sessionCounterBean = (BjornBeanLocal) session.getAttribute("counterBean");
			else
				sessionCounterBean = (BjornBeanLocal) new InitialContext()
						.lookup("java:global/bjornGit/bjornGit.ejb/BjornBean!bjornGit.ejb.BjornBeanLocal");

			response.getWriter().append("SessionCounterBean count: " + sessionCounterBean.count());
			session.setAttribute("counterBean", sessionCounterBean);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
