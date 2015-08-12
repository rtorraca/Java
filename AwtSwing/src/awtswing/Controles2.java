/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package awtswing;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author robson
 * Livro Página: 54
 */
public class Controles2 extends JFrame{
    
    public Controles2(){
        super("Adicionando controles à janela");
        Container tela = getContentPane();
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        tela.setLayout(layout);
    }
    
    
    
    public static void main(String args[]){
        
        Controles2 app = new Controles2();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
}
