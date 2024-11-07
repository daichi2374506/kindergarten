package bussystem;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ManageUser;
import bean.ParentsUser;
import dao.ManageUserDao;
import dao.ParentsUserDao;
import tool.Action;

public class LoginExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession(true);

		String url = "";
		Map<String, String> errors = new HashMap<>();

		ManageUser MU = new ManageUser();
		ManageUserDao MUDao = new ManageUserDao();
		ParentsUser PU = new ParentsUser();
		ParentsUserDao PUDao = new ParentsUserDao();

		String user_id = req.getParameter("user_id");
		String user_pass = req.getParameter("user_pass");
		String facility_id = req.getParameter("facility_id");

		if(user_id.contains("M") || ) (user_id.contains("T"){
			MU = MUDao.login(user_id, user_pass, facility_id);

		} else if(user_id.contains("P")) {
			PU = PUDao.login(user_id, user_pass, facility_id);
		}




//		if(MU==null) {
//			errors.put("null", "ログインに失敗しました。IDまたはパスワードが正しくありません。");
//
//			System.out.println("AAAAA1");
//
//		} else if(user_id.contains("M")) {
//			MU.setAuthenticated(true);
//
//			String m = "m";
//			session.setAttribute("m", m);
//
//			System.out.println(m);
//
//			System.out.println("管理者としてログイン");
//
//		} else if(user_id.contains("T")) {
//			MU.setAuthenticated(true);
//
//			String t = "t";
//			session.setAttribute("t", t);
//
//			System.out.println("先生としてログイン");
//
//		} else if(user_id.contains("P")) {
//			MU.setAuthenticated(true);
//
//			String p = "p";
//			session.setAttribute("p", p);
//
//			System.out.println("保護者としてログイン");
//
//		}
//
//
//		if(!errors.isEmpty()) {
//			req.setAttribute("errors", errors);
//			req.getRequestDispatcher("login.jsp").forward(req, res);
//			return;
//		}
//
//		session.setAttribute("user", MU);
//
//		url = "main/Menu.action";
//		res.sendRedirect(url);
//
//
//	}
//
//}
