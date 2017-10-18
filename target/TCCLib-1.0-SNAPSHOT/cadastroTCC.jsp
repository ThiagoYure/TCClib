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
                    <div class="center"><h3 class="white-text">Cadastro de Trabalho</h3></div>
                    <div class="divider"></div>
                </div>
                <form action="FrontController?controller=CadastroTCC" method="POST" enctype="multipart/form-data">
                    <div class="row">
                        <div class="input-field col s6">
                            <input name="titulo" id="titulo" type="text" class="validate">
                            <label class="white-text" for="titulo">Título</label>
                        </div>
                        <div class="input-field col s6">
                            <input name="orientador" type="text" class="validate">
                            <label class="white-text" for="orientador">Orientador</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <input name="autor" id="autor" type="text" class="validate">
                            <label class="white-text" for="autor">Autor</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <input id="palavrasChave" name="palavrasChave" type="text" class="validate">
                            <label class="white-text" for="palavrasChave">Palavras-Chave</label>
                        </div>
                        <div class="input-field col s6">
                            <select name="area">
                                <option value="" disabled selected>Escolha a área</option>
                                <option value="Banco de Dados">Banco de Dados</option>
                                <option value="Engenharia de Software">Engenharia de Software</option>
                                <option value="Redes">Redes</option>
                                <option value="Segurança">Segurança</option>
                                <option value="Arquitetura de Sistemas">Arquitetura de Sistemas</option>
                                <option value="Hardware">Hardware</option>
                                <option value="Desenvolvimento de Sistemas">Desenvolvimento de Sistemas</option>
                            </select>
                            <label>Área</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <textarea id="resumo" name="resumo" class="materialize-textarea"></textarea>
                            <label for="resumo">Resumo</label>
                        </div> 
                        <div class="input-field col s6">
                            <input name="ano" type="text" class="validate">
                            <label class="white-text" for="ano">Ano</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="file-field input-field col s12">
                            <div class="btn light-blue">
                                <span>Arquivo PDF</span>
                                <input name="pdf" type="file" id="pdf">
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

