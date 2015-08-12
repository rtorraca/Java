<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@taglib prefix="rich" uri="http://richfaces.org/rich" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Departamento</title>
</head>
<f:view>
<body>
	
<h:form>
	<jsp:directive.include file="../admin/menuinclude.jsp" />
	<a4j:keepAlive beanName="departamentoManagerBean"/>
	<div align="left">
		<!-- Começo do panel externo -->
		<rich:panel header="Cadastro Departamento" >
			<rich:messages style="color:red;font-weight:bold"/>
			<!-- Começo do panelBar -->
			<rich:panelBar>
				<!-- Começo do panelBarItem -->
				<rich:panelBarItem label="">
					<a4j:commandLink action="#{departamentoManagerBean.limpar}" title="Limpar" reRender="nomedepartamento,datalista">
						<img src="../images/novo.png" align="left"/>
					</a4j:commandLink>
					
					<a4j:commandLink action="voltar" title="Inicio">
						<img src="../images/home.jpg" align="right"/>
					</a4j:commandLink>
					<a4j:commandLink action="#{departamentoManagerBean.excluirDepartamento}" title="Excluir" reRender="nomedepartamento,datalista">
						<img src="../images/lixeira2.png" align="right"/>
					</a4j:commandLink>
					<a4j:commandLink action="#{departamentoManagerBean.salvarDepartamento}" title="Salvar" reRender="nomedepartamento,datalista">
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
                         <h:outputLabel value="*" style="color:red"/>
                         Nome Departamento:
                     </td>
                     <td>                                      
                         <h:inputText id="nomedepartamento"   value="#{departamentoManagerBean.departamento.nome}" size="70"  maxlength="150" />
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
		<rich:panel header="Lista de departamento" >
			<!-- Começo do dataTable -->
			<rich:dataTable width="100%" border="1" id="datalista" var="lisdep" value="#{departamentoManagerBean.listaDepartamentos}" >
			
                <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Nome do Departamento"/>
					</f:facet>
                    <h:outputText value="#{lisdep.nome}" />
	            </rich:column>
	            <rich:column style="text-align:center;"><!-- Botao para alterar -->
	           	   <f:facet name="header">
               	   		<h:outputLabel value="Alterar"/>
               	   </f:facet>
                   <a4j:commandLink  value="" reRender="nomedepartamento" >
                   	<f:setPropertyActionListener value="#{lisdep}" target="#{departamentoManagerBean.departamento }"/>
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
