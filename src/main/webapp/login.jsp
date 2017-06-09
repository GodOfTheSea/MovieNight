<%--
  Created by IntelliJ IDEA.
  User: pinte
  Date: 6/8/2017
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
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
        <form class="login-form"  method="post">
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


            <%--<div id="error">--%>
                <%--<!--<input name="error" value>-->--%>
            <%--</div>--%>
            <%
                String email = request.getParameter("email");
                String pass = request.getParameter("password");
                if (email != null && pass != null){
            %>
            <%@page import="java.sql.*" %>
            <%@ page import="java.io.PrintWriter" %>
            <%@ page import="domain.Persons" %>
            <%@ page import="java.util.List" %>
            <%@ page import="java.util.ArrayList" %>
            <%@page import="db.PersonsRepository" %>
            <%@ page import="domain.MyExceptions" %>
            <%
                PrintWriter print = response.getWriter();


                try{

                    List<Persons> Persoane = PersonsRepository.check();
                    PersonsRepository.findMe(email,pass,Persoane);


//                    Class.forName("org.postgresql.Driver");
//
//                    Connection conn = DriverManager.getConnection("jdbc:postgresql://54.93.65.5:5432/QA7_PCG", "fasttrackit_dev", "fasttrackit_dev");
//
//                    Statement stmt = conn.createStatement();
//
//                    ResultSet rs = stmt.executeQuery("SELECT Email, Password FROM persoane");
//
//                    List<Persons> PersonEntries = new ArrayList<>();
//                    while (rs.next()) {
//                        Persons person = new Persons(
//                                rs.getString("email"),
//                                rs.getString("password")
//                        );
//                        person.setId(rs.getLong("id"));
//                        PersonEntries.add(person);
//                    }
//
//                    for( Persons p : PersonEntries){
//                        if (p.getEmail().equals(email) && p.getPassword().equals(pass))
//                            contor = 1;
//                    }

//                    while (rs.next()) {
//                        if (rs.getString("email").equals(email) && rs.getString("password").equals(pass)) {
//                            contor = 1;
//                        }
//                    }
//
//
                } catch (ClassNotFoundException e){
                    print.println("<div class='error'><b>Unable to change the data!<b></div>");
                } catch (SQLException e) {
                    print.println("<div class='error'><b>Unable to change the date!<b></div>");
                }catch (IllegalArgumentException e) {
                    print.println("<div class='error'><b>Unable to change the dates!<b></div>");
                } catch (NullPointerException e) {
                    print.println("<div class='error'><b>Unable to change the datees!<b></div>");
                } catch (MyExceptions e){
                    %>
                        <div class="error">Invalid user or password!</div>
                    <%
                }
                response.sendRedirect("home.html");

                <%--if(contor == 0)--%>
                    <%--%>--%>
                        <%--<div class="error">Invalid user or password!</div>--%>
                    <%--<%--%>
                <%--if (contor == 1)--%>
                    <%--response.sendRedirect("home.html");--%>
                    <%--}--%>
                    <%--%>--%>


                <%--if(error){--%>
                <%--%>--%>
                    <%--<div>Invalid user or password!</div>--%>
                <%--<%--%>
                <%--}--%>






            <div class="login-forgot-password-wrapper">
                <a href="passwordremainder.html" class="login-help-link" tabindex="3">Forgot your email or password?</a>
                <a href="register.html" class="login-help-link mesaj-left"> Create an account!</a>
            </div>
            <button class="btn login-button btn-submit btn-small" type="submit" tabindex="0">
                Sign In
            </button>

            <script>
                function Verify() {
                    var errormsg = document.getElementById("error");


                }
            </script>

            <script>
                function Verifica() {
                    var xhttp;
//                    if (str == "") {
//                        document.getElementById("error").innerHTML = "";
//                        return;
//                    }
                    xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function() {
                        if (this.readyState == 4 && this.status == 200) {
                            document.getElementById("error").innerHTML = "Username or Password incorrect!";
                        }
                    };
                    xhttp.open("GET", "getcustomer.asp", true);
                    xhttp.send();
                }
            </script>




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

