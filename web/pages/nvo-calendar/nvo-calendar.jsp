<%-- 
    Document   : nvo-calendar
    Created on : 26/12/2017, 16:34:30
    Author     : ngrossi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../comun/comun.jsp" %>
    </head>
    <body ng-app="app" ng-controller="horarioNoc" ng-init="init()" ng-cloak style="padding-top: 50px;">
        
        <!-- INICIO FORMATO PAGINA:-->
        <%@include file="parts/inicio-formato-pagina.jsp" %>
        
            <!-- BANNER MES Y ANIO ACTUAL:-->
            <%@include file="parts/banner-fecha.jsp" %>
            
            <!-- CALENDARIO CON LOS DIAS DEL MES Y ANIO ACTUAL:-->
            <%@include file="parts/dias-del-mes.jsp" %>
        
        <!-- FIN FORMATO PAGINA:-->
        <%@include file="parts/fin-formato-pagina.jsp" %>
        
    </body>
    <script>
        app = angular.module('app', []);
       
        app.controller('horarioNoc', function($scope) 
        {
            $scope.init = function()
            {
                $scope.mesYAnioActual();
            }
            
            $scope.grupoSeleccionado = null;
            $scope.seleccionarGrupo = function(grupo)
            {
                if($scope.grupoSeleccionado == grupo)
                {
                    $scope.grupoSeleccionado = null;
                }
                else
                {
                    $scope.grupoSeleccionado = grupo;
                }
                $scope.$evalAsync();
            }
            
            $scope.estructura = {};
            $scope.mesYAnioActual = function()
            {
                $.ajax(
                {
                    url:"../../mesYAnioActual",
                    data:
                    {
                        "aumento":$scope.aumento
                    },
                    beforeSend: function (xhr) 
                    {
                        $scope.estructura = {};
                        $scope.cargando = true;
                        console.log("trayendo nuevo calendario " );
                    },
                    success: function (resultado, textStatus, jqXHR) 
                    {
                        console.log("res nvo calendario: " + JSON.stringify(resultado));
                        $scope.estructura = resultado;
                        $scope.cargando = false;
                        $scope.$evalAsync();
                    }
                });
            }
            //FUNCIONES AUMENTAR O DISMINUIR DIAS:
            $scope.aumento = 0;
            $scope.aumentarMes = function()
            {
                console.log("aumento mes: " + $scope.aumento);
                $scope.aumento++;
                $scope.$evalAsync();
                $scope.mesYAnioActual();
            }
            $scope.disminuirMes = function()
            {
                console.log("diminuir mes: " + $scope.aumento);
                $scope.aumento--;
                $scope.$evalAsync();
                $scope.mesYAnioActual();
            }
            $scope.printDiv = function(divName) 
            {
                var printContents = document.getElementById(divName).innerHTML;
                var originalContents = document.body.innerHTML;

                document.body.innerHTML = printContents;

                window.print();

                document.body.innerHTML = originalContents;
            }
        });
    </script>
    <style>
        .sin-padding
        {
            padding-left: 0px;
            padding-right: 0px;
        }
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
            padding-top:25px;
            padding-bottom:25px;
            text-align: center;
        }
        .flechas-date
        {
            padding-top: 32px;
            font-size: 32px;
            height: 96px;
            background-color: #16a085;
            color: white;
            cursor: pointer;  
        }
        .flecha-left-hoy
        {
            
        }
        .flecha-right-hoy
        {
        }
        .indicador-fecha-hoy
        {
            padding:25px;
            font-weight: bold;
            font-size: 32px;
            overflow: hidden;
            background-color: #1abc9c;
            color: white;
            height: 96px;
            
            
        }
    </style>
    <style>
        .semana
        {
            margin-bottom: 12px;
            //border:solid 2px red;
        }
        .dias
        {
            
            display: inline-block;
            overflow: hidden;
            width: calc(100% / 7 );
            height: 200px;
            //border:solid 1px red;
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
            //background-color: #e67e22;
            background-color: #16A085;
            padding: 12px;
        }
    </style>
</html>
