<%-- 
    Document   : pdf
    Created on : 18/10/2017, 12:01:39
    Author     : ThigoYure
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="myTags" uri="/WEB-INF/tlds/MyTags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>TCCLib - Busca de Trabalhos!</title>
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
                    <div class="center"><h3 class="white-text">Trabalho</h3></div>
                    <div class="divider"></div>
                    <myTags:buscaTcc id="${param.id}"/>

                    <div>
                        <iframe src="${pdf.url}"></iframe>
                    </div>
                    <div class="collection white small">
                        <c:choose>
                            <c:when test="${empty TCCS}">
                                <h3>Não há resultados para a busca</h3>
                            </c:when>
                            <c:when test="${not empty TCCS}">
                                <c:forEach var="Tccs" items="${TCCS}" >
                                    <a href="pdf.jsp?id=${Tccs.id}">
                                        <div class="collection-item light-blue accent-2 white-text">
                                            <p><b>Título:</b>${Tccs.titulo}</p> 
                                            <p><b>Autor:</b>${Tccs.autor}</p>
                                            <p><b>Ano:</b>${Tccs.ano}</p>
                                            <p><b>Resumo:</b>${Tccs.resumo}</p>
                                            <div class="divider"></div>
                                        </div>
                                    </a>
                                </c:forEach>
                            </c:when>
                        </c:choose> 
                    </div>
                </div>

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
