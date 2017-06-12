<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="css/loginstyle.css" rel="stylesheet " type="text/css">
</head>

<body background="images/Suits.jpg">

<div class="login-body">
    <div class="login-content login-form">
        <h1>Sign In</h1>
        <form class="login-form"  action="/Login" method="post">
            <label class="login-input ui-label">
                <span class="ui-label-text"> Email</span>
                <input class="ui-text-input" name="email" value autocomplete="email">
            </label>
            <div class="password-wrapper">
                <label class="ui-label ui-input-label hybrid-password login-input login-input-password">
                    <span class="ui-label-text">Password</span>
                    <input type="password" class="ui-text-input" name="password" tabindex="0" value>
                </label>
                <input type="button" class="show-toggle no-toggle" value>
            </div>

            <%  String message =  String.valueOf(request.getAttribute("message"));
                if (message.equals("null")) message = "";
            %>
            <%=message%>

            <div class="login-forgot-password-wrapper">
                <a href="passwordremainder.html" class="login-help-link" tabindex="3">Forgot your email or password?</a>
                <a href="register.html" class="login-help-link mesaj-left"> Create an account!</a>
            </div>
            <button class="btn login-button btn-submit btn-small" type="submit" tabindex="0">
                Sign In
            </button>

            <!--<div class="login-remember-me-wrapper">-->
            <!--<div class="ui-binary-input login-remember-me">-->
            <!--<input type="checkbox" class name="rememberMe" id="1" value tabindex="0" checked>-->
            <!--<label for="1">-->
            <!--<span class="login-remember-me-label-text">-->
            <!--Remember me-->
            <!--</span>-->
            <!--</label>-->
            <!--<div class="helper"></div>-->
            <!--</div>-->
            <!--</div>-->
            <input type="hidden" name="flow" value="websiteSingUp">
            <input type="hidden" name="mode" value="login">
            <input type="hidden" name="action" value="loginAction">
            <input type="hidden" name="withFields" value="email,password,rememberMe,nextPage,showPassword">
            <input type="hidden" name="authURL" value="1494253633253./JhRjj4kCRTurVUGQ9v4yhD8whs=">
            <input type="hidden" name="nextPage" value>
            <input type="hidden" name="showPassword" value>

        </form>


    </div>
</div>
</body>
</html>
