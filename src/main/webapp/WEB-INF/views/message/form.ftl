<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="${rc.contextPath}/manage/message">
<input type="hidden" name="fromId" value="${fromId}"/>
<input type="hidden" name="toId" value="${toId}"/>
	<div id="mv_16759008" class="chat_nm_out" style="height: 174px; overflow-y: scroll;">
		<div class="msgCap_0">
		
		2016-08-31 11:10:00
		</div>
		<div class="msgBody_0">
		和一帮努力的人在一起，回到梦想开始的地方！
		<br>
		Hi，这里是学员认可度很高的传智播客，由于最近营...望学员耐心等待哦，方便的话可以直接加QQ详聊！
		</div>
	</div>
	<table border=1>
		<tr>
			<td>消息</td>
			<td width=200>
			<textarea name="content"/>
			${entity.content}
			</textarea>
			</td>
		</tr>
		<tr>
			<td><button type="submit">提交</button></td>
			<td >
			<button type="button">取消</button>
			</td>
		</tr>
		
		
			
	</table>
</form>
</body>
</html>