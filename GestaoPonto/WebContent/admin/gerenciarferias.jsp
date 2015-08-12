<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@taglib prefix="rich" uri="http://richfaces.org/rich" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Ferias</title>
</head>
<f:view>
<body>
<a4j:support event="onload" action="#{feriasManagerBean.limpar }" />	
<h:form>
	<jsp:directive.include file="../admin/menuinclude.jsp" />
	
	<a4j:keepAlive beanName="feriasManagerBean"></a4j:keepAlive>
	<a4j:keepAlive beanName="parcelaManagerBean"></a4j:keepAlive>
	
	<div align="left">
	<h:panelGroup layout="block" id="painelPrincipal">
	
	
	<rich:tabPanel 	id="abas" switchType="ajax" >
		<rich:tab id="tabferias" name="ferias" label="Ferias" focus="funcionarioferias">
			<rich:panel header="Cadastro Ferias">
			<rich:messages style="color:red;font-weight:bold"/>
			<!-- Começo do panelBar -->
			<rich:panelBar>
				<!-- Começo do panelBarItem -->
				<rich:panelBarItem label="">
					<a4j:commandLink action="#{feriasManagerBean.limpar}" title="Novo" reRender="datalista,funcionarioferias,diasgozadosferias,diasvendidosferias">
						<img src="../images/novo.png" align="left"/>
					</a4j:commandLink>
					<a4j:commandLink action="voltar" title="Iniciio">
						<img src="../images/home.jpg" align="right"/>
					</a4j:commandLink>
					<a4j:commandLink action="#{feriasManagerBean.excluirFerias}" title="Excluir" reRender="datalista,funcionarioferias,diasgozadosferias,diasvendidosferias">
						<img src="../images/lixeira2.png" align="right"/>
					</a4j:commandLink>
					<a4j:commandLink action="#{feriasManagerBean.salvarFerias}" title="Salvar" reRender="datalista,funcionarioferias,diasgozadosferias,diasvendidosferias">
						<f:setPropertyActionListener value="#{feriasManagerBean.ferias}" target="#{parcelaManagerBean.parcela.ferias }"/>
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
							                 
                     	 <h:inputText id="funcionarioferias" value="#{feriasManagerBean.ferias.funcionario.nome}" size="30"/>
                     	 
       					<rich:suggestionbox id="idsuggestionbox"  var="func" fetchValue="#{func.nome}" for="funcionarioferias"
						 suggestionAction="#{funcionarioManagerBean.complemento }" >
             			<h:column>
                   			<h:outputText value="#{func.nome}"/>
            			</h:column>
                         <a4j:support event="onselect"  reRender="funcionarioferias" ajaxSingle="true">
                             <f:setPropertyActionListener value="#{func}"
                                 target="#{feriasManagerBean.ferias.funcionario}" />
                      
                         </a4j:support>
           				</rich:suggestionbox>
                     </td>		
                   			
				</tr>
				<tr>
					<td>                                      
	     				Dias gozados:
	                </td>
	                <td>                                      
	                    <h:inputText id="diasgozadosferias" value="#{feriasManagerBean.ferias.dias_gozados}" />
	                </td>
	            </tr>
	            <tr>
					<td>                                      
	     				Dias vendidos:
	                </td>
	                <td>                                      
	                    <h:inputText id="diasvendidosferias" value="#{feriasManagerBean.ferias.dias_vendidos}" />
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
		<rich:panel header="Lista de ferias" style="width=500px">
			<!-- Começo do dataTable -->
			<rich:dataTable width="100%" border="1" id="datalista" var="lisferias" value="#{feriasManagerBean.listaFerias}" >
			
                <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Nome do Funcionario"/>
					</f:facet>
                    <h:outputText value="#{lisferias.funcionario.nome}" />
	            </rich:column>
	            <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Dias gozados"/>
					</f:facet>
                    <h:outputText value="#{lisferias.dias_gozados}" />
	            </rich:column>
	            <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Dias vendidos"/>
					</f:facet>
                    <h:outputText value="#{lisferias.dias_vendidos}" />
	            </rich:column>
	           <rich:column style="text-align:center"><!-- Botao para alterar -->
	           	   <f:facet name="header">
               	   		<h:outputLabel value="Alterar"/>
               	   </f:facet>
                   <a4j:commandLink  value="" reRender="datalista,funcionarioferias,diasgozadosferias,diasvendidosferias" ajaxSingle="true" >
                   		<f:setPropertyActionListener value="#{lisferias }" target="#{feriasManagerBean.ferias }"/>
                   		<f:setPropertyActionListener value="#{lisferias }" target="#{parcelaManagerBean.parcela.ferias }"/>
                      <img src="../images/editar.png"/> 
                   </a4j:commandLink>
               </rich:column> 
        
			</rich:dataTable>
			<!-- Fim da dataTable -->
		</rich:panel>
		
		
		</rich:panel>
	</rich:tab>
	<rich:tab id="tabparcelas" name="parcelas" label="Parcelas" focus="datainiparcela">
		<rich:panel header="Cadastro Parcela" >
			<rich:messages style="color:red;font-weight:bold"/>
			<!-- Começo do panelBar -->
			<rich:panelBar>
				<!-- Começo do panelBarItem -->
				<rich:panelBarItem label="">
					<a4j:commandLink action="#{parcelaManagerBean.limpar}" title="Novo" reRender="datalista2,datainiparcela,datafimparcela">
						<img src="../images/novo.png" align="left"/>
					</a4j:commandLink>
					<a4j:commandLink action="voltar" title="Inicio">
						<img src="../images/home.jpg" align="right"/>
					</a4j:commandLink>
					<a4j:commandLink action="#{parcelaManagerBean.excluirParcela}" title="Excluir" reRender="datalista2,datainiparcela,datafimparcela">
						<img src="../images/lixeira2.png" align="right"/>
					</a4j:commandLink>
					<a4j:commandLink action="#{parcelaManagerBean.salvarParcela}" title="Salvar" reRender="datalista2,datainiparcela,datafimparcela">
						<img src="../images/btnSalvar.png" align="right"/>
					</a4j:commandLink>
				
					
					
				</rich:panelBarItem> 
				<!-- Fim do panelBarItem -->
			</rich:panelBar>
			<!-- Fim do panelBar -->
			
			<!-- Começo da table -->
			<table>
	

	            <tr>
	                 <td colspan="2" >  
	                   <h:outputLabel value="De:"/>
	                       <rich:calendar id="datainiparcela"  datePattern="dd/MM/yyyy"
					    	value="#{parcelaManagerBean.parcela.data_ini}"  /> 
					    <h:outputLabel value="Até:"/>
	                       <rich:calendar id="datafimparcela" datePattern="dd/MM/yyyy"
					    	value="#{parcelaManagerBean.parcela.data_fim}" />
					                                          
	                 </td>                                   
	            </tr>
	        
			
			</table>
			<!-- Fim da table -->
		
		
		<!-- Começo do panel interno -->
		<rich:panel header="Lista de parcela" style="width=500px">
			<!-- Começo do dataTable -->
			<rich:dataTable width="100%" border="1" id="datalista2" var="lisparcela" value="#{feriasManagerBean.listaParcelas}" >
             
                <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Data de início"/>
					</f:facet>
                    <h:outputText value="#{lisparcela.data_ini}" >
                    	<f:convertDateTime pattern="dd/MM/yyyy"/>
                    </h:outputText>
	            </rich:column>
	            <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Data de término"/>
					</f:facet>
                    <h:outputText value="#{lisparcela.data_fim}" >
                     	<f:convertDateTime pattern="dd/MM/yyyy"/> 
                    </h:outputText>
	            </rich:column>
	           <rich:column><!-- Botao para alterar -->
                   <a4j:commandLink  value="" reRender="datalista2,datainiparcela,datafimparcela" >
                    <f:setPropertyActionListener value="#{lisparcela}" target="#{parcelaManagerBean.parcela}"/>
                      <img src="../images/editar.png"/> 
                   </a4j:commandLink>
               </rich:column> 
			</rich:dataTable>
			<!-- Fim da dataTable -->
		</rich:panel>
		<!-- Fim do panel interno -->
		</rich:panel>
	</rich:tab>
</rich:tabPanel>

</h:panelGroup>

</div>
	
</h:form>
	
</body>
</f:view>
</html>
