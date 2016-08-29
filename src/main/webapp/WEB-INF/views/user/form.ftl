<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="${rc.contextPath}/manage/user">
	<table>
		<tr>
			<td>账号</td>
			<td><input type="text" name="account" value="${entity.account}"/></td>
			<td>姓名</td>
			<td><input type="text" name="name" value="${entity.name}"/></td>
			<td>密码</td>
			<td>
				<input type="password" name="password" value="${entity.password}"/>
			</td>
			<td>
			<button type="submit">提交</button>
			<button type="button">取消</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>