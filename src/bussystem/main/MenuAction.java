package bussystem.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MenuAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {


		String m1 = (String)req.getAttribute("m");
		req.setAttribute("m", m1);
		System.out.println(m1);
		req.getRequestDispatcher("menu.jsp").forward(req, res);

	}
}