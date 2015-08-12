<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@taglib prefix="rich" uri="http://richfaces.org/rich" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Licenca</title>
</head>
<f:view>
<body>
<a4j:support event="onload" action="#{licencaManagerBean.limpar }" />	
<h:form>
	<jsp:directive.include file="../admin/menuinclude.jsp" />
	<a4j:keepAlive beanName="licencaManagerBean"/>
	<div align="left">
		<!-- Começo do panel externo -->
		<rich:panel header="Cadastro Licenca" >
			<rich:messages style="color:red;font-weight:bold"/>
			<!-- Começo do panelBar -->
			<rich:panelBar>
				<!-- Começo do panelBarItem -->
				<rich:panelBarItem label="">
					<a4j:commandLink action="#{licencaManagerBean.limpar}" title="Novo" reRender="funcionariolicenca,tipolicenca,datainilicenca,datafimlicenca,datalista">
						<img src="../images/novo.png" align="left"/>
					</a4j:commandLink>
					<a4j:commandLink action="voltar" title="Inicio">
						<img src="../images/home.jpg" align="right"/>
					</a4j:commandLink>
					<a4j:commandLink action="#{licencaManagerBean.excluirLicenca}" title="Excluir" reRender="funcionariolicenca,tipolicenca,datainilicenca,datafimlicenca,datalista">
						<img src="../images/lixeira2.png" align="right"/>
					</a4j:commandLink>
					<a4j:commandLink action="#{licencaManagerBean.salvarLicenca}" title="Salvar" reRender="funcionariolicenca,tipolicenca,datainilicenca,datafimlicenca,datalista">
						<img src="../images/btnSalvar.png" align="right"/>
					</a4j:commandLink>
					
		
				
				</rich:panelBarItem> 
				<!-- Fim do panelBarItem -->
			</rich:panelBar>
			<!-- Fim do panelBar -->
			
			<!-- Começo da table -->
			<table>
				
	            <tr>
                     <td>  
                         Nome do Funcionario:
                     </td>
                     <td>                                      
                         <h:inputText id="funcionariolicenca" value="#{licencaManagerBean.licenca.funcionario.nome}" size="30"/>
                     	 
       					<rich:suggestionbox id="suggestionboxid"  var="func" fetchValue="#{func.nome}" for="funcionariolicenca"
						 suggestionAction="#{funcionarioManagerBean.complemento }" >
             			<h:column>
                   			<h:outputText value="#{func.nome}"/>
            			</h:column>
                         <a4j:support event="onselect"  reRender="funcionariolicenca" ajaxSingle="true">
                             <f:setPropertyActionListener value="#{func}"
                                 target="#{licencaManagerBean.licenca.funcionario}" />
                      
                         </a4j:support>
           				</rich:suggestionbox>
                     </td>					
				</tr>
				<tr>
                     <td>  
                         <h:outputLabel value="*" style="color:red"/>
                         Tipo da Licenca:
                     </td>
                    <td>                                      
                         <h:selectOneMenu  id="tipolicenca" value="#{licencaManagerBean.licenca.tipolicenca}" converter="tipoLicencaConverter">
								<f:selectItems  value="#{licencaManagerBean.listaTipoLicencas}" var="tipo" itemLabel="#{tipo.nome}"/>	       
						 </h:selectOneMenu>
                     </td>							
				</tr>
				<tr>
	                 <td colspan="2" >  
	                      <h:outputLabel value="De:"/>
	                       <rich:calendar id="datainilicenca" ajaxSingle="true" datePattern="dd/MM/yyyy"
					    	value="#{licencaManagerBean.licenca.data_ini}" />       
					    <h:outputLabel value="Até:"/>
	                       <rich:calendar id="datafimlicenca" ajaxSingle="true" datePattern="dd/MM/yyyy"
					    	value="#{licencaManagerBean.licenca.data_fim}" />                                      
	                 </td>                                   
	            </tr>
				<tr>
	                 <td colspan="2" >  
	                      <h:outputLabel value="*Campos Obrigatórios!" style="color:red;font-weight:bold;font-size:10px;"/>                                     
	                 </td>                                   
	            </tr>
			</table>
			<!-- Fim da table -->
		
		
		<!-- Começo do panel interno -->
		<rich:panel header="Lista de licenca" >
			<!-- Começo do dataTable -->
			<rich:dataTable width="100%" border="1" id="datalista" var="lislic" value="#{licencaManagerBean.listaLicencas}" >
			
                <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Funcionario"/>
					</f:facet>
                    <h:outputText value="#{lislic.funcionario.nome}" />
	            </rich:column>
                <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Tipo da Licenca"/>
					</f:facet>
                    <h:outputText value="#{lislic.tipolicenca.nome}" />
	            </rich:column>
	                            <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Data de início"/>
					</f:facet>
                    <h:outputText value="#{lislic.data_ini}" >
                    	<f:convertDateTime pattern="dd/MM/yyyy"/>
                    </h:outputText>
	            </rich:column>
	            <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Data de término"/>
					</f:facet>
                    <h:outputText value="#{lislic.data_fim}" >
                    	<f:convertDateTime pattern="dd/MM/yyyy"/>
                    </h:outputText>
	            </rich:column>
	             <rich:column style="text-align:center;"><!-- Botao para alterar -->
	           	   <f:facet name="header">
               	   		<h:outputLabel value="Alterar"/>
               	   </f:facet>
                   <a4j:commandLink  value="" reRender="funcionariolicenca,tipolicenca,datainilicenca,datafimlicenca" ajaxSingle="true" >
                   	  <f:setPropertyActionListener value="#{lislic }" target="#{licencaManagerBean.licenca }"/>
                      <img src="../images/editar.png"/> 
                   </a4j:commandLink>
               </rich:column> 
			</rich:dataTable>
			<!-- Fim da dataTable -->
		</rich:panel>
		<!-- Fim do panel interno -->
	</rich:panel>
	<!-- Fim do panel externo -->
	</div>
	
</h:form>
	
</body>
</f:view>
</html>
