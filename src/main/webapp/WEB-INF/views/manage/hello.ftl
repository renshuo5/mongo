<html>  
<head>  
    <title>WebSocket/SockJS Echo Sample (Adapted from Tomcat's echo sample)</title>  
    
    <script src="${rc.contextPath}/s/jquery/jquery-2.0.3.min.js"></script>
    <script src="${rc.contextPath}/s/sockjs/sockjs.js"></script>  
	
    <script type="text/javascript">
         /*
         var  wsServer = 'ws://localhost:8088/mongo-frame/hello'; 
         var  websocket = new WebSocket(wsServer); 
         websocket.onopen = function (evt) { onOpen(evt) }; 
         websocket.onclose = function (evt) { onClose(evt) }; 
         websocket.onmessage = function (evt) { onMessage(evt) }; 
         websocket.onerror = function (evt) { onError(evt) }; 
         function onOpen(evt) { 
            console.log("Connected to WebSocket server."); 
         } 
         function onClose(evt) { 
            console.log("Disconnected"); 
         } 
         function onMessage(evt) {
            $("#msg").html($("#msg").html() + "<br/>" + evnt.data);
         } 
         function onError(evt) { 
            console.log('Error occured: ' + evt.data); 
         }
         */
        var sock = new SockJS('http://localhost:8088/mongo-frame/hello');
         sock.onopen = function() {
            console.log('open');
            sock.send('test');
            
         };
         sock.onmessage = function(e) {
             $("#msg").html($("#msg").html() + "<br/>" + e.data);
         };
         sock.onclose = function() {
             
         };
         function seestate(){
         	console.log(sock.readyState);
         }
         //setInterval(function(){sock.send('later');},3000);
         
        function sendMsg(){
            var message = $("#message").val();
            console.log(message);
            sock.send(message);
        }
    </script>  
</head>  
<body>  
<button id='ToggleConnection' type="button" onclick='seestate();'>查看状态</button>

<input type="text" class="form-control" placeholder="发送信息..." id="message">
<span class="input-group-btn">
	<button class="btn btn-default" type="button" id="send" onClick="sendMsg();">发送</button>
</span>


<div class="well" style="width:300px;height:100px"id="msg">
</body>  
</html>