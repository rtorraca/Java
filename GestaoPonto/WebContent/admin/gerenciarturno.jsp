<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>
<%@taglib prefix="rich" uri="http://richfaces.org/rich" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Turno</title>
</head>
<f:view>
<body>
<a4j:support event="onload" action="#{turnoManagerBean.limpar }" />
<h:form>
	
	<jsp:directive.include file="../admin/menuinclude.jsp" />
	
	<a4j:keepAlive beanName="turnoManagerBean"/>
	<a4j:keepAlive beanName="diaDaSemanaManagerBean"/>
	<a4j:keepAlive beanName="marcacaoManagerBean"/>
	
	<div align="left">
	<h:panelGroup layout="block" id="painelPrincipal">
	
	
	<rich:tabPanel 	id="abas" switchType="ajax" >
		<rich:tab id="tabturno" name="turno" label="Turno" focus="nometurno" >
	
		<!-- Começo do panel externo -->
		<rich:panel header="Cadastro Turno" >
			<rich:messages style="color:red;font-weight:bold"/>
			<!-- Começo do panelBar -->
			<rich:panelBar width="100%" height="100%">
				<!-- Começo do panelBarItem -->
				<rich:panelBarItem label="" >
					<a4j:commandLink action="#{turnoManagerBean.limpar}" title="Novo" reRender="nometurno,datalista">
						<img src="../images/novo.png" align="left"/>
					</a4j:commandLink>
					
					<a4j:commandLink action="voltar" title="Início">
						<img src="../images/home.jpg" align="right"/>
					</a4j:commandLink>
					
					<a4j:commandLink action="#{turnoManagerBean.excluirTurno}" title="Excluir" reRender="nometurno,datalista">
						<img src="../images/lixeira2.png" align="right"/>
					</a4j:commandLink>
				
					<a4j:commandLink action="#{turnoManagerBean.salvarTurno}" title="Salvar" reRender="nometurno,datalista">
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
                         <h:outputLabel value="Nome do turno"/>   
                     </td>
                     <td>      
                     	
                     	                              
                         <h:inputText id="nometurno"   value="#{turnoManagerBean.turno.nome}" size="70"  maxlength="150" >
                         	
	                    	</h:inputText>
                     </td>					
				</tr>
				<tr>
	                 <td colspan="2" >  
	                      <h:outputLabel value="*Campos Obrigatórios!" style="color:red;font-weight:bold;font-size:10px;"/>                                     
	                 </td>                                   
	            </tr>
	            
	            	
	            </table>
	            
	            <fieldset>
	            	<legend style="font-weight:bold" >Adicionar Funcionarios</legend>
					<h:panelGrid columns="2"  border="1" cellpadding="1" bgcolor="#BEBEBE" >
                 	
                 		<h:outputLabel value="Nome do Funcionario" style="font-weight:bold" />  
                     	                               
                         <h:inputText id="funcionario" value="#{turnoManagerBean.funcionario.nome}" size="30"/>
                     	 
       					<rich:suggestionbox id="suggestionboxid"  var="func" fetchValue="#{func.nome}" for="funcionario"
						 suggestionAction="#{funcionarioManagerBean.complemento }" >
             			<h:column>
                   			<h:outputText value="#{func.nome}"/>
            			</h:column>
                         <a4j:support event="onselect"  reRender="funcionario" ajaxSingle="true">
                             <f:setPropertyActionListener value="#{func}"
                                 target="#{turnoManagerBean.funcionario}" />
                      
                         </a4j:support>
           				</rich:suggestionbox>
           				<a4j:commandLink action="#{turnoManagerBean.adicionarFuncionario }" title="Adicionar" reRender="nometurno,datalista">
           					<img src="../images/btnIncluir.png" align="top"/>
           				</a4j:commandLink>
           				
           				
           				
           				</h:panelGrid>
           				
           				
           		</fieldset>
           			
           		
			
			
	           
		
			<!-- Fim da table -->
			<!-- Começo do panel interno -->
		<rich:panel header="Lista de turno" >
			<!-- Começo do dataTable -->
			<rich:dataTable width="100%" border="1" id="datalista0" var="listurno" value="#{turnoManagerBean.listaTurnos}" >
			
                <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Nome do Turno"/>
					</f:facet>
                    <h:outputText value="#{listurno.nome}" />
	            </rich:column>
	 
	           <rich:column style="text-align:center;"><!-- Botao para alterar -->
	           	   <f:facet name="header">
               	   		<h:outputLabel value="Alterar"/>
               	   </f:facet>
                   <a4j:commandLink  value="" reRender="datalista0,datalista1,nometurno" ajaxSingle="true">
                   <f:setPropertyActionListener value="#{listurno}" target="#{turnoManagerBean.turno}"/>
                   <f:setPropertyActionListener value="#{listurno}" target="#{diaDaSemanaManagerBean.diaDaSemana.turno }"/>
                      <img src="../images/editar.png"/> 
                   </a4j:commandLink>
               </rich:column> 
               
			</rich:dataTable>
			<!-- Fim da dataTable -->
		</rich:panel>
		<!-- Fim do panel interno -->
			
		
	</rich:panel>
	</rich:tab>
		<rich:tab id="tabdias" name="dias" label="Dias" focus="nomediadasemana" >
			
			<rich:panel header="Cadastro Marcacao" >
			<rich:messages style="color:red;font-weight:bold"/>
			<!-- Começo do panelBar -->
			<rich:panelBar>
				<!-- Começo do panelBarItem -->
				<rich:panelBarItem label="">
				
					<a4j:commandLink action="#{diaDaSemanaManagerBean.limpar}" title="Limpar" reRender="datalista1,tipodiadasemana,nomediadasemana,jornadadiadasemana">
						<img src="../images/novo.png" align="left"/>
					</a4j:commandLink>
					
					<a4j:commandLink action="voltar" title="Início">
						<img src="../images/home.jpg" align="right"/>
					</a4j:commandLink>
					
					<a4j:commandLink action="#{diaDaSemanaManagerBean.excluirDiaDaSemana}" title="Excluir" reRender="datalista1,tipodiadasemana,nomediadasemana,jornadadiadasemana">
						<img src="../images/lixeira2.png" align="right"/>
					</a4j:commandLink>
					
					<a4j:commandLink action="#{diaDaSemanaManagerBean.salvarDiaDaSemana}" title="Salvar" reRender="datalista1,tipodiadasemana,nomediadasemana,jornadadiadasemana">
						<f:setPropertyActionListener value="#{diaDaSemanaManagerBean.diaDaSemana}" target="#{marcacaoManagerBean.marcacao.dia }"/>
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
	     				Tipo dia
	                </td>
	                <td>                                      
	                    <h:selectOneMenu  id="tipodiadasemana" value="#{diaDaSemanaManagerBean.diaDaSemana.tipodia}" converter="tipoDiaConverter">
								<f:selectItems  value="#{diaDaSemanaManagerBean.listaTipoDias}" var="tipo" itemLabel="#{tipo.nome}"/>	       
						 </h:selectOneMenu>
	                </td>
	            </tr>
				
				<tr>
					<td>  
						<h:outputLabel value="*" style="color:red"/>                                    
	     				Nome:
	                </td>
	                <td>                                      
	                    <h:inputText id="nomediadasemana" value="#{diaDaSemanaManagerBean.diaDaSemana.nome}" />
	                </td>
	            </tr>
	            
	            <tr>
					<td> 
						<h:outputLabel value="*" style="color:red"/>                                     
	     				Jornada:
	                </td>
	                <td>                                      
	                    <h:inputText id="jornadadiadasemana" value="#{diaDaSemanaManagerBean.diaDaSemana.jornada}" />
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
		<rich:panel header="Lista de Dias" >
		
			<!-- Começo do dataTable -->
			<rich:dataTable width="100%" border="1" rendered="true" id="datalista1" var="lisdiadasemana" value="#{turnoManagerBean.listaDias}" >
          
                <rich:column >
                   	<f:facet name="header">
 						<h:outputText  value="Nome do turno"/>
					</f:facet>
                    <h:outputText value="#{lisdiadasemana.turno.nome}"/>
                </rich:column>
                 <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Nome"/>
					</f:facet>
                    <h:outputText value="#{lisdiadasemana.nome}" > 
                    </h:outputText>
	            </rich:column>
                <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Tipo dia"/>
					</f:facet>
                    <h:outputText value="#{lisdiadasemana.tipodia.nome}" >
                    	
                    </h:outputText>
	            </rich:column>
	             <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Jornada"/>
					</f:facet>
                    <h:outputText value="#{lisdiadasemana.jornada}" > 
                    </h:outputText>
	            </rich:column>
	           
	            <rich:column style="text-align:center;"><!-- Botao para alterar -->
	           	   <f:facet name="header">
               	   		<h:outputLabel value="Alterar"/>
               	   </f:facet>
                   <a4j:commandLink  value="" reRender="datalista1,datalista2,tipodiadasemana,nomediadasemana,jornadadiadasemana"  >
                    <f:setPropertyActionListener value="#{lisdiadasemana}" target="#{diaDaSemanaManagerBean.diaDaSemana}"/>
                     <f:setPropertyActionListener value="#{lisdiadasemana}" target="#{marcacaoManagerBean.marcacao.dia}"/>
                      <img src="../images/editar.png"/> 
                   </a4j:commandLink>
               </rich:column> 
			</rich:dataTable>
			<!-- Fim da dataTable -->
		</rich:panel>
		<!-- Fim do panel interno -->
		
		
		</rich:panel>
			
		</rich:tab>
		<rich:tab id="tabmarcacao" name="marcacao" label="Marcacoes" focus="tipomarcacao" >
			<rich:panel header="Cadastro Marcacao" >
			<rich:messages style="color:red;font-weight:bold"/>
			<!-- Começo do panelBar -->
			<rich:panelBar>
				<!-- Começo do panelBarItem -->
				<rich:panelBarItem label="">
					<a4j:commandLink action="#{marcacaoManagerBean.limpar}" title="Limpar" reRender="datalista2,tipomarcacao,nomemarcacao,horariomarcacao">
						<img src="../images/novo.png" align="left"/>
					</a4j:commandLink>
					
					<a4j:commandLink action="voltar" title="Voltar">
						<img src="../images/home.jpg" align="right"/>
					</a4j:commandLink>
					
					<a4j:commandLink action="#{marcacaoManagerBean.excluirMarcacao}" title="Excluir" reRender="datalista2,tipomarcacao,nomemarcacao,horariomarcacao">
						<img src="../images/lixeira2.png"align="right"/>
					</a4j:commandLink>
				
					
					<a4j:commandLink action="#{marcacaoManagerBean.salvarMarcacao}" title="Salvar" reRender="datalista2,tipomarcacao,nomemarcacao,horariomarcacao">
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
	     				Tipo Marcacao
	                </td>
	                <td>                                      
	                    <h:selectOneMenu  id="tipomarcacao" value="#{marcacaoManagerBean.marcacao.tipomarcacao}" >
								<f:selectItem itemValue="e" itemLabel="Entrada"/>
								<f:selectItem itemValue="s" itemLabel="Saida"/>	       
						 </h:selectOneMenu>
	                </td>
	            </tr>
				
				<tr>
					<td>  
						<h:outputLabel value="*" style="color:red"/>                                    
	     				Nome:
	                </td>
	                <td>                                      
	                    <h:inputText id="nomemarcacao" value="#{marcacaoManagerBean.marcacao.nome}" />
	                </td>
	            </tr>
	            
	            <tr>
					
	                 <td>  
	                 	<h:outputLabel value="*" style="color:red"/>
	                   <h:outputLabel value="Horario:"/>
	                   </td>
	                   <td>
	                   
                      <h:selectOneMenu id="horamarcacao" value="#{marcacaoManagerBean.hora}" >
                      	<f:selectItem itemValue="0" itemLabel="00"/>
                      	<f:selectItem itemValue="1" itemLabel="01"/>
                      	<f:selectItem itemValue="2" itemLabel="02"/>
                      	<f:selectItem itemValue="3" itemLabel="03"/>
                      	<f:selectItem itemValue="4" itemLabel="04"/>
                      	<f:selectItem itemValue="5" itemLabel="05"/>
                      	<f:selectItem itemValue="6" itemLabel="06"/>
                      	<f:selectItem itemValue="7" itemLabel="07"/>
                      	<f:selectItem itemValue="8" itemLabel="08"/>
                      	<f:selectItem itemValue="9" itemLabel="09"/>
                      	<f:selectItem itemValue="10" itemLabel="10"/>
                      	<f:selectItem itemValue="11" itemLabel="11"/>
                      	<f:selectItem itemValue="12" itemLabel="12"/>
                      	<f:selectItem itemValue="13" itemLabel="13"/>
                      	<f:selectItem itemValue="14" itemLabel="14"/>
                      	<f:selectItem itemValue="15" itemLabel="15"/>
                      	<f:selectItem itemValue="16" itemLabel="16"/>
                      	<f:selectItem itemValue="17" itemLabel="17"/>
                      	<f:selectItem itemValue="18" itemLabel="18"/>
                      	<f:selectItem itemValue="19" itemLabel="19"/>
                      	<f:selectItem itemValue="20" itemLabel="20"/>
                      	<f:selectItem itemValue="21" itemLabel="21"/>
                      	<f:selectItem itemValue="22" itemLabel="22"/>
                      	<f:selectItem itemValue="23" itemLabel="23"/>
                      </h:selectOneMenu> 
                      :
                      <h:selectOneMenu id="minutomarcacao" value="#{marcacaoManagerBean.minuto}" >
                      	<f:selectItem itemValue="0" itemLabel="00"/>
                      	<f:selectItem itemValue="1" itemLabel="01"/>
                      	<f:selectItem itemValue="2" itemLabel="02"/>
                      	<f:selectItem itemValue="3" itemLabel="03"/>
                      	<f:selectItem itemValue="4" itemLabel="04"/>
                      	<f:selectItem itemValue="5" itemLabel="05"/>
                      	<f:selectItem itemValue="6" itemLabel="06"/>
                      	<f:selectItem itemValue="7" itemLabel="07"/>
                      	<f:selectItem itemValue="8" itemLabel="08"/>
                      	<f:selectItem itemValue="9" itemLabel="09"/>
                      	<f:selectItem itemValue="10" itemLabel="10"/>
                      	<f:selectItem itemValue="11" itemLabel="11"/>
                      	<f:selectItem itemValue="12" itemLabel="12"/>
                      	<f:selectItem itemValue="13" itemLabel="13"/>
                      	<f:selectItem itemValue="14" itemLabel="14"/>
                      	<f:selectItem itemValue="15" itemLabel="15"/>
                      	<f:selectItem itemValue="16" itemLabel="16"/>
                      	<f:selectItem itemValue="17" itemLabel="17"/>
                      	<f:selectItem itemValue="18" itemLabel="18"/>
                      	<f:selectItem itemValue="19" itemLabel="19"/>
                      	<f:selectItem itemValue="20" itemLabel="20"/>
                      	<f:selectItem itemValue="21" itemLabel="21"/>
                      	<f:selectItem itemValue="22" itemLabel="22"/>
                      	<f:selectItem itemValue="23" itemLabel="23"/>
                      	<f:selectItem itemValue="24" itemLabel="24"/>
                      	<f:selectItem itemValue="25" itemLabel="25"/>
                      	<f:selectItem itemValue="26" itemLabel="26"/>
                      	<f:selectItem itemValue="27" itemLabel="27"/>
                      	<f:selectItem itemValue="28" itemLabel="28"/>
                      	<f:selectItem itemValue="29" itemLabel="29"/>
                      	<f:selectItem itemValue="30" itemLabel="30"/>
                      	<f:selectItem itemValue="31" itemLabel="31"/>
                      	<f:selectItem itemValue="32" itemLabel="32"/>
                      	<f:selectItem itemValue="33" itemLabel="33"/>
                      	<f:selectItem itemValue="34" itemLabel="34"/>
                      	<f:selectItem itemValue="35" itemLabel="35"/>
                      	<f:selectItem itemValue="36" itemLabel="36"/>
                      	<f:selectItem itemValue="37" itemLabel="37"/>
                      	<f:selectItem itemValue="38" itemLabel="38"/>
                      	<f:selectItem itemValue="39" itemLabel="39"/>
                      	<f:selectItem itemValue="40" itemLabel="40"/>
                      	<f:selectItem itemValue="41" itemLabel="41"/>
                      	<f:selectItem itemValue="42" itemLabel="42"/>
                      	<f:selectItem itemValue="43" itemLabel="43"/>
                      	<f:selectItem itemValue="44" itemLabel="44"/>
                      	<f:selectItem itemValue="45" itemLabel="45"/>
                      	<f:selectItem itemValue="46" itemLabel="46"/>
                      	<f:selectItem itemValue="47" itemLabel="47"/>
                      	<f:selectItem itemValue="48" itemLabel="48"/>
                      	<f:selectItem itemValue="49" itemLabel="49"/>
                      	<f:selectItem itemValue="50" itemLabel="50"/>
                      	<f:selectItem itemValue="51" itemLabel="51"/>
                      	<f:selectItem itemValue="52" itemLabel="52"/>
                      	<f:selectItem itemValue="53" itemLabel="53"/>
                      	<f:selectItem itemValue="54" itemLabel="54"/>
                      	<f:selectItem itemValue="55" itemLabel="55"/>
                      	<f:selectItem itemValue="56" itemLabel="56"/>
                      	<f:selectItem itemValue="57" itemLabel="57"/>
                      	<f:selectItem itemValue="58" itemLabel="58"/>
                      	<f:selectItem itemValue="59" itemLabel="59"/>
                      </h:selectOneMenu> 
					                                          
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
		<rich:panel header="Lista de marcacoes" >
			<!-- Começo do dataTable -->
			<rich:dataTable width="100%" border="1" id="datalista2" var="lismarcacao" value="#{diaDaSemanaManagerBean.listaMarcacoes}" >
   
                <rich:column >
                   	<f:facet name="header">
 						<h:outputText  value="Nome do dia"/>
					</f:facet>
                    <h:outputText value="#{lismarcacao.dia.nome}"/>
                </rich:column>
                 <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Nome"/>
					</f:facet>
                    <h:outputText value="#{lismarcacao.nome}" > 
                    </h:outputText>
	            </rich:column>
                <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Tipo marcacao"/>
					</f:facet>
                    <h:outputText value="#{lismarcacao.tipomarcacao}" >
                    	
                    </h:outputText>
	            </rich:column>
	             <rich:column>
                    <f:facet name="header">
 						<h:outputText  value="Horario"/>
					</f:facet>
                    <h:outputText value="#{lismarcacao.horario}" >
                    	<f:convertDateTime pattern="HH:mm"/> 
                    </h:outputText>
	            </rich:column>
	           
	            <rich:column style="text-align:center;"><!-- Botao para alterar -->
	           	   <f:facet name="header">
               	   		<h:outputLabel value="Alterar"/>
               	   </f:facet>
                   <a4j:commandLink  value="" reRender="datalista2,tipomarcacao,nomemarcacao,horariomarcacao" >
                     <f:setPropertyActionListener value="#{lismarcacao}" target="#{marcacaoManagerBean.marcacao}"/>
                     <f:setPropertyActionListener value="#{lismarcacao.dia}" target="#{marcacaoManagerBean.marcacao.dia}"/>
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
