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
 * Minha Classe Janela Livro Página : 45
 */
public class Janela extends JFrame{
    
    
    protected int largura = 300, altura = 150;
    protected String titulo = "Sem título";
    protected String icone = "padrao";
    protected boolean redimensionavel = true;
    protected String modo = "normal";

public void mostrar(){
    this.setSize(largura, altura);
    this.setTitle(titulo);
    
    
    if(icone != "padrao"){
        ImageIcon iconeImg=new ImageIcon(icone);
        setIconImage(iconeImg.getImage());
    }

this.setResizable(redimensionavel);
this.setVisible(true);

if(modo=="normal")
    setExtendedState(NORMAL);
else if(modo=="minimizada")
    setExtendedState(ICONIFIED);

else setExtendedState(MAXIMIZED_BOTH);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}
