<f:subview id="Menu">
<rich:panel header="Gestão de Ponto Eletrônico">
<rich:panel header="">

<div align="left">
	<rich:toolBar>
		<rich:dropDownMenu value="" >
			<f:facet name="label">   
                 <h:panelGroup>    
                     <h:outputText value="Cadastrar"/>  
                 </h:panelGroup>  
            </f:facet>  
			<rich:menuItem value="Departamento" submitMode="ajax" action="#{departamentoManagerBean.prepararAdicionarDepartamento }" style="text-align:left;"/>
			<rich:menuItem value="Funcionario" submitMode="ajax" action="#{funcionarioManagerBean.prepararAdicionarFuncionario}" style="text-align:left;"/>
			<rich:menuItem value="Ferias" submitMode="ajax" action="#{feriasManagerBean.prepararAdicionarFerias}" style="text-align:left;"/>
			<rich:menuItem value="Licenca" submitMode="ajax" action="#{licencaManagerBean.prepararAdicionarLicenca}" style="text-align:left;"/>
			<rich:menuItem value="Tipos de Licenca" submitMode="ajax" action="#{tipoLicencaManagerBean.prepararAdicionarTipoLicenca}" style="text-align:left;"/>
			<rich:menuItem value="Tipos de Dia" submitMode="ajax" action="#{tipoDiaManagerBean.prepararAdicionarTipoDia}" style="text-align:left;"/>
			<rich:menuItem value="Turno" submitMode="ajax" action="#{turnoManagerBean.prepararAdicionarTurno}" style="text-align:left;"/>
			<rich:menuItem value="Evento" submitMode="ajax" action="#{eventoManagerBean.prepararAdicionarEvento}" style="text-align:left;"/>
		</rich:dropDownMenu>
	</rich:toolBar>
</div>

</rich:panel>
</rich:panel>
</f:subview> 