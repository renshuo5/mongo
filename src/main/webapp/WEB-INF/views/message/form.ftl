<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="${rc.contextPath}/manage/message">
<input type="text" name="fromId" value="${fromId}"/>
<input type="text" name="toId" value="${toId}"/>
	<table>
		<tr>
			<td>消息</td>
			<td><input type="text" name="content" value="${entity.account}"/></td>
			<button type="submit">提交</button>
			<button type="button">取消</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>