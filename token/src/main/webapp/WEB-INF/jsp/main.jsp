<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>token</title>
    <script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
    <script>
    $(function(){
        var webSocket = new WebSocket('ws://localhost:8014/websocket');
        webSocket.onerror = function(event){
            onError(event);
        }
        webSocket.onopen = function(event){
            onOpen(event);
        }
        webSocket.onmessage = function(event){
            onMessage(event);
        }
        function onMessage(event){
            $('#msg').append(event.data + '<br>');
        }
        function onOpen(event){
            $('#msg').append('Connection established<br>');
        }
        function onError(event){
            $('#msg').append(event.data);
        }
        function start(){
            webSocket.send('hello');
        }
    });
    </script>
  </head>
  <body>
    <p>main</p>
    <div>
      <input type="submit" value="Start" onclick="start()" />
    </div>
    <div id="msg"></div>
    <p><a href="/signout">Sign out</a></p>
    <script src="http://cdn.bootcss.com/instantclick/3.0.1/instantclick.min.js"></script>
    <script data-no-instant>InstantClick.init();</script>
  </body>
</html>