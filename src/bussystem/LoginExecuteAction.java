package bussystem;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ManageUser;
import dao.ManageUserDao;
import tool.Action;

public class LoginExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		System.out.println("AAAAA1");

		String url = "";

		Map<String, String> errors = new HashMap<>();

		System.out.println("AAAAA1-2");

		//
		ManageUser MU = new ManageUser();

		System.out.println("AAAAA1-3");

		ManageUserDao MUDao = new ManageUserDao();

		System.out.println("AAAAA2");

		String user_id = req.getParameter("user_id");
		String user_pass = req.getParameter("user_pass");
		String facility_id = req.getParameter("facility_id");

		System.out.println("AAAAA3");

		MU = MUDao.login(user_id, user_pass, facility_id);

		System.out.println("AAAAA4");

		if(MU==null) {
			errors.put("null", "ログインに失敗しました。IDまたはパスワードが正しくありません。");
		} else {
			MU.setAuthenticated(true);
		}

		System.out.println("AAAAA5");

		if(!errors.isEmpty()) {
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("login.jsp").forward(req, res);
			return;
		}

		System.out.println("AAAAA6");

		HttpSession session = req.getSession(true);

		session.setAttribute("user", MU);

		System.out.println("AAAAA7");

		url = "main/Menu.action";
		res.sendRedirect(url);


	}

}
