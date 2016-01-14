<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>token</title>
    <script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
  </head>
  <body>
    <fieldset>
      <legend>Sign up</legend>
      <div>${msg }</div>
      <form action="/signup" method="post">
        <div>
          <label for="user">user</label>
          <input name="user" id="user" type="text" />
        </div>
        <div>
          <label for="pass">pass</label>
          <input name="pass" id="pass" type="text" />
        </div>
        <input type="hidden" name="token" value="${token}" />
        <div>
          <input type="submit" value="submit" />
        </div>
        <div>
          <a href="/signin">Sign in</a>
        </div>
      </form>
      <div>${u }</div>
    </fieldset>
    <script src="http://cdn.bootcss.com/instantclick/3.0.1/instantclick.min.js"></script>
    <script data-no-instant>InstantClick.init();</script>
  </body>
</html>