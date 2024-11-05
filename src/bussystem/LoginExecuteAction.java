package bussystem;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class LoginExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String url = "";

		Map<String, String> errors = new HashMap<>();



		String id = req.getParameter("id");
		String password = req.getParameter("password");



		if() {
			errors.put("null", "ログインに失敗しました。IDまたはパスワードが正しくありません。");
		} else {
			.setAuthenticated(true);
		}

		if(!errors.isEmpty()) {
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("login.jsp").forward(req, res);
			return;
		}

		HttpSession session = req.getSession(true);



		res.sendRedirect(url);


	}

}
