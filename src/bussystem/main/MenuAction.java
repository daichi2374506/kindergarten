package bussystem.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class MenuAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession(true);

		String m1 = (String)session.getAttribute("m");
		req.setAttribute("m", m1);
		System.out.println(m1);
		req.getRequestDispatcher("menu.jsp").forward(req, res);

	}
}