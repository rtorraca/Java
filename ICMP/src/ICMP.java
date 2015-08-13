
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rtorraca
 */
public class ICMP {
public static void main(String[] args) throws UnknownHostException, IOException {
    
    String ipAddress = "127.0.0.1";
    InetAddress inet = InetAddress.getByName(ipAddress);

    System.out.println("Enviando pacote ICMP  via porta  " + ipAddress);
    
    System.out.println(inet.isReachable(5000) ? "Host está acessível" : "Host não está acessível");

    ipAddress = "192.168.0.1";
    inet = InetAddress.getByName(ipAddress);

    System.out.println("Sending Ping Request to " + ipAddress);
    System.out.println(inet.isReachable(5000) ? "Host está acessível" : "Host não está acessível");

}
    
}
