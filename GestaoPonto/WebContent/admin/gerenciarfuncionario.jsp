<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@ taglib prefix="stella" uri="http://stella.caelum.com.br/faces"%>
<%@ taglib prefix="rich" uri="http://richfaces.ajax4jsf.org/rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Funcionario</title>
<script type="text/javascript" src="../resources/jquery.maskedinput.js"></script>
</head>
<f:view>
<body>
	
<h:form>
	<jsp:directive.include file="../admin/menuinclude.jsp" />
	
	<a4j:keepAlive beanName="funcionarioManagerBean"/>
	<div align="left">
		<!-- Começo do panel externo -->
		<rich:panel header="Cadastro Funcionario" >
			<rich:messages style="color:red;font-weight:bold"/>
			<!-- Começo do panelBar -->
			<rich:panelBar>
				<!-- Começo do panelBarItem -->
				<rich:panelBarItem label="">
					<a4j:commandLink action="#{funcionarioManagerBean.limpar}" title="Novo" reRender="datalista,matriculafuncionario,nomefuncionario,pisfuncionario,cpffuncionario,departamentofuncionario,
						chefefuncionario,loginfuncionario,senhafuncionario,emailfuncionario">
						<img src="../images/novo.png" align="left"/>
					</a4j:commandLink>
					<a4j:commandLink action="voltar" title="Inicio">
						<img src="../images/home.jpg" align="right"/>
					</a4j:commandLink>
					<a4j:commandLink action="#{funcionarioManagerBean.excluirFuncionario}" title="Excluir" reRender="datalista,matriculafuncionario,nomefuncionario,pisfuncionario,cpffuncionario,departamentofuncionario,
						chefefuncionario,loginfuncionario,senhafuncionario,emailfuncionario">
						<img src="../images/lixeira2.png" align="right"/>
					</a4j:commandLink>
					<a4j:commandLink action="#{funcionarioManagerBean.salvarFuncionario}" title="Salvar" reRender="datalista,matriculafuncionario,nomefuncionario,pisfuncionario,cpffuncionario,departamentofuncionario,
					chefefuncionario,loginfuncionario,senhafuncionario,emailfuncionario">
						<img src="../images/btnSalvar.png" align="right"/>
					</a4j:commandLink>
					
					
					
				</rich:panelBarItem> 
				<!-- Fim do panelBarItem -->
			</rich:panelBar>
			<!-- Fim do panelBar -->
			
			<!-- Começo da table -->
			<table>

				<tr>
				<tr>
					<td> 
						<h:outputLabel value="*" style="color:red"/>                                     
	     				Matricula:
	                </td>
	                <td>                                      
	                    <h:inputText id="matriculafuncionario" value="#{funcionarioManagerBean.funcionario.matricula}" />
	                </td>
	            </tr>
	            <tr>
                     <td>  
                         <h:outputLabel value="*" style="color:red"/>
                         PIS:
                     </td>
                     <td>  
                     	   <rich:jQuery selector="#pisfuncionario" query="mask('999.99999.99-9')" timing="onload"/>                                 
                         <h:inputText id="pisfuncionario" validatorMessage="PIS inválido"  value="#{funcionarioManagerBean.funcionario.pis}"  >
                         	<a4j:support event="onchange" action="gerenciarfuncionario" />
                         	<stella:validateNIT formatted="true"/>
                         </h:inputText>
                         
                     </td>					
				</tr>
				<tr>
                     <td>  
                         <h:outputLabel value="*" style="color:red"/>
                       	<h:outputLabel for="cpffuncionario" value="CPF "  />
                     </td>
                     <td>   
                     	   <rich:jQuery selector="#cpffuncionario" query="mask('999.999.999-99')" timing="onload"/>
							<h:inputText id="cpffuncionario" validatorMessage="CPF inválido" value="#{funcionarioManagerBean.funcionario.cpf}" styleClass="edit" size="11">
							<a4j:support event="onchange" action="gerenciarfuncionario" />
							<stella:validateCPF formatted="true"/>
							</h:inputText>
                         
                     </td>					
				</tr>
				<tr>
                     <td>  
                         <h:outputLabel value="*" style="color:red"/>
                         Nome:
                     </td>
                     <td>                                      
                         <h:inputText id="nomefuncionario"   value="#{funcionarioManagerBean.funcionario.nome}" size="70"  maxlength="150" />
                     </td>					
				</tr>

				<tr>
                     <td>  
                         <h:outputLabel value="*" style="color:red"/>
                         Departamento:
                     </td>
                     <td>                                      
                         <h:selectOneMenu  id="departamentofuncionario" value="#{funcionarioManagerBean.funcionario.depto}" converter="departamentoConverter">
								<f:selectItems  value="#{funcionarioManagerBean.listaDepartamentos}" var="depto" itemLabel="#{depto.nome}"/>	       
						 </h:selectOneMenu>
                     </td>					
				</tr>
				<tr>
                     <td>  
                         Chefe:
                     </td>
                     <td>                                      
                         <h:selectOneMenu  id="chefefuncionario" value="#{funcionarioManagerBean.funcionario.chefe}" converter="funcionarioConverter" >
                         		<f:selectItem itemLabel="--------------"/>
								<f:selectItems  value="#{funcionarioManagerBean.listaChefes}" var="chefe" itemLabel="#{chefe.nome}" />	       
						 </h:selectOneMenu>
                     </td>					
				</tr>
				<tr>
                <td>  
                         <h:outputLabel value="*" style="color:red"/>
                         Login:
                     </td>
                     <td>                                      
                         <h:inputText id="loginfuncionario"   value="#{funcionarioManagerBean.funcionario.login}" />
                     </td>					
				</tr>
				<tr>
                     <td>  
                         <h:outputLabel value="*" style="color:red"/>
                         Senha:
                     </td>
                     <td>                                      
                         <h:inputSecret id="senhafuncionario"   value="#{funcionarioManagerBean.funcionario.senha}"/>
                     </td>					
				</tr>
				<tr>
                     <td>  
                         <h:outputLabel value="*" style="color:red"/>
                         <h:outputLabel for="email" value="E-mail "  />
                     </td>
                     <td>                                      
                         
						<h:inputText id="email" value="#{funcionarioManagerBean.funcionario.email}" styleClass="edit" size="30">
						<f:validator validatorId="emailValidator"/>
					</h:inputText>
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
		<rich:panel header="Lista de funcionario" >
			<!-- Começo do dataTable -->
			<rich:dataTable width="100%" border="1" id="datalista" var="lisfunc" value="#{funcionarioManagerBean.listaFuncionarios}" >
				<rich:column >
                   	<f:facet name="header">
 						<h:outputText  value="Matricula"/>
					</f:facet>
                    <h:outputText value="#{lisfunc.matricula}"/>
                </rich:column>
                <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Nome do Funcionario"/>
					</f:facet>
                    <h:outputText value="#{lisfunc.nome}" />
	            </rich:column>
	            <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="PIS do Funcionario"/>
					</f:facet>
                    <h:outputText value="#{lisfunc.pis}" />
	            </rich:column>
	            <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="CPF do Funcionario"/>
					</f:facet>
                    <h:outputText value="#{lisfunc.cpf}" />
	            </rich:column>
	            <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Departamento do Funcionario"/>
					</f:facet>
                    <h:outputText value="#{lisfunc.depto.nome}" />
	            </rich:column>
	            <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Chefe do Funcionario"/>
					</f:facet>
                    <h:outputText value="#{lisfunc.chefe.nome}" />
	            </rich:column>
	            <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Email do Funcionario"/>
					</f:facet>
                    <h:outputText value="#{lisfunc.email}" />
	            </rich:column>
	              <rich:column style="text-align:center;"><!-- Botao para alterar -->
	           	   <f:facet name="header">
               	   		<h:outputLabel value="Alterar"/>
               	   </f:facet>
                   <a4j:commandLink  value="" reRender="datalista,matriculafuncionario,nomefuncionario,pisfuncionario,cpffuncionario,departamentofuncionario,
					chefefuncionario,loginfuncionario,senhafuncionario,emailfuncionario"   >
					  <f:setPropertyActionListener value="#{lisfunc }" target="#{funcionarioManagerBean.funcionario }"/>
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
