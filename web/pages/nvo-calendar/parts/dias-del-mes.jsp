<!-- CALENDARIO NOC:-->
<div class="calendarioNoc">

    <div class="col-xs-12" ng-show="cargando">
        <div class="col-xs-4 col-xs-offset-4">
            <img src="../res/img/loading.gif" class=" img img-responsive">
        </div>
    </div>
    
    <div class="semana" ng-repeat="semana in estructura.mes.semanas" ng-hide="cargando" >

        <div class="dias" ng-repeat="dia in semana.dias" ng-class="{true:'dia-mes-pasado', false:'dia-mes-actual'}[dia.esDelMesPasado]" > <!-- ng-hide="dia.esEspacio" -->
            <div class="encabezado-dia">
                {{dia.diaDeLaSemana}}
                {{dia.numeroMes}}
                {{"(" + dia.acronimoMes + ")"}}
            </div>
            
            <div class="contenedor-manana-tarde">
                <div class="separador-de-dia full"  ng-class="{'{{dia.grupoMananero.nombreGrupo}}':'grupo-seleccionado'}[grupoSeleccionado]" ng-show="dia.esDomingo">
                    <span class="negrita" >Full</span>
                    <br>
                    {{dia.grupoMananero.integrantes[0].nombre}} y
                    {{dia.grupoMananero.integrantes[1].nombre}}
                </div>
                <div class="separador-de-dia manana" ng-class="{'{{dia.grupoMananero.nombreGrupo}}':'grupo-seleccionado'}[grupoSeleccionado]" ng-hide="dia.esDomingo">
                    <span class="negrita">Mañana</span>
                    <br>
                    {{dia.grupoMananero.integrantes[0].nombre}} y
                    {{dia.grupoMananero.integrantes[1].nombre}}
                </div>
                <div class="separador-de-dia tarde" ng-class="{'{{dia.grupoTarde.nombreGrupo}}':'grupo-seleccionado'}[grupoSeleccionado]"  ng-hide="dia.esDomingo">
                    <span class="negrita">Tarde</span>
                    <br>
                    {{dia.grupoTarde.integrantes[0].nombre}} y
                    {{dia.grupoTarde.integrantes[1].nombre}}
                </div>
            </div>
        </div>

    </div>

</div>

<style>
    .contenedor-manana-tarde
    {
        //border: solid 1px grey;
    }
    .separador-de-dia
    {
        
    }
    .full
    {
        text-align: center;
        font-size: 18px;
        height: 152px; 
        background-color: #1ABC9C;
        color: white;
        padding-top:40px;
    }
    .manana
    {
        padding-top:10px;
        text-align: center;
        font-size: 18px;
        height: 76px;
        
    }
    .tarde
    {
        padding-top:10px;
        text-align: center;
        font-size: 18px;
        height: 76px;
        border-top: solid 1px grey;
    }
    .negrita
    {
        font-weight: bold;
    }
</style>