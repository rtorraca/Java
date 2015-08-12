/** 
* 
*/ 
package awtswing;
//package com.diretorios; 
import java.io.File; 
import java.io.IOException; 

/** 
* @author fernando.borges 
* 
*/ 
public class VisualizarArquivos { 

private String diretorio = "B:\\distribuicao\\jakarta-bi\\webapps\\bi10.02\\WEB-INF\\lib"; 

/** 
* 
*/ 
public VisualizarArquivos() throws IOException { 

File file = new File(diretorio); 
File afile[] = file.listFiles(); 
int i = 0; 
for (int j = afile.length; i < j; i++) { 
File arquivos = afile[i]; 
System.out.println(arquivos.getName()); 
} 

} 

/** 
* @param args 
*/ 
public static void main(String[] args) { 
try { 
VisualizarArquivos v = new VisualizarArquivos(); 
} catch (IOException e) { 
// TODO Auto-generated catch block 
e.printStackTrace(); 
} 

} 

} 