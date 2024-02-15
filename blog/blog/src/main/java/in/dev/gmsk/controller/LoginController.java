package in.dev.gmsk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -4517510503159648432L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/jsp/index.jsp").forward(req, resp);
		;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("userName");

		System.out.println("userName : " + userName);

		if (userName.equalsIgnoreCase("admin")) {
			req.getRequestDispatcher("views/jsp/home.jsp").forward(req, resp);
		} else {
			resp.getWriter().print("Invaild UserName...");
		}
	}

}
