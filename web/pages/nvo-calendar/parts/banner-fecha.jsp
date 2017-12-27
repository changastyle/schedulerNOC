<!-- FILA FECHA DE HOY:-->
<div class="row-fecha-hoy col-xs-12 sin-padding">
    <div class="flechas-date flecha-left-hoy col-xs-2" ng-click="disminuirMes()">
        <span class="glyphicon glyphicon-menu-left"></span>
    </div>

    <div class="indicador-fecha-hoy col-xs-8">
        {{estructura.strMes}} {{estructura.year}}
        <button class="btn btn-default btn-lg" ng-click="printDiv('contenido-principal')" style="float:right;">
            <span class="glyphicon glyphicon-print"></span>
        </button>
    </div>

    <div class="flechas-date flecha-right-hoy col-xs-2" ng-click="aumentarMes()">
        <span class="glyphicon glyphicon-menu-right"></span>
    </div>
</div>