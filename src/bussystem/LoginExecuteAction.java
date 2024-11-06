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

		String url = "";

		Map<String, String> errors = new HashMap<>();

		ManageUser MU = new ManageUser();

		ManageUserDao MUDao = new ManageUserDao();

		String user_id = req.getParameter("user_id");
		String user_pass = req.getParameter("user_pass");
		String facility_id = req.getParameter("facility_id");

		MU = MUDao.login(user_id, user_pass, facility_id);


		if(MU==null) {
			errors.put("null", "ログインに失敗しました。IDまたはパスワードが正しくありません。");

			System.out.println("AAAAA1");

		} else if(user_id.contains("M")) {
			MU.setAuthenticated(true);

			System.out.println("AAAAA2");

		} else if(user_id.contains("T")) {
			MU.setAuthenticated(true);

			System.out.println("AAAAA3");

		} else if(user_id.contains("P")) {
			MU.setAuthenticated(true);

			System.out.println("AAAAA4");

		}


		if(!errors.isEmpty()) {
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("login.jsp").forward(req, res);
			return;
		}

		HttpSession session = req.getSession(true);

		session.setAttribute("user", MU);

		url = "main/Menu.action";
		res.sendRedirect(url);


	}

}
