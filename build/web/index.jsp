<%-- 
    Document   : newjsp
    Created on : 13/04/2020, 17:22:53
    Author     : RENAN.SOUSA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DistribuicaoTarefas</title>
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
            <h1 class="h3 mb-3 font-weight-normal">Contestações GAS</h1>
            <img class="mb-4" src="./img/logo.PNG" alt="" width="200" height="180">

            <label for="inputLoginRede" class="sr-only">Usuário</label>
            <input type="text" id="inputLoginRede" name="txt_login" class="form-control" placeholder="Usuário" autofocus="">

            <label for="inputPassword" class="sr-only">Senha</label>
            <input type="password" name="txt_senha" id="inputPassword" class="form-control" placeholder="Senha">

            <button class="btn btn-lg btn-danger btn-block" name="btn_entrar" type="submit">ENTRAR</button>
            <br/>
            <button class="btn btn-sm btn-outline-danger btn-block" name="btn_cadastrar" type="submit">CADASTRAR</button>
            <button class="btn btn-sm btn-outline-danger btn-block" name="btn_alterarsenha" type="submit">ALTERAR SENHA</button>

            <p class="mt-5 mb-3 text-muted">© 2020</p>

        </form>


    </body>
</html>