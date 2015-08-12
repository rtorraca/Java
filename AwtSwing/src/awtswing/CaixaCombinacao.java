/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awtswing;

/**
 *
 * @author rtorraca
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CaixaCombinacao extends JFrame {
    
    JComboBox lista;
    String linguagens[]={"C++","Java","Pyton"};
    
    public CaixaCombinacao(){
        
        super("Uso da classe JComboBox");
        Container tela = getContentPane();
        FlowLayout Layout = new FlowLayout();
        
        tela.setLayout(Layout);
        Tratador trat = new Tratador();
        lista = new JComboBox(linguagens);
        lista.setMaximumRowCount(5);
        JButton exibirBtn = new JButton("Exibir valor Selecionado");  
        exibirBtn.addActionListener(trat);
        tela.add(lista);
        tela.add(exibirBtn);
        setSize(300,100);
        setVisible(true);
               
    }
    
    public static void main(String args[]){
        CaixaCombinacao app = new CaixaCombinacao();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
    }
    
    private class Tratador implements ActionListener{
    public void actionPerformed(ActionEvent e){
        String escolha = linguagens[lista.getSelectedIndex()];
        JOptionPane.showMessageDialog(null,"Linguagem"+escolha);
    }
}
    
}
