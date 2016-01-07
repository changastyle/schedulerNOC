<%-- 
    Document   : index
    Created on : 04/01/2016, 21:07:17
    Author     : Nicolas
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%  
            String year = request.getParameter("year");
            if(! (year != null))
            {
                Date today = new Date();
                year = "" + (today.getYear() + 1900);
            }
            session.setAttribute( "year", year );
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scheduler NOC | Tecno Accion </title>
        <link href='https://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
        <style>
            body
            {
                background-image: url('res/img/noc.JPG');
                background-size: cover;
                background-repeat: no-repeat;
                background-attachment: fixed;
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
        </style>
    </head>
    <body ng-app="app" ng-controller="controller">
        <div class="col-xs-8 col-xs-offset-1" style="background-color: rgba(0,0,0 , 0.75) ; border-radius:15px; margin-top: 25px;">
            <!--<h1 style="color:white;"><%= year %></h1>-->
            <div ng-repeat="mes in meses" class="col-sm-4 col-sm-offset">    
                <ul class="list-group">
                    <h3 class="list-group-item active" ng-click="desplegar(mes.nombreMes)" style="cursor:pointer;">{{mes.nombreMes + " " + mes.year}}</h3>
                    <div class="wrap" id="wrap{{mes.nombreMes}}">
                        <li class="list-group-item" ng-repeat="dia in mes.arrDiasDelMes">  {{dia.nombreDia + " " + dia.numeroDiaEnElMes + " : " + dia.grupoMananero + " | " + dia.grupoTarde}}</li>
                    </div>
                </ul>
            </div>
            <h3 class="text" style="color:white;">Clickear en un encabezado del mes para mas informacion!!</h3>
        </div>
        
        
        <div class="col-xs-2 panel-group" style="position: fixed;top:25px;right: 10px;">
            <div class="panel panel-primary">
                <div class="panel-heading "><h3 class="text">Grupos:</h3></div>
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item">Grupo A: Diego/Nico</li>
                        <li class="list-group-item">Grupo B: Jorge/Jorge</li>
                        <li class="list-group-item">Grupo C: Esteban.</li>
                    </ul>
                </div>
            </div>
        </div>
        
        <div class="alert alert-success col-sm-8 col-sm-offset-1" style="position: fixed;bottom: 15px;z-index: -3">
            <strong>Queres cambiar el año??</strong> 
            Simplemente al final de la URL agregá <strong>?year=2017</strong><br>
            <strong>Ejemplo:</strong>/schedulerNOC/pages/index.jsp<strong>?year=2017</strong>
        </div>
    </body>
    <script>
    app = angular.module('app', []);
       
    app.controller('controller', function($scope, $http) 
    {
        $scope.mesSeleccionado = "";
        $http.get("../WS/WS.jsp").then(function(response) 
        {
            console.log(response.data);
            $scope.meses = response.data;
            
        });
        $scope.hideAll = function()
        {
            console.log("hideALL");
            
            $(".wrap").each(function(index,element)
            {
                $(element).hide("fast");
            });
        }
        $scope.desplegar = function(nombre)
        {
            console.log(nombre + " " + $("#wrap"+nombre) );
            
            
            $(".wrap").each(function(index,element)
            {
                $(element).hide("slow");
            });
            
            if(nombre != $scope.mesSeleccionado)
            {
                $("#wrap"+nombre).show("slow");
            }
            $scope.mesSeleccionado = nombre;
            
        }
    });
    </script>
</html>
