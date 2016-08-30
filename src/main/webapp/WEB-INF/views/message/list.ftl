<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
消息列表</br>
已发送消息：<br/>
<#list fromList as li>
编码:${li.id},发送者姓名:${li.fromName},接收者:${li.toName} , 消息:${li.content},时间：${li.sendTime}; <br/>

</#list>
已接收消息：<br/>
<#list toList as li>
编码:${li.id},发送者姓名:${li.fromName},接收者:${li.toName} , 消息:${li.content},时间：${li.sendTime}; <br/>
</#list>

</body>
</html>