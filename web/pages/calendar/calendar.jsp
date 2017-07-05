<%@page import="java.util.Date"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scheduler NOC | Tecno Accion </title>
        <link href='https://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
        
        <!-- FONTS:-->
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    </head>
    <body ng-app="app" ng-controller="calendario" ng-init="init()">
        
        <!-- CONTENIDO PRINCIPAL:-->
        <div class="contenido-principal col-xs-8 col-xs-offset-2">

            <!-- FILA FECHA DE HOY:-->
            <div class="row-fecha-hoy col-xs-12">
                <div class="flecha-left-hoy col-xs-2" ng-click="disminuirDia()">
                    <span class="glyphicon glyphicon-menu-left"></span>
                </div>
                <div class="indicador-fecha-hoy col-xs-8">
                    {{hoy.strDiaDeLaSemana}}  {{hoy.dia}} de {{hoy.strMes}}
                    <br>
                    {{hoy.dia}}/{{hoy.mes}}/{{hoy.year}}
                </div>
                <div class="flecha-right-hoy col-xs-2" ng-click="aumentarDia()">
                    <span class="glyphicon glyphicon-menu-right"></span>
                </div>
            </div>
            
            <!-- CALENDARIO NOC:-->
            <div class="calendarioNoc">
                
                <div class="semana" ng-repeat="semana in calendarioNOC.semanas" >
                    
                    <div class="dias" ng-repeat="dia in semana.dias" ng-class="{true:'dia-mes-pasado', false:'dia-mes-actual'}[dia.esDelMesPasado]">
                        <div class="encabezado-dia">
                            {{dia.diaDeLaSemana}}
                            {{dia.numeroMes}}
                        </div>
                        
                    </div>
                    
                </div>
                
            </div>
                
        </div>
        
    </body>
    
    <!-- SCRIPT ANGULAR CONTROLLER P/CALENDAR :-->
    <%@include file="fn-calendar.jsp" %>
    <style>
        body
        {
            background-image: url('../res/img/noc.JPG');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        *
        {
            font-family: 'Raleway', sans-serif;
        }
        .wrap
        {
            display: none;
        }
        .text
        {
            font-family: 'Lobster', cursive;
            margin: 0px;
            padding: 8px;
            text-align: center;
        }
        .contenido-principal
        {
            background-color:white;
        }
    </style>
    <style>
        .row-fecha-hoy
        {
            //border:solid 2px black;
            padding:25px;
            text-align: center;
        }
        .flecha-left-hoy
        {
            padding:25px;
            font-size: 32px;
            min-height: 140px;
            background-color: #16a085;
            color: white;
            cursor: pointer;
        }
        .flecha-right-hoy
        {
            padding:25px;
            min-height: 140px;
            font-size: 32px;
            background-color: #16a085;
            color: white;
            cursor: pointer;
        }
        .indicador-fecha-hoy
        {
            padding:25px;
            font-weight: bold;
            font-size: 32px;
            overflow: hidden;
            background-color: #1abc9c;
            color: white;
        }
    </style>
    <style>
        .semana
        {
            //border:solid 2px red;
        }
        .dias
        {
            //border:solid 1px grey;
            display: inline-block;
            overflow: hidden;
            width: calc(100% / 7 );
            height: 200px;
        }
        .dia-mes-pasado
        {
            background-color: lightgray;
        }
        .encabezado-dia
        {
            text-align: center;
            width: 100%;
            color:white;
            background-color: #e67e22;
            padding: 12px;
        }
    </style>
</html>   