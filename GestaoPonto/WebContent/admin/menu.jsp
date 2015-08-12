<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@taglib prefix="rich" uri="http://richfaces.org/rich" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GPE</title>
</head>
<f:view>
<body style="text-align:center;background-color="light-gray";vertical-align: middle; background-repeat: no-repeat">
<div>
<rich:panel header="Gestão de Ponto Eletrônico">
<rich:panel header="">
<h:form>
<f:subview id="Menu">
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
		</rich:dropDownMenu>
	</rich:toolBar>
</div>
</f:subview> 

</h:form>
</rich:panel>
</rich:panel>
</div>
</body>
</f:view>
</html>