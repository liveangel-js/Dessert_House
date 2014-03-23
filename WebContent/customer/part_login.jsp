<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<link rel="stylesheet" href="../css/part_login.css">
<link rel="stylesheet" href="../js/themes/base/jquery.ui.all.css">
<script src="../js/jquery-1.9.1.js"></script>
<script src="../js/ui/jquery.ui.core.js"></script>
<script src="../js/ui/jquery.ui.widget.js"></script>
<script src="../js/ui/jquery.ui.mouse.js"></script>
<script src="../js/ui/jquery.ui.draggable.js"></script>
<script src="../js/ui/jquery.ui.position.js"></script>
<script src="../js/ui/jquery.ui.resizable.js"></script>
<script src="../js/ui/jquery.ui.button.js"></script>
<script src="../js/ui/jquery.ui.dialog.js"></script>

<script>
	var jQuery_1_9_1 = $.noConflict(true);
	jQuery_1_9_1(function() {
		jQuery_1_9_1("#login_dialog").dialog({
			autoOpen : false,
			show : {
				effect : "blind",
				duration : 1000
			},
			hide : {
				effect : "explode",
				duration : 1000
			}
		});

		jQuery_1_9_1("#login_button").click(function() {
			jQuery_1_9_1("#login_dialog").dialog("open");
		});
	});
</script>




<div id="login_dialog">
	<form action="<%=request.getContextPath()%>/customer/login" method="post">
		<table style="margin: 20px;">
			<tr>
				<td>用户</td>
				<td><input type="text" name="username" size="20" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password" size="20" /></td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="登录" /> <input type="reset" value="清空" />
		</p>
	</form>
</div>
