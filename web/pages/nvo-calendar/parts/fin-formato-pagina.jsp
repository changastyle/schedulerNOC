</div>
<div class="col-xs-2 col-xs-offset-1">
<div class="panel panel-primary contenedor-grupos col-xs-12 sin-padding">
    <div class="panel-heading h-grupos" style="background-color: #1ABC9C;border:solid 1px #1ABC9C;">
        Grupos
    </div>
    <div class="panel-body contenedor-listado-grupos">
        <ul class="list-group">
            <li class="list-group-item" 
                ng-class="{'true':'grupo-seleccionado'}[grupoSeleccionado.id == grupo.id]"
                ng-repeat="grupo in arrGrupos" 
                ng-click="seleccionarGrupo(grupo)">
                <span class="negrita-r">
                    Grupo
                    {{grupo.nombreGrupo}}
                </span>
                
                <div class="integrante" ng-repeat="integrante in grupo.integrantes">
                    {{integrante.nombre}} {{integrante.apellido}}
                    <br>
                </div>
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