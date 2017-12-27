</div>
<div class="col-xs-2 col-xs-offset-1">
<div class="panel panel-primary contenedor-grupos col-xs-12 sin-padding">
    <div class="panel-heading h-grupos" style="background-color: #1ABC9C;border:solid 1px #1ABC9C;">
        Grupos
    </div>
    <div class="panel-body contenedor-listado-grupos">
        <ul class="list-group">
            <li class="list-group-item" ng-class="{'A':'grupo-seleccionado'}[grupoSeleccionado]" ng-click="seleccionarGrupo('A')">
                <span class="negrita-r"> Grupo A</span>
                <br>
                Diego M
                <br>
                Nico
            </li>
            <li class="list-group-item" ng-class="{'B':'grupo-seleccionado'}[grupoSeleccionado]" ng-click="seleccionarGrupo('B')">
                <span class="negrita-r"> Grupo B</span>
                <br>
                Jorge
                <br>
                Ale
            </li>
            <li class="list-group-item" ng-class="{'C':'grupo-seleccionado'}[grupoSeleccionado]" ng-click="seleccionarGrupo('C')">
                <span class="negrita-r"> Grupo C</span>
                <br>
                Esteban 
                <br>
                Diego C
            </li>
        </ul>
        <h5 style="text-align: center">Click en un grupo para ver mas claro</h5>
    </div>
</div>
<style>
    .h-grupos
    {
            font-family: 'Lobster', cursive;
            font-size: 24px;
            text-align: center;
    }
    .list-group-item
    {
        text-align: center;
        font-size: 16px;
        cursor: pointer;
    }
    .negrita-r
    {
        font-weight: bold; 
        color: red;
    }
    .grupo-seleccionado
    {
        background-color: #f1c40f;
        color: black;
    }
</style>