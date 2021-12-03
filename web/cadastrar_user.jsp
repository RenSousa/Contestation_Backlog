<%-- 
    Document   : newjsp
    Created on : 26/06/2019, 17:22:53
    Author     : RENAN.SOUSA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TransactionsAnalytics</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="css/signin.css" rel="stylesheet" >
        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
    </head>
    <body class="text-center">



        <form class="form-signin" action="ControllerUser" method="post">
            
            <% String msg = (String) request.getAttribute("msg");
                if (msg != null) {
            %>
            <span class="text-danger"><%=msg%></span>
            <%
                }
            %>
            <h1 class="h3 mb-3 font-weight-normal">Análise de Transações</h1>
            <img class="mb-4" src="./img/logo.PNG" alt="" width="200" height="180">

            <label for="inputLoginRede" class="sr-only">Usuário</label>
            <input type="text" id="inputLoginRede" name="txt_login" class="form-control" placeholder="Usuário" required="" autofocus="">

            <label for="inputPassword" class="sr-only">Senha</label>
            <input type="password" name="txt_senha" id="inputPassword" class="form-control" placeholder="Senha" required="">
            
            <label for="inputNome" class="sr-only">Nome Completo</label>
            <input type="text" name="txt_nome" id="inputNome" class="form-control" placeholder="Nome Completo" required="">

            <label for="inputEmail" class="sr-only">E-mail</label>
            <input type="text" name="txt_email" id="inputEmail" class="form-control" placeholder="E-mail" required="">
            
            <button class="btn btn-lg btn-danger btn-block" name="btn_cadastraruser" type="submit">ENVIAR</button>
            <br/>
             <p class="mt-5 mb-3 text-muted">© 2020</p>

        </form>


    </body>
</html>