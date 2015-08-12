/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 *
 * @author robson
 */
public class ICMPSwing {
    
    
    public static void main(String args[]) throws UnknownHostException, IOException 
    {
        
          String ipAddress="127.0.0.1";
          
          InetAddress inet = InetAddress.getByName(ipAddress);
              
        //System.out.println("Enviando pacote ICMP  via porta  " + ipAddress);
        JOptionPane.showMessageDialog(null,"Testando sua interface de rede...");
        
        JOptionPane.showMessageDialog(null,inet.isReachable(5000) ? "Sua interface de rede está ativa" : "Sua interface de rede não está ativa");
        
        ipAddress = JOptionPane.showInputDialog("Digite o IP:");
        
       
        //System.out.println(inet.isReachable(5000) ? "Host está acessível" : "Host não está acessível");
        
         inet = InetAddress.getByName(ipAddress);

        JOptionPane.showMessageDialog(null,inet.isReachable(5000) ? "Host está acessível" : "Host não está acessível");
        
        System.exit(0);
    }
    
    
}
