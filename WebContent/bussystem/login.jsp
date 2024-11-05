<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='styleshhet' href=''>

<title>登園・バス管理システム</title>
</head>
<div class="header">
<div>
	<h1>登園・バス管理システム</h1>

	<h2>ログイン</h2>

	<div>${errors.get("null")}</div>
</div>
</div>

<form action = "LoginExecute.action" method="post">

	<div class="log">
		<label>ID</label>
		<input type="text" name="user_id" maxlength="20" placeholder="半角でご入力下さい"
		required
		><br>
	</div>

	<div class="pas">

		<label>パスワード</label>
		<input type="password" id="user_pass" name="user_pass" maxlength="20" required/><br>
		<input type="checkbox" id="showPassword" onchange="togglePasswordVisibility()" />
		<label for="showPassword">パスワードを表示</label>

		<script>
			function togglePasswordVisibility() {
				let passwordInput = document.getElementById("password");
				let showPasswordCheckbox = document.getElementById("showPassword");

				if (showPasswordCheckbox.checked) {
					passwordInput.type = "text";
				} else {
					passwordInput.type = "password";
				}
			}
		</script><br>
	</div>
		<div class="">
		<input type="submit" name="login" value="ログイン"/>
		</div>
</form>

</body>
</html>