<%-- 
    Document   : inicial
    Created on : 18/09/2017, 00:51:30
    Author     : ThigoYure
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>TCCLib - Bem-vindo ${user.nome}!</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="blue-grey darken-4">
        <div class="container">
            <div class="row center-align">
                <a href="inicial.jsp" class="waves-effect waves-light btn pink darken-4">Home</a>
                <a href="configuracoes.jsp" class="waves-effect waves-light btn pink darken-4">Configurações</a>
                <a href="FrontController?controller=Sair" class="waves-effect waves-light btn pink darken-4">Sair</a>
            </div>
            <div class='row white-text'>
                <div class="col s12 center-align">
                    <img class="responsive-img" src="images/Logo.png" style="width: 200px;height: 200px">
                </div>
            </div></br>
            <div class="row">
                <div class="container">
                    <div class="card pink darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Cadastrar Trabalho</span>
                            <a href="cadastroTCC.jsp">Clique aqui!</a>
                        </div>
                    </div>
                    <div class="card pink darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Buscar Trabalhos</span>
                            <a href="buscarTCC.jsp">Clique aqui!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $(".button-collapse").sideNav();
            });
        </script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>
