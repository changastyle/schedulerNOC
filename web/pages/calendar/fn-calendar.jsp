<script>app = angular.module('app', []);
       
app.controller('calendario', function($scope, $http) 
{
    $scope.contadorAumento = 0;
    
    
    $scope.mesSeleccionado = "";
    $scope.init = function()
    {
        $scope.queDiaEsHoy();
    }
    
    
    $scope.hoy = null;
    $scope.queDiaEsHoy = function()
    {
        $.ajax(
        {
            url:"../../queDiaEsHoy",
            data:
            {
                "contadorAumento":$scope.contadorAumento   
            },
            beforeSend: function (xhr) 
            {
                        
            },success: function (resultado, textStatus, jqXHR) 
            {
                console.log("res que dia es hoy : "+ resultado);    
                $scope.hoy = resultado;
                $scope.traerCalendario();
                $scope.$apply();
            }
        });
    }
    $scope.calendarioNOC = [];
    $scope.traerCalendario = function()
    {
        if($scope.calendarioNOC.numeroMes != $scope.hoy.mes)
        {
            $.ajax(
            {
                url:"../../calendarioNoc",
                data:
                {
                    "mes":$scope.hoy.mes,    
                    "year":$scope.hoy.year   
                },
                beforeSend: function (xhr) 
                {

                },
                success: function (resultado, textStatus, jqXHR) 
                {
                    $scope.calendarioNOC = resultado;
                    $scope.$apply();
                }
            });
        }
    }
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
    
    
    //FUNCIONES AUMENTAR O DISMINUIR DIAS:
    $scope.aumentarDia = function()
    {
        console.log("aumento dia: " + $scope.contadorAumento);
        $scope.contadorAumento++;
        $scope.queDiaEsHoy();
    }
    $scope.disminuirDia = function()
    {
        console.log("disminuir dia: "+ $scope.contadorAumento);
        $scope.contadorAumento--;
        $scope.queDiaEsHoy();
    }
});
</script>