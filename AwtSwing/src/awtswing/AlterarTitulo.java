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
 */
public class AlterarTitulo extends JFrame{
 
    public AlterarTitulo(){
        
    setSize(300,150);
    setVisible(true);
    
    }
    
    
    
    
    public static void main(String args[]){
        
        AlterarTitulo app=new AlterarTitulo();
        
        
        if(args.length<1) app.setTitle("Sem Titulo");
        else app.setTitle(args[0]);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
  
    }
    
}
