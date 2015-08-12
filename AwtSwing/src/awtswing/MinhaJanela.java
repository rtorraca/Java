/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package awtswing;
import javax.swing.*;
/**
 *
 * @author robson
 * Livro página : 47
 */
public class MinhaJanela extends Janela{
    
    
           public MinhaJanela(){
            titulo = "Essa é uma classe personalizada";
            altura = 600;
            largura = 800;
            redimensionavel = true;
            icone = "box.gif";
            modo = "maximizada";
            mostrar();
        }
        
    
public static void main(String args[]){
    
    MinhaJanela app = new MinhaJanela();

}
    
    
}
