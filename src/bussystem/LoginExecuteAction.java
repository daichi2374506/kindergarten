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

		String id = req.getParameter("id");
		String password = req.getParameter("password");

		MU = MUDao.login(user_id, user_pass);

		if(MU==null) {
			errors.put("null", "ログインに失敗しました。IDまたはパスワードが正しくありません。");
		} else {
			MU.setAuthenticated(true);
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
