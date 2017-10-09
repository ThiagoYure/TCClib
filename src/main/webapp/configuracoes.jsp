<%-- 
    Document   : configuracoes
    Created on : 09/10/2017, 00:56:46
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
        <title>TCCLib - Configurações!</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="blue-grey darken-4">
        <div class="container">
            <div class="row center-align">
                <a href="inicial.jsp" class="waves-effect waves-light btn pink darken-4">Home</a>
                <a href="configuracoes.jsp" class="waves-effect waves-light btn pink darken-4">Configurações</a>
                <a href="FrontController?controller=Sair" class="waves-effect waves-light btn pink darken-4">Sair</a>
            </div>
            <div class="row">
                <div class="container">
                    </br>
                    <div class="center"><h3 class="white-text">Alteração de dados</h3></div>
                    <div class="divider"></div>
                </div>
                <form action="FrontController?controller=Configuracao" method="POST" enctype="multipart/form-data">
                    <div class="row">
                        <div class="input-field col s6">
                            <input name="email" id="email" type="email" class="validate">
                            <label class="white-text" for="email">Email</label>
                        </div>
                        <div class="input-field col s6">
                            <input name="senha" type="password" class="validate">
                            <label class="white-text" for="senha">Senha</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <input id="nome" name="nome" type="text" class="validate">
                            <label class="white-text" for="nome">Nome</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="instituicao" name="instituicao" type="text" class="validate">
                            <label class="white-text" for="instituicao">Instituição</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <input name="nascimento" type="text" class="datepicker" required>
                            <label class="white-text" for="birthdate">Data de nascimento</label>
                        </div> 
                        <div class="file-field input-field col s6">
                            <div class="btn light-blue">
                                <span>Foto de Perfil</span>
                                <input name="fotoPerfil" type="file" id="arquivo">
                            </div>
                            <div class="file-path-wrapper">
                                <input class="file-path validate" type="text">
                            </div>
                        </div>
                    </div>
                    <div class="row center-align">
                        <input class="light-blue waves-effect waves-light btn" type="submit" value="Salvar">
                    </div>
                </form>
            </div>
        </div>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 15,
                    monthsFull: ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'],
                    monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
                    weekdaysFull: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabádo'],
                    weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
                    today: 'Hoje',
                    clear: 'Limpar',
                    close: 'Pronto',
                    labelMonthNext: 'Próximo mês',
                    labelMonthPrev: 'Mês anterior',
                    labelMonthSelect: 'Selecione um mês',
                    labelYearSelect: 'Selecione um ano',
                    format: 'dd/mm/yyyy'
                });
                $('select').material_select();
            });
        </script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>
