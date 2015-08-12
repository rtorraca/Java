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
 * Livro Página: 41
 */
public class DefinirIcone extends JFrame{
    
    
    public DefinirIcone(){
        super("Como definir o ícone para a Janela");
        ImageIcon icone = new ImageIcon("box.gif");
        setIconImage(icone.getImage());
  
        }
    
    
    
    public static void main(String args[]){
        DefinirIcone app = new DefinirIcone();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    }
    
}
